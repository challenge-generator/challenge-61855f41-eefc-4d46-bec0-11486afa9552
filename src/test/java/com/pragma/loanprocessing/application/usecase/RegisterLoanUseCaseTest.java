package com.pragma.loanprocessing.application.usecase;



import com.pragma.loanprocessing.domain.model.Status;
import com.pragma.loanprocessing.domain.model.EmploymentStatus;
import com.pragma.loanprocessing.domain.model.Applicant;
import com.pragma.loanprocessing.domain.model.LoanApplication;
import com.pragma.loanprocessing.domain.port.LoanRegistrationPort;
import com.pragma.loanprocessing.infrastructure.exception.DuplicateLoanException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterLoanUseCaseTest {

    @Mock
    private LoanRegistrationPort loanRegistrationPort;

    private RegisterLoanUseCase registerLoanUseCase;

    @BeforeEach
    void setUp() {
        registerLoanUseCase = new RegisterLoanUseCase(loanRegistrationPort);
    }

    @Test
    @Disabled("Superficie de práctica: completar el registro de nueva solicitud")
    void shouldRegisterNewLoanApplication() {
        String applicationNumber = "LOAN-2024-001";
        Applicant applicant = new Applicant(
                "Carlos Rodriguez",
                "99887766",
                32,
                BigDecimal.valueOf(5500),
                Applicant.EmploymentStatus.EMPLOYED,
                720
        );

        LoanApplication expectedApplication = LoanApplication.builder()
                .applicationNumber(applicationNumber)
                .applicant(applicant)
                .requestedAmount(BigDecimal.valueOf(15000))
                .status(LoanApplication.Status.PENDING_EVALUATION)
                .build();

        when(loanRegistrationPort.existsByApplicationNumber(applicationNumber))
                .thenReturn(CompletableFuture.completedFuture(false));
        when(loanRegistrationPort.registerLoanApplication(any(LoanApplication.class)))
                .thenReturn(CompletableFuture.completedFuture(expectedApplication));

        CompletionStage<LoanApplication> result = registerLoanUseCase.registerLoan(applicationNumber, applicant, BigDecimal.valueOf(15000));

        assertNotNull(result);
        LoanApplication registered = result.toCompletableFuture().join();
        assertNotNull(registered);
        assertEquals(applicationNumber, registered.applicationNumber());
        assertEquals(LoanApplication.Status.PENDING_EVALUATION, registered.status());
    }

    @Test
    @Disabled("Superficie de práctica: completar la validación de idempotencia")
    void shouldRejectDuplicateApplicationNumber() {
        String applicationNumber = "LOAN-2024-002";
        Applicant applicant = new Applicant(
                "Maria Garcia",
                "88776655",
                29,
                BigDecimal.valueOf(4800),
                Applicant.EmploymentStatus.SELF_EMPLOYED,
                690
        );

        when(loanRegistrationPort.existsByApplicationNumber(applicationNumber))
                .thenReturn(CompletableFuture.completedFuture(true));

        assertThrows(DuplicateLoanException.class, () -> {
            registerLoanUseCase.registerLoan(applicationNumber, applicant, BigDecimal.valueOf(12000));
        });
    }

    @Test
    @Disabled("Superficie de práctica: completar la actualización de estado")
    void shouldUpdateApplicationStatus() {
        UUID applicationId = UUID.randomUUID();
        LoanApplication existingApplication = LoanApplication.builder()
                .applicationId(applicationId)
                .applicationNumber("LOAN-2024-003")
                .status(LoanApplication.Status.PENDING_EVALUATION)
                .build();

        LoanApplication updatedApplication = LoanApplication.builder()
                .applicationId(applicationId)
                .applicationNumber("LOAN-2024-003")
                .status(LoanApplication.Status.APPROVED)
                .build();

        when(loanRegistrationPort.getApplicationById(applicationId))
                .thenReturn(CompletableFuture.completedFuture(existingApplication));
        when(loanRegistrationPort.updateApplicationStatus(applicationId, LoanApplication.Status.APPROVED))
                .thenReturn(CompletableFuture.completedFuture(updatedApplication));

        CompletionStage<LoanApplication> result = registerLoanUseCase.updateStatus(applicationId, LoanApplication.Status.APPROVED);

        assertNotNull(result);
        LoanApplication updated = result.toCompletableFuture().join();
        assertEquals(LoanApplication.Status.APPROVED, updated.status());
    }

    @Test
    @Disabled("Superficie de práctica: completar el manejo de aplicación no encontrada")
    void shouldThrowExceptionWhenApplicationNotFound() {
        UUID nonExistentId = UUID.randomUUID();

        when(loanRegistrationPort.getApplicationById(nonExistentId))
                .thenReturn(CompletableFuture.completedFuture(null));

        assertThrows(java.util.NoSuchElementException.class, () -> {
            registerLoanUseCase.updateStatus(nonExistentId, LoanApplication.Status.REJECTED);
        });
    }

    @Test
    @Disabled("Superficie de práctica: completar la validación de aplicación nula")
    void shouldThrowExceptionForNullApplicationNumber() {
        Applicant applicant = new Applicant(
                "Test User",
                "12312312",
                30,
                BigDecimal.valueOf(5000),
                Applicant.EmploymentStatus.EMPLOYED,
                700
        );

        assertThrows(IllegalArgumentException.class, () -> {
            registerLoanUseCase.registerLoan(null, applicant, BigDecimal.valueOf(10000));
        });
    }

    @Test
    @Disabled("Superficie de práctica: completar la validación de monto negativo")
    void shouldThrowExceptionForNegativeAmount() {
        String applicationNumber = "LOAN-2024-004";
        Applicant applicant = new Applicant(
                "Test User 2",
                "32132132",
                28,
                BigDecimal.valueOf(4000),
                Applicant.EmploymentStatus.EMPLOYED,
                650
        );

        assertThrows(IllegalArgumentException.class, () -> {
            registerLoanUseCase.registerLoan(applicationNumber, applicant, BigDecimal.valueOf(-5000));
        });
    }
}