package com.pragma.loanprocessing.application.service;

import com.pragma.loanprocessing.domain.model.Applicant;
import com.pragma.loanprocessing.domain.model.LoanApplication;
import com.pragma.loanprocessing.domain.port.LoanEvaluationPort;
import com.pragma.loanprocessing.infrastructure.exception.LoanEvaluationException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class LoanEvaluationService {

    private static final Logger log = LoggerFactory.getLogger(LoanEvaluationService.class);
    private static final int DEFAULT_MINIMUM_AGE = 18;
    private static final int DEFAULT_MINIMUM_CREDIT_SCORE = 600;
    private static final BigDecimal DEFAULT_INCOME_MULTIPLIER = new BigDecimal("4");
    private static final String CIRCUIT_BREAKER_NAME = "loanEvaluation";
    private static final String RETRY_NAME = "loanEvaluation";
    private static final String TIME_LIMITER_NAME = "loanEvaluation";

    private final LoanEvaluationPort loanEvaluationPort;

    public LoanEvaluationService(LoanEvaluationPort loanEvaluationPort) {
        this.loanEvaluationPort = loanEvaluationPort;
    }

    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "evaluateEligibilityFallback")
    @Retry(name = RETRY_NAME)
    @TimeLimiter(name = TIME_LIMITER_NAME)
    public CompletionStage<LoanApplication> evaluateAndCreateApplication(
            Applicant applicant, BigDecimal requestedAmount, String applicationNumber) {
        
        log.info("Iniciando evaluación de elegibilidad para solicitante: {} con monto: {}", 
                applicant.identificationNumber(), requestedAmount);

        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean eligibilityResult = loanEvaluationPort.evaluateEligibility(
                        applicant, 
                        requestedAmount.doubleValue()
                ).get(2, TimeUnit.SECONDS);

                Integer creditScore = loanEvaluationPort.getCreditScore(
                        applicant.identificationNumber()
                ).get(2, TimeUnit.SECONDS);

                Boolean hasOverdue = loanEvaluationPort.hasOverdueDebts(
                        applicant.identificationNumber()
                ).get(2, TimeUnit.SECONDS);

                String reason = buildEvaluationReason(applicant, requestedAmount, creditScore, hasOverdue);

                return LoanApplication.create(
                        applicant,
                        requestedAmount,
                        applicationNumber,
                        eligibilityResult,
                        reason,
                        creditScore,
                        hasOverdue != null && hasOverdue
                );

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new LoanEvaluationException("Evaluación interrumpida para solicitante: " 
                        + applicant.identificationNumber(), e);
            } catch (ExecutionException e) {
                throw new LoanEvaluationException("Error en evaluación de solicitante: " 
                        + applicant.identificationNumber(), e);
            } catch (TimeoutException e) {
                throw new LoanEvaluationException("Timeout en evaluación de solicitante: " 
                        + applicant.identificationNumber(), e);
            }
        });
    }

    private String buildEvaluationReason(Applicant applicant, BigDecimal requestedAmount, 
                                          Integer creditScore, Boolean hasOverdue) {
        StringBuilder reason = new StringBuilder();
        
        if (!applicant.meetsMinimumAgeRequirement(DEFAULT_MINIMUM_AGE)) {
            reason.append("Edad mínima no cumplida. ");
        }
        
        if (!applicant.hasSufficientIncome(requestedAmount, DEFAULT_INCOME_MULTIPLIER)) {
            reason.append("Ingresos insuficientes para el monto solicitado. ");
        }
        
        if (!applicant.hasAcceptableCreditScore(DEFAULT_MINIMUM_CREDIT_SCORE)) {
            reason.append("Score crediticio insuficiente. ");
        }
        
        if (hasOverdue != null && hasOverdue) {
            reason.append("Tiene deudas vencidas. ");
        }
        
        if (reason.length() == 0) {
            return "Elegible según criterios establecidos";
        }
        
        return reason.toString().trim();
    }

    private LoanApplication evaluateEligibilityFallback(Applicant applicant, BigDecimal requestedAmount, 
                                                         String applicationNumber, Throwable t) {
        log.error("Fallback activado para solicitante {}: {}", applicant.identificationNumber(), t.getMessage());
        
        return LoanApplication.create(
                applicant,
                requestedAmount,
                applicationNumber,
                false,
                "Error en evaluación: servicio no disponible temporalmente. Intente más tarde.",
                null,
                false
        );
    }

    public boolean validateApplicantRequirements(Applicant applicant, BigDecimal requestedAmount) {
        if (applicant == null || requestedAmount == null) {
            return false;
        }
        
        return applicant.meetsMinimumAgeRequirement(DEFAULT_MINIMUM_AGE)
                && applicant.hasSufficientIncome(requestedAmount, DEFAULT_INCOME_MULTIPLIER)
                && applicant.hasAcceptableCreditScore(DEFAULT_MINIMUM_CREDIT_SCORE);
    }
}