package com.pragma.loanprocessing.domain.port;

import com.pragma.loanprocessing.domain.model.Applicant;
import java.util.concurrent.CompletionStage;

/**
 * Interfaz que define el puerto para evaluar la elegibilidad de un solicitante.
 * Aplica el patrón Experto en Información: el dominio delega la evaluación a
 * un componente especializado a través de esta interfaz.
 */
public interface LoanEvaluationPort {
    /**
     * Evalúa la elegibilidad de un solicitante para un préstamo.
     * @param applicant solicitante a evaluar
     * @param requestedAmount monto solicitado
     * @return CompletionStage<Boolean> que resuelve a true si el solicitante es elegible, false en caso contrario
     */
    CompletionStage<Boolean> evaluateEligibility(Applicant applicant, double requestedAmount);

    /**
     * Obtiene el puntaje crediticio del solicitante desde un servicio externo.
     * @param identificationNumber número de identificación del solicitante
     * @return CompletionStage<Integer> que resuelve al puntaje crediticio
     */
    CompletionStage<Integer> getCreditScore(String identificationNumber);

    /**
     * Verifica si el solicitante tiene deudas vencidas.
     * @param identificationNumber número de identificación del solicitante
     * @return CompletionStage<Boolean> que resuelve a true si tiene deudas vencidas, false en caso contrario
     */
    CompletionStage<Boolean> hasOverdueDebts(String identificationNumber);
}