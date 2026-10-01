package com.pragma.loanprocessing.application.usecase;


import com.pragma.loanprocessing.domain.model.Status;
import com.pragma.loanprocessing.domain.model.Applicant;
import com.pragma.loanprocessing.domain.model.LoanApplication;
import com.pragma.loanprocessing.domain.port.LoanRegistrationPort;
import com.pragma.loanprocessing.infrastructure.exception.DuplicateLoanException;
import com.pragma.loanprocessing.infrastructure.exception.LoanEvaluationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class RegisterLoanUseCase {

    private static final Logger log = LoggerFactory.getLogger(RegisterLoanUseCase.class);
    private static final int REGISTRATION_TIMEOUT_SECONDS = 3;

    private final LoanRegistrationPort loanRegistrationPort;

    public RegisterLoanUseCase(LoanRegistrationPort loanRegistrationPort) {
        this.loanRegistrationPort = loanRegistrationPort;
    }

    public CompletionStage<LoanApplication> execute(Applicant applicant, BigDecimal requestedAmount) {
        String applicationNumber = generateApplicationNumber(applicant.identificationNumber());
        
        log.info("Iniciando registro de solicitud con número: {}", applicationNumber);

        return checkIdempotency(applicationNumber)
                .thenCompose(exists -> {
                    if (Boolean.TRUE.equals(exists)) {
                        log.warn("Solicitud duplicada detectada para número: {}", applicationNumber);
                        CompletableFuture<LoanApplication> failedFuture = new CompletableFuture<>();
                        failedFuture.completeExceptionally(
                                new DuplicateLoanException("Ya existe una solicitud con número: " + applicationNumber)
                        );
                        return failedFuture;
                    }
                    
                    return retrieveApplicantData(applicant)
                            .thenCompose retrievedApplicant -> {
                                if (retrievedApplicant == null) {
                                    log.info("Datos del solicitante no encontrados, usando datos originales");
                                    retrievedApplicant = applicant;
                                }
                                
                                LoanApplication loanApplication = LoanApplication.create(
                                        retrievedApplicant,
                                        requestedAmount,
                                        applicationNumber,
                                        true,
                                        "Solicitud registrada exitosamente",
                                        null,
                                        false
                                );
                                
                                return loanRegistrationPort.registerLoanApplication(loanApplication)
                                        .thenApply(registered -> {
                                            log.info("Solicitud {} registrada exitosamente con ID: {}", 
                                                    applicationNumber, registered.getId());
                                            return registered;
                                        });
                            };
                })
                .exceptionally(ex -> {
                    log.error("Error en registro de solicitud {}: {}", applicationNumber, ex.getMessage());
                    if (ex.getCause() instanceof DuplicateLoanException) {
                        throw (DuplicateLoanException) ex.getCause();
                    }
                    throw new LoanEvaluationException("Error al registrar solicitud: " + ex.getMessage(), ex);
                });
    }

    private CompletionStage<Boolean> checkIdempotency(String applicationNumber) {
        log.debug("Verificando idempotencia para número de solicitud: {}", applicationNumber);
        return loanRegistrationPort.existsByApplicationNumber(applicationNumber);
    }

    private CompletionStage<Applicant> retrieveApplicantData(Applicant applicant) {
        log.debug("Recuperando datos actualizados del solicitante: {}", applicant.identificationNumber());
        return CompletableFuture.completedFuture(applicant);
    }

    private String generateApplicationNumber(String identificationNumber) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String uuidSuffix = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return String.format("LN-%s-%s", identificationNumber, uuidSuffix);
    }

    public CompletionStage<LoanApplication> getApplicationById(UUID applicationId) {
        log.debug("Consultando solicitud por ID: {}", applicationId);
        return loanRegistrationPort.getApplicationById(applicationId);
    }

    public CompletionStage<LoanApplication> updateApplicationStatus(UUID applicationId, 
                                                                      LoanApplication.Status newStatus) {
        log.info("Actualizando estado de solicitud {} a {}", applicationId, newStatus);
        
        if (applicationId == null || newStatus == null) {
            CompletableFuture<LoanApplication> failedFuture = new CompletableFuture<>();
            failedFuture.completeExceptionally(
                    new IllegalArgumentException("El ID de aplicación y el nuevo estado son obligatorios")
            );
            return failedFuture;
        }
        
        return loanRegistrationPort.updateApplicationStatus(applicationId, newStatus)
                .thenApply(updated -> {
                    log.info("Estado de solicitud {} actualizado exitosamente a {}", 
                            applicationId, newStatus);
                    return updated;
                });
    }

    public CompletionStage<LoanApplication> retryRegistration(Applicant applicant, 
                                                               BigDecimal requestedAmount, 
                                                               String originalApplicationNumber) {
        log.info("Reintentando registro de solicitud con número original: {}", originalApplicationNumber);
        return loanRegistrationPort.existsByApplicationNumber(originalApplicationNumber)
                .thenCompose(exists -> {
                    if (Boolean.TRUE.equals(exists)) {
                        log.info("Recuperando solicitud existente: {}", originalApplicationNumber);
                        return loanRegistrationPort.getApplicationById(
                                UUID.nameUUIDFromBytes(originalApplicationNumber.getBytes())
                        );
                    }
                    
                    return execute(applicant, requestedAmount);
                });
    }
}