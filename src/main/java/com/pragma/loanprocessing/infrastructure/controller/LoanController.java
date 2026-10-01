package com.pragma.loanprocessing.infrastructure.controller;

import com.pragma.loanprocessing.application.usecase.RegisterLoanUseCase;
import com.pragma.loanprocessing.domain.model.Applicant;
import com.pragma.loanprocessing.domain.model.EmploymentStatus;
import com.pragma.loanprocessing.domain.model.LoanApplication;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    private static final Logger log = LoggerFactory.getLogger(LoanController.class);
    
    private final RegisterLoanUseCase registerLoanUseCase;

    public LoanController(RegisterLoanUseCase registerLoanUseCase) {
        this.registerLoanUseCase = registerLoanUseCase;
        log.info("LoanController inicializado");
    }

    @PostMapping("/apply")
    public ResponseEntity<LoanApplicationResponse> applyForLoan(
            @Valid @RequestBody LoanApplicationRequest request) {
        log.info("Recibida solicitud de préstamo para: {}", request.identificationNumber());
        
        try {
            Applicant applicant = new Applicant(
                    request.identificationNumber(),
                    request.fullName(),
                    request.email(),
                    request.phoneNumber(),
                    request.dateOfBirth(),
                    EmploymentStatus.valueOf(request.employmentStatus()),
                    request.monthlyIncome()
            );
            
            LoanApplication loanApplication = new LoanApplication(
                    null,
                    null,
                    applicant,
                    request.requestedAmount(),
                    request.loanTermMonths(),
                    request.loanPurpose(),
                    null,
                    null,
                    null
            );
            
            LoanApplication registered = registerLoanUseCase.execute(loanApplication)
                    .toCompletableFuture().get();
            
            LoanApplicationResponse response = toResponse(registered);
            log.info("Solicitud registrada exitosamente: {}", registered.applicationNumber());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
            
        } catch (Exception e) {
            log.error("Error al procesar solicitud de préstamo: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoanApplicationResponse(null, null, null, null, null, null, null, e.getMessage()));
        }
    }

    @GetMapping("/{applicationId}")
    public ResponseEntity<LoanApplicationResponse> getApplication(
            @PathVariable UUID applicationId) {
        log.debug("Consultando solicitud: {}", applicationId);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/status/{applicationNumber}")
    public ResponseEntity<Map<String, String>> getApplicationStatus(
            @PathVariable String applicationNumber) {
        log.debug("Consultando estado de solicitud: {}", applicationNumber);
        return ResponseEntity.ok(Map.of("status", "PENDING"));
    }

    private LoanApplicationResponse toResponse(LoanApplication application) {
        return new LoanApplicationResponse(
                application.getId().toString(),
                application.applicationNumber(),
                application.applicant().identificationNumber(),
                application.requestedAmount(),
                application.status().name(),
                application.applicationDate().toString(),
                application.loanTermMonths(),
                null
        );
    }

    public record LoanApplicationRequest(
            @NotBlank String identificationNumber,
            @NotBlank String fullName,
            @NotBlank @Email String email,
            @NotBlank String phoneNumber,
            @NotNull LocalDate dateOfBirth,
            @NotBlank String employmentStatus,
            @NotNull @Positive BigDecimal monthlyIncome,
            @NotNull @Positive BigDecimal requestedAmount,
            @NotNull @Positive Integer loanTermMonths,
            @NotBlank String loanPurpose
    ) {}

    public record LoanApplicationResponse(
            String id,
            String applicationNumber,
            String identificationNumber,
            BigDecimal requestedAmount,
            String status,
            String applicationDate,
            Integer loanTermMonths,
            String errorMessage
    ) {}
}