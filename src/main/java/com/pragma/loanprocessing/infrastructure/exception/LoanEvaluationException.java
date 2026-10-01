package com.pragma.loanprocessing.infrastructure.exception;

public class LoanEvaluationException extends RuntimeException {
    private final String identificationNumber;
    private final String reason;

    public LoanEvaluationException(String message) {
        super(message);
        this.identificationNumber = null;
        this.reason = null;
    }

    public LoanEvaluationException(String message, Throwable cause) {
        super(message, cause);
        this.identificationNumber = null;
        this.reason = null;
    }

    public LoanEvaluationException(String identificationNumber, String reason) {
        super("Evaluation failed for applicant " + identificationNumber + ": " + reason);
        this.identificationNumber = identificationNumber;
        this.reason = reason;
    }

    public LoanEvaluationException(String identificationNumber, String reason, Throwable cause) {
        super("Evaluation failed for applicant " + identificationNumber + ": " + reason, cause);
        this.identificationNumber = identificationNumber;
        this.reason = reason;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getReason() {
        return reason;
    }
}