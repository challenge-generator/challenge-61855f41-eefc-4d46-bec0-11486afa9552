package com.pragma.loanprocessing.infrastructure.adapter;

import com.pragma.loanprocessing.domain.model.Applicant;
import com.pragma.loanprocessing.domain.port.LoanEvaluationPort;
import com.pragma.loanprocessing.infrastructure.exception.LoanEvaluationException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

@Component
public class LoanEvaluationAdapter implements LoanEvaluationPort {

    private static final Logger log = LoggerFactory.getLogger(LoanEvaluationAdapter.class);
    private static final int MINIMUM_AGE = 18;
    private static final int MINIMUM_CREDIT_SCORE = 600;
    private static final BigDecimal INCOME_MULTIPLIER = new BigDecimal("4");
    private static final int TIMEOUT_SECONDS = 2;

    private final CircuitBreaker circuitBreaker;
    private final Retry retry;

    public LoanEvaluationAdapter(CircuitBreakerRegistry circuitBreakerRegistry, 
                                  RetryRegistry retryRegistry) {
        this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("loanEvaluation");
        this.retry = retryRegistry.retry("loanEvaluation");
        log.info("LoanEvaluationAdapter inicializado con CircuitBreaker y Retry configurados");
    }

    @Override
    public CompletionStage<Boolean> evaluateEligibility(Applicant applicant, double requestedAmount) {
        log.info("Iniciando evaluación de elegibilidad para solicitante: {}", applicant.identificationNumber());
        
        Supplier<CompletionStage<Boolean>> decoratedSupplier = CircuitBreaker.decorateCompletionStage(
                circuitBreaker,
                Retry.decorateCompletionStage(retry,
                        () -> performEvaluation(applicant, requestedAmount)
                )
        );
        
        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            log.error("Error en evaluación de elegibilidad: {}", e.getMessage());
            return CompletableFuture.failedFuture(
                    new LoanEvaluationException("Error al evaluar elegibilidad: " + e.getMessage())
            );
        }
    }

    private CompletionStage<Boolean> performEvaluation(Applicant applicant, double requestedAmount) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
                
                boolean meetsAge = applicant.meetsMinimumAgeRequirement(MINIMUM_AGE);
                boolean hasIncome = applicant.hasSufficientIncome(
                        BigDecimal.valueOf(requestedAmount), 
                        INCOME_MULTIPLIER
                );
                boolean hasCreditScore = applicant.hasAcceptableCreditScore(MINIMUM_CREDIT_SCORE);
                
                boolean eligible = meetsAge && hasIncome && hasCreditScore;
                
                log.info("Evaluación completada para {}: elegible={}", 
                        applicant.identificationNumber(), eligible);
                
                return eligible;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new LoanEvaluationException("Evaluación interrumpida");
            }
        });
    }

    @Override
    public CompletionStage<Integer> getCreditScore(String identificationNumber) {
        log.debug("Obteniendo score crediticio para: {}", identificationNumber);
        
        Supplier<CompletionStage<Integer>> decoratedSupplier = CircuitBreaker.decorateCompletionStage(
                circuitBreaker,
                Retry.decorateCompletionStage(retry,
                        () -> fetchCreditScore(identificationNumber)
                )
        );
        
        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            log.error("Error al obtener credit score: {}", e.getMessage());
            return CompletableFuture.failedFuture(
                    new LoanEvaluationException("Error al obtener credit score: " + e.getMessage())
            );
        }
    }

    private CompletionStage<Integer> fetchCreditScore(String identificationNumber) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(50);
                int score = 650 + (identificationNumber.hashCode() % 150);
                log.debug("Credit score obtenido: {}", score);
                return score;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new LoanEvaluationException("Error al obtener credit score");
            }
        });
    }

    @Override
    public CompletionStage<Boolean> hasOverdueDebts(String identificationNumber) {
        log.debug("Verificando deudas vencidas para: {}", identificationNumber);
        
        Supplier<CompletionStage<Boolean>> decoratedSupplier = CircuitBreaker.decorateCompletionStage(
                circuitBreaker,
                Retry.decorateCompletionStage(retry,
                        () -> checkOverdueDebts(identificationNumber)
                )
        );
        
        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            log.error("Error al verificar deudas vencidas: {}", e.getMessage());
            return CompletableFuture.failedFuture(
                    new LoanEvaluationException("Error al verificar deudas: " + e.getMessage())
            );
        }
    }

    private CompletionStage<Boolean> checkOverdueDebts(String identificationNumber) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(50);
                boolean hasDebts = identificationNumber.hashCode() % 3 == 0;
                log.debug("Deudas vencidas verificadas: {}", hasDebts);
                return hasDebts;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new LoanEvaluationException("Error al verificar deudas vencidas");
            }
        });
    }
}