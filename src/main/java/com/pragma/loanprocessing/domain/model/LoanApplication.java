package com.pragma.loanprocessing.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class LoanApplication {
    
    private final UUID id;
    private final Applicant applicant;
    private final BigDecimal requestedAmount;
    private final Status status;
    private final String applicationNumber;
    private final Boolean evaluationResult;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final String evaluationReason;
    private final Integer creditScore;
    private final boolean hasOverdueDebts;

    public LoanApplication(UUID id, Applicant applicant, BigDecimal requestedAmount, Status status,
                           String applicationNumber, Boolean evaluationResult, LocalDateTime createdAt,
                           LocalDateTime updatedAt, String evaluationReason, Integer creditScore,
                           boolean hasOverdueDebts) {
        this.id = id;
        this.applicant = applicant;
        this.requestedAmount = requestedAmount;
        this.status = status;
        this.applicationNumber = applicationNumber;
        this.evaluationResult = evaluationResult;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.evaluationReason = evaluationReason;
        this.creditScore = creditScore;
        this.hasOverdueDebts = hasOverdueDebts;
    }

    public UUID getId() {
        return id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public Status getStatus() {
        return status;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public Boolean getEvaluationResult() {
        return evaluationResult;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getEvaluationReason() {
        return evaluationReason;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public boolean isHasOverdueDebts() {
        return hasOverdueDebts;
    }

    public boolean isApproved() {
        return status == Status.APPROVED;
    }

    public boolean isRejected() {
        return status == Status.REJECTED;
    }

    public boolean isPending() {
        return status == Status.PENDING;
    }

    public boolean isEligible() {
        return Boolean.TRUE.equals(evaluationResult);
    }

    public LoanApplication withStatus(Status newStatus) {
        return new LoanApplication(
            this.id,
            this.applicant,
            this.requestedAmount,
            newStatus,
            this.applicationNumber,
            this.evaluationResult,
            this.createdAt,
            LocalDateTime.now(),
            this.evaluationReason,
            this.creditScore,
            this.hasOverdueDebts
        );
    }

    public static LoanApplication create(Applicant applicant, BigDecimal requestedAmount, 
                                          String applicationNumber, Boolean evaluationResult,
                                          String evaluationReason, Integer creditScore, 
                                          boolean hasOverdueDebts) {
        Status status = Boolean.TRUE.equals(evaluationResult) ? Status.APPROVED : Status.REJECTED;
        LocalDateTime now = LocalDateTime.now();
        return new LoanApplication(
            UUID.randomUUID(),
            applicant,
            requestedAmount,
            status,
            applicationNumber,
            evaluationResult,
            now,
            now,
            evaluationReason,
            creditScore,
            hasOverdueDebts
        );
    }

    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }
}