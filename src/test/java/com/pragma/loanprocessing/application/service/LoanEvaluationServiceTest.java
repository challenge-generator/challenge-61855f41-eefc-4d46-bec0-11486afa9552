package com.pragma.loanprocessing.application.service;


import com.pragma.loanprocessing.domain.model.EmploymentStatus;
import com.pragma.loanprocessing.domain.model.Applicant;
import com.pragma.loanprocessing.domain.port.LoanEvaluationPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoanEvaluationServiceTest {

    @Mock
    private LoanEvaluationPort loanEvaluationPort;

    private LoanEvaluationService loanEvaluationService;

    @BeforeEach
    void setUp() {
        loanEvaluationService = new LoanEvaluationService(loanEvaluationPort);
    }

    @Test
    @Disabled("Superficie de práctica: completar la evaluación de elegibilidad")
    void shouldApproveEligibleApplicant() {
        Applicant applicant = new Applicant(
                "John Doe",
                "12345678",
                30,
                BigDecimal.valueOf(5000),
                Applicant.EmploymentStatus.EMPLOYED,
                750
        );

        when(loanEvaluationPort.evaluateEligibility(applicant, 10000.0))
                .thenReturn(CompletableFuture.completedFuture(true));
        when(loanEvaluationPort.getCreditScore("12345678"))
                .thenReturn(CompletableFuture.completedFuture(750));
        when(loanEvaluationPort.hasOverdueDebts("12345678"))
                .thenReturn(CompletableFuture.completedFuture(false));

        CompletionStage<Boolean> result = loanEvaluationService.evaluateEligibility(applicant, 10000.0);

        assertNotNull(result);
        assertTrue(result.toCompletableFuture().join());
    }

    @Test
    @Disabled("Superficie de práctica: completar la evaluación de no elegibilidad")
    void shouldRejectApplicantWithLowCreditScore() {
        Applicant applicant = new Applicant(
                "Jane Smith",
                "87654321",
                25,
                BigDecimal.valueOf(3000),
                Applicant.EmploymentStatus.SELF_EMPLOYED,
                550
        );

        when(loanEvaluationPort.evaluateEligibility(applicant, 15000.0))
                .thenReturn(CompletableFuture.completedFuture(false));
        when(loanEvaluationPort.getCreditScore("87654321"))
                .thenReturn(CompletableFuture.completedFuture(550));
        when(loanEvaluationPort.hasOverdueDebts("87654321"))
                .thenReturn(CompletableFuture.completedFuture(false));

        CompletionStage<Boolean> result = loanEvaluationService.evaluateEligibility(applicant, 15000.0);

        assertNotNull(result);
        assertFalse(result.toCompletableFuture().join());
    }

    @Test
    @Disabled("Superficie de práctica: completar la evaluación con deudas pendientes")
    void shouldRejectApplicantWithOverdueDebts() {
        Applicant applicant = new Applicant(
                "Bob Wilson",
                "11223344",
                35,
                BigDecimal.valueOf(6000),
                Applicant.EmploymentStatus.EMPLOYED,
                680
        );

        when(loanEvaluationPort.hasOverdueDebts("11223344"))
                .thenReturn(CompletableFuture.completedFuture(true));

        CompletionStage<Boolean> result = loanEvaluationService.evaluateEligibility(applicant, 20000.0);

        assertNotNull(result);
        assertFalse(result.toCompletableFuture().join());
    }

    @Test
    @Disabled("Superficie de práctica: completar el manejo de timeout")
    void shouldHandleEvaluationTimeout() {
        Applicant applicant = new Applicant(
                "Alice Brown",
                "55667788",
                28,
                BigDecimal.valueOf(4500),
                Applicant.EmploymentStatus.EMPLOYED,
                700
        );

        when(loanEvaluationPort.evaluateEligibility(applicant, 12000.0))
                .thenReturn(CompletableFuture.failedFuture(
                        new java.util.concurrent.TimeoutException("Evaluation timeout")));

        CompletionStage<Boolean> result = loanEvaluationService.evaluateEligibility(applicant, 12000.0);

        assertNotNull(result);
        assertThrows(java.util.concurrent.ExecutionException.class,
                () -> result.toCompletableFuture().join());
    }

    @Test
    @Disabled("Superficie de práctica: completar la validación de applicant nulo")
    void shouldThrowExceptionForNullApplicant() {
        assertThrows(NullPointerException.class, () -> {
            loanEvaluationService.evaluateEligibility(null, 10000.0);
        });
    }
}