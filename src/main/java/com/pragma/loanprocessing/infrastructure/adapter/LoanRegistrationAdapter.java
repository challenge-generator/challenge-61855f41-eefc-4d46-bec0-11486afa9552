package com.pragma.loanprocessing.infrastructure.adapter;


import com.pragma.loanprocessing.domain.model.Status;
import com.pragma.loanprocessing.domain.model.Applicant;
import com.pragma.loanprocessing.domain.model.LoanApplication;
import com.pragma.loanprocessing.domain.port.LoanRegistrationPort;
import com.pragma.loanprocessing.infrastructure.exception.DuplicateLoanException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Repository
public class LoanRegistrationAdapter implements LoanRegistrationPort {

    private static final Logger log = LoggerFactory.getLogger(LoanRegistrationAdapter.class);
    
    private final Map<String, LoanApplication> applicationStore = new ConcurrentHashMap<>();
    private final Map<UUID, LoanApplication> idStore = new ConcurrentHashMap<>();
    private final Map<UUID, Applicant> applicantStore = new ConcurrentHashMap<>();
    private long applicationCounter = 0;

    @Override
    @Transactional
    public CompletionStage<LoanApplication> registerLoanApplication(LoanApplication loanApplication) {
        log.info("Registrando solicitud de préstamo: {}", loanApplication.applicationNumber());
        
        return CompletableFuture.supplyAsync(() -> {
            if (existsByApplicationNumberSync(loanApplication.applicationNumber())) {
                log.warn("Solicitud duplicada detectada: {}", loanApplication.applicationNumber());
                throw new DuplicateLoanException(
                        "Ya existe una solicitud con el número: " + loanApplication.applicationNumber()
                );
            }
            
            LoanApplication savedApplication = loanApplication.toBuilder()
                    .id(UUID.randomUUID())
                    .applicationNumber(generateApplicationNumber())
                    .status(LoanApplication.Status.PENDING)
                    .applicationDate(LocalDateTime.now())
                    .build();
            
            applicationStore.put(savedApplication.applicationNumber(), savedApplication);
            idStore.put(savedApplication.getId(), savedApplication);
            applicantStore.put(savedApplication.getId(), loanApplication.applicant());
            
            log.info("Solicitud registrada exitosamente: {} con ID: {}", 
                    savedApplication.applicationNumber(), savedApplication.getId());
            
            return savedApplication;
        });
    }

    private boolean existsByApplicationNumberSync(String applicationNumber) {
        return applicationStore.containsKey(applicationNumber);
    }

    @Override
    public CompletionStage<Boolean> existsByApplicationNumber(String applicationNumber) {
        log.debug("Verificando existencia de solicitud: {}", applicationNumber);
        return CompletableFuture.completedFuture(applicationStore.containsKey(applicationNumber));
    }

    @Override
    @Transactional
    public CompletionStage<LoanApplication> updateApplicationStatus(UUID applicationId, 
                                                                      LoanApplication.Status newStatus) {
        log.info("Actualizando estado de solicitud {} a {}", applicationId, newStatus);
        
        return CompletableFuture.supplyAsync(() -> {
            LoanApplication existing = idStore.get(applicationId);
            if (existing == null) {
                log.error("Solicitud no encontrada: {}", applicationId);
                throw new IllegalArgumentException("Solicitud no encontrada: " + applicationId);
            }
            
            LoanApplication updated = existing.toBuilder()
                    .status(newStatus)
                    .build();
            
            applicationStore.put(updated.applicationNumber(), updated);
            idStore.put(applicationId, updated);
            
            log.info("Estado actualizado exitosamente: {} -> {}", applicationId, newStatus);
            return updated;
        });
    }

    @Override
    public CompletionStage<LoanApplication> getApplicationById(UUID applicationId) {
        log.debug("Obteniendo solicitud por ID: {}", applicationId);
        return CompletableFuture.completedFuture(idStore.get(applicationId));
    }

    @Override
    public CompletionStage<Applicant> getApplicantForApplication(UUID applicationId) {
        log.debug("Obteniendo solicitante para aplicación: {}", applicationId);
        return CompletableFuture.completedFuture(applicantStore.get(applicationId));
    }

    private synchronized String generateApplicationNumber() {
        applicationCounter++;
        return String.format("LOAN-%d-%04d", 
                System.currentTimeMillis() % 10000, 
                applicationCounter);
    }
}