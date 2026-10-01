# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Diseño y Desarrollo de Sistema con Patrones GRASP**.

| | |
|---|---|
| Tema | Aplicación de Patrones GRASP en el Desarrollo de Sistemas |
| Nivel | junior-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar con puertos y adaptadores (hexagonal/clean adaptado) |
| Tiempo estimado | 15 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.5.6
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.springframework.boot:spring-boot-starter-actuator n/a
- io.github.resilience4j:resilience4j-spring-boot3 2.2.0
- org.postgresql:postgresql n/a
- org.springframework.boot:spring-boot-starter-test n/a
- org.mockito:mockito-core n/a

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Definición del Sistema**: Diagrama de clases que representa las entidades y relaciones del sistema.
- **Fase 2 — Implementación del Motor de Evaluación**: Componente funcional que evalúa la elegibilidad de los solicitantes y crea solicitudes.
- **Fase 3 — Registro de Solicitudes**: Componente funcional que registra las solicitudes en la base de datos con garantías de idempotencia y consistencia.
- **Fase 4 — Integración y Optimización**: Sistema completo que gestiona solicitudes de préstamos con garantías de idempotencia, consistencia y capacidad para manejar alta carga.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/config/ResilienceConfig.java` — El topic pide resiliencia: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (32)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/pragma/loanprocessing/application/service/LoanEvaluationService.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCase.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanEvaluationAdapter.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanRegistrationAdapter.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/loanprocessing/application/service/LoanEvaluationService.java` — `Applicant.identificationNumber`
      Se invoca `identificationNumber` sobre `Applicant`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCase.java` — `Applicant.identificationNumber`
      Se invoca `identificationNumber` sobre `Applicant`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanEvaluationAdapter.java` — `Applicant.identificationNumber`
      Se invoca `identificationNumber` sobre `Applicant`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanRegistrationAdapter.java` — `LoanApplication.applicationNumber`
      Se invoca `applicationNumber` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanRegistrationAdapter.java` — `LoanApplication.toBuilder`
      Se invoca `toBuilder` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanRegistrationAdapter.java` — `LoanApplication.applicant`
      Se invoca `applicant` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.identificationNumber`
      Se invoca `identificationNumber` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.fullName`
      Se invoca `fullName` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.email`
      Se invoca `email` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.phoneNumber`
      Se invoca `phoneNumber` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.dateOfBirth`
      Se invoca `dateOfBirth` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.employmentStatus`
      Se invoca `employmentStatus` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.monthlyIncome`
      Se invoca `monthlyIncome` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.requestedAmount`
      Se invoca `requestedAmount` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.loanTermMonths`
      Se invoca `loanTermMonths` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.loanPurpose`
      Se invoca `loanPurpose` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplication.applicationNumber`
      Se invoca `applicationNumber` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplication.applicant`
      Se invoca `applicant` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplication.requestedAmount`
      Se invoca `requestedAmount` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplication.status`
      Se invoca `status` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplication.applicationDate`
      Se invoca `applicationDate` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplication.loanTermMonths`
      Se invoca `loanTermMonths` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/loanprocessing/application/service/LoanEvaluationServiceTest.java` — `LoanEvaluationService.evaluateEligibility`
      Se invoca `evaluateEligibility` sobre `LoanEvaluationService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCaseTest.java` — `RegisterLoanUseCase.registerLoan`
      Se invoca `registerLoan` sobre `RegisterLoanUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCaseTest.java` — `LoanApplication.applicationNumber`
      Se invoca `applicationNumber` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCaseTest.java` — `LoanApplication.status`
      Se invoca `status` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCaseTest.java` — `RegisterLoanUseCase.updateStatus`
      Se invoca `updateStatus` sobre `RegisterLoanUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (18)

- `pom.xml`
- `src/main/java/com/pragma/loanprocessing/LoanProcessingApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/com/pragma/loanprocessing/domain/model/Applicant.java`
- `src/main/java/com/pragma/loanprocessing/domain/port/LoanEvaluationPort.java`
- `src/main/java/com/pragma/loanprocessing/domain/port/LoanRegistrationPort.java`
- `src/main/java/com/pragma/loanprocessing/domain/model/LoanApplication.java`
- `src/main/java/com/pragma/loanprocessing/application/service/LoanEvaluationService.java`
- `src/main/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCase.java`
- `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanEvaluationAdapter.java`
- `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanRegistrationAdapter.java`
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java`
- `src/main/java/com/pragma/loanprocessing/infrastructure/exception/LoanEvaluationException.java`
- `src/main/java/com/pragma/loanprocessing/infrastructure/config/ResilienceConfig.java`
- `src/main/java/com/pragma/loanprocessing/infrastructure/exception/GlobalExceptionHandler.java`
- `src/main/java/com/pragma/loanprocessing/infrastructure/exception/DuplicateLoanException.java`
- `src/test/java/com/pragma/loanprocessing/application/service/LoanEvaluationServiceTest.java`
- `src/test/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCaseTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/loanprocessing`
- `src/main/java/com/pragma/loanprocessing/domain`
- `src/main/java/com/pragma/loanprocessing/domain/model`
- `src/main/java/com/pragma/loanprocessing/domain/port`
- `src/main/java/com/pragma/loanprocessing/application`
- `src/main/java/com/pragma/loanprocessing/application/service`
- `src/main/java/com/pragma/loanprocessing/application/usecase`
- `src/main/java/com/pragma/loanprocessing/infrastructure`
- `src/main/java/com/pragma/loanprocessing/infrastructure/adapter`
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller`
- `src/main/java/com/pragma/loanprocessing/infrastructure/config`
- `src/main/java/com/pragma/loanprocessing/infrastructure/exception`
- `src/main/resources`
- `src/test/java/com/pragma/loanprocessing`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar con puertos y adaptadores (hexagonal/clean adaptado)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Junior
- Brecha que el reto ataca: Aplica al menos dos patrones GRASP (Patrones de Software para la Asignación de Responsabilidades Generales) en el diseño y desarrollo de un sistema. Entre ellos: Experto en Información, Creador, Controlador, Alta Cohesión y Bajo Acoplamiento, Polimorfismo, Fabricación Pura, Indirección y Variaciones Protegidas.
- Mision: Candidato con experiencia como Desarrollador Backend Junior en Java, enfocado en consolidar principios sólidos de diseño.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
