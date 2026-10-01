package com.pragma.loanprocessing.infrastructure.exception;

import java.time.Instant;
import java.util.UUID;

public class DuplicateLoanException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String applicationNumber;
    private final UUID requestId;
    private final Instant detectedAt;
    private final String duplicateField;

    public DuplicateLoanException(String applicationNumber) {
        super(buildMessage(applicationNumber));
        this.applicationNumber = applicationNumber;
        this.requestId = UUID.randomUUID();
        this.detectedAt = Instant.now();
        this.duplicateField = "applicationNumber";
    }

    public DuplicateLoanException(String applicationNumber, String message) {
        super(message);
        this.applicationNumber = applicationNumber;
        this.requestId = UUID.randomUUID();
        this.detectedAt = Instant.now();
        this.duplicateField = "applicationNumber";
    }

    public DuplicateLoanException(String applicationNumber, Throwable cause) {
        super(buildMessage(applicationNumber), cause);
        this.applicationNumber = applicationNumber;
        this.requestId = UUID.randomUUID();
        this.detectedAt = Instant.now();
        this.duplicateField = "applicationNumber";
    }

    private static String buildMessage(String applicationNumber) {
        return "Ya existe una solicitud de préstamo con el número de aplicación: " + applicationNumber;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public Instant getDetectedAt() {
        return detectedAt;
    }

    public String getDuplicateField() {
        return duplicateField;
    }

    public String getDetailedMessage() {
        return String.format("DuplicateLoanException{applicationNumber='%s', requestId=%s, detectedAt=%s, duplicateField='%s'}",
                applicationNumber, requestId, detectedAt, duplicateField);
    }

    public boolean isRetryable() {
        return false;
    }

    public boolean isDuplicate() {
        return true;
    }
}