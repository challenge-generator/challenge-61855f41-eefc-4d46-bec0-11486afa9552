# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/pragma/loanprocessing/infrastructure/config/ResilienceConfig.java` — El topic pide resiliencia: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/loanprocessing/application/service/LoanEvaluationService.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCase.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanEvaluationAdapter.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanRegistrationAdapter.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/loanprocessing/application/service/LoanEvaluationService.java` — `Applicant.identificationNumber`: Se invoca `identificationNumber` sobre `Applicant`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCase.java` — `Applicant.identificationNumber`: Se invoca `identificationNumber` sobre `Applicant`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanEvaluationAdapter.java` — `Applicant.identificationNumber`: Se invoca `identificationNumber` sobre `Applicant`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanRegistrationAdapter.java` — `LoanApplication.applicationNumber`: Se invoca `applicationNumber` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanRegistrationAdapter.java` — `LoanApplication.toBuilder`: Se invoca `toBuilder` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanRegistrationAdapter.java` — `LoanApplication.applicant`: Se invoca `applicant` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.identificationNumber`: Se invoca `identificationNumber` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.fullName`: Se invoca `fullName` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.email`: Se invoca `email` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.phoneNumber`: Se invoca `phoneNumber` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.dateOfBirth`: Se invoca `dateOfBirth` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.employmentStatus`: Se invoca `employmentStatus` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.monthlyIncome`: Se invoca `monthlyIncome` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.requestedAmount`: Se invoca `requestedAmount` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.loanTermMonths`: Se invoca `loanTermMonths` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplicationRequest.loanPurpose`: Se invoca `loanPurpose` sobre `LoanApplicationRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplication.applicationNumber`: Se invoca `applicationNumber` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplication.applicant`: Se invoca `applicant` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplication.requestedAmount`: Se invoca `requestedAmount` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplication.status`: Se invoca `status` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplication.applicationDate`: Se invoca `applicationDate` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java` — `LoanApplication.loanTermMonths`: Se invoca `loanTermMonths` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/loanprocessing/application/service/LoanEvaluationServiceTest.java` — `LoanEvaluationService.evaluateEligibility`: Se invoca `evaluateEligibility` sobre `LoanEvaluationService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCaseTest.java` — `RegisterLoanUseCase.registerLoan`: Se invoca `registerLoan` sobre `RegisterLoanUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCaseTest.java` — `LoanApplication.applicationNumber`: Se invoca `applicationNumber` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCaseTest.java` — `LoanApplication.status`: Se invoca `status` sobre `LoanApplication`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCaseTest.java` — `RegisterLoanUseCase.updateStatus`: Se invoca `updateStatus` sobre `RegisterLoanUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Junior

### Brecha de conocimiento
Aplica al menos dos patrones GRASP (Patrones de Software para la Asignación de Responsabilidades Generales) en el diseño y desarrollo de un sistema. Entre ellos: Experto en Información, Creador, Controlador, Alta Cohesión y Bajo Acoplamiento, Polimorfismo, Fabricación Pura, Indirección y Variaciones Protegidas.

### Misión / candidato
Candidato con experiencia como Desarrollador Backend Junior en Java, enfocado en consolidar principios sólidos de diseño.

### Reto
- Tema: Aplicación de Patrones GRASP en el Desarrollo de Sistemas
- Seniority: junior-l2
- Tipo: practical
- Título: Diseño y Desarrollo de Sistema con Patrones GRASP
- Tiempo estimado: 15 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición del Sistema — objetivo: Definir las entidades y relaciones del sistema de gestión de préstamos. — entregable (NO resolver): Diagrama de clases que representa las entidades y relaciones del sistema.
- Fase 2: Implementación del Motor de Evaluación — objetivo: Implementar el motor de evaluación que determina la elegibilidad de los solicitantes. — entregable (NO resolver): Componente funcional que evalúa la elegibilidad de los solicitantes y crea solicitudes.
- Fase 3: Registro de Solicitudes — objetivo: Implementar el componente que registra las solicitudes en la base de datos. — entregable (NO resolver): Componente funcional que registra las solicitudes en la base de datos con garantías de idempotencia y consistencia.
- Fase 4: Integración y Optimización — objetivo: Integrar los componentes y optimizar el sistema para manejar la carga de solicitudes. — entregable (NO resolver): Sistema completo que gestiona solicitudes de préstamos con garantías de idempotencia, consistencia y capacidad para manejar alta carga.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>loan-processing</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>loan-processing</name>
    <description>Sistema de gestión de solicitudes de préstamos con patrones GRASP</description>

    <properties>
        <java.version>21</java.version>
        <resilience4j.version>2.2.0</resilience4j.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <!-- Resilience4j para Spring Boot 3 -->
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot3</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-micrometer</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>

        <!-- Base de datos -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
        </repository>
    </repositories>
</project>

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/LoanProcessingApplication.java ===
package com.pragma.loanprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import java.time.Duration;

@SpringBootApplication
@EnableConfigurationProperties
@EnableRetry
public class LoanProcessingApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(LoanProcessingApplication.class, args);
    }
    
    @Bean
    public CircuitBreaker loanEvaluationCircuitBreaker(CircuitBreakerRegistry registry) {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .permittedNumberOfCallsInHalfOpenState(2)
                .slidingWindowSize(2)
                .recordExceptions(java.util.concurrent.TimeoutException.class,
                                 org.springframework.web.client.ResourceAccessException.class)
                .build();
        return registry.circuitBreaker("loanEvaluation", config);
    }
    
    @Bean
    public Retry loanEvaluationRetry(RetryRegistry registry) {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(500))
                .retryExceptions(java.util.concurrent.TimeoutException.class,
                                org.springframework.web.client.ResourceAccessException.class)
                .build();
        return registry.retry("loanEvaluation", config);
    }
    
    @Bean
    public TimeLimiter loanEvaluationTimeLimiter(TimeLimiterRegistry registry) {
        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(2))
                .cancelRunningFuture(true)
                .build();
        return registry.timeLimiter("loanEvaluation", config);
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: loan-processing
  
  datasource:
    url: jdbc:postgresql://localhost:5432/loan_db
    username: loan_user
    password: loan_pass
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 20
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
  
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect

server:
  port: 8080
  servlet:
    context-path: /api/loans

resilience4j:
  circuitbreaker:
    instances:
      loanEvaluation:
        registerHealthIndicator: true
        eventConsumerBufferSize: 10
        failureRateThreshold: 50
        minimumNumberOfCalls: 5
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 1s
        permittedNumberOfCallsInHalfOpenState: 3
        slidingWindowSize: 10
        slidingWindowType: COUNT_BASED
  
  retry:
    instances:
      loanEvaluation:
        maxRetryAttempts: 3
        waitDuration: 500ms
        enableExponentialBackoff: true
        exponentialBackoffMultiplier: 2
        retryExceptions:
          - java.util.concurrent.TimeoutException
          - org.springframework.web.client.ResourceAccessException
  
  timelimiter:
    instances:
      loanEvaluation:
        timeoutDuration: 2s
        cancelRunningFuture: true

management:
  endpoints:
    web:
      exposure:
        include: health,metrics,info,circuitbreakers
  endpoint:
    health:
      show-details: always
  health:
    circuitbreakers:
      enabled: true"

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/domain/model/Applicant.java ===
package com.pragma.loanprocessing.domain.model;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Entidad de dominio que representa al solicitante de un préstamo.
 * Aplica el patrón Experto en Información: esta clase contiene toda la lógica
 * relacionada con la validación de los datos del solicitante.
 */
public record Applicant(
    @NotNull(message = "El ID del solicitante es obligatorio")
    UUID id,

    @NotBlank(message = "El nombre completo es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    String fullName,

    @NotBlank(message = "El número de identificación es obligatorio")
    @Pattern(regexp = "^[A-Za-z0-9]{5,20}$", message = "El número de identificación debe ser alfanumérico entre 5 y 20 caracteres")
    String identificationNumber,

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    LocalDate birthDate,

    @NotNull(message = "El ingreso mensual es obligatorio")
    @Positive(message = "El ingreso mensual debe ser positivo")
    BigDecimal monthlyIncome,

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El formato del correo electrónico es inválido")
    String email,

    @NotBlank(message = "El número de teléfono es obligatorio")
    @Pattern(regexp = "^\+?[0-9]{10,15}$", message = "El número de teléfono debe contener entre 10 y 15 dígitos")
    String phoneNumber,

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 200, message = "La dirección no puede exceder 200 caracteres")
    String address,

    @NotNull(message = "El estado de empleo es obligatorio")
    EmploymentStatus employmentStatus,

    @NotNull(message = "El puntaje crediticio es obligatorio")
    @Min(value = 300, message = "El puntaje crediticio mínimo es 300")
    @Max(value = 850, message = "El puntaje crediticio máximo es 850")
    int creditScore,

    @NotNull(message = "La fecha de solicitud es obligatoria")
    LocalDate applicationDate
) {
    /**
     * Calcula la edad del solicitante en años.
     * @return edad en años
     */
    public int calculateAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    /**
     * Verifica si el solicitante cumple con la edad mínima para solicitar un préstamo.
     * @param minimumAge edad mínima requerida
     * @return true si cumple con la edad mínima, false en caso contrario
     */
    public boolean meetsMinimumAgeRequirement(int minimumAge) {
        return calculateAge() >= minimumAge;
    }

    /**
     * Verifica si el solicitante tiene un ingreso suficiente basado en el monto del préstamo solicitado.
     * @param loanAmount monto del préstamo solicitado
     * @param incomeMultiplier multiplicador de ingreso (ej: 0.3 para 30% del ingreso)
     * @return true si el ingreso es suficiente, false en caso contrario
     */
    public boolean hasSufficientIncome(BigDecimal loanAmount, BigDecimal incomeMultiplier) {
        BigDecimal requiredIncome = loanAmount.multiply(incomeMultiplier);
        return monthlyIncome.compareTo(requiredIncome) >= 0;
    }

    /**
     * Verifica si el solicitante tiene un puntaje crediticio aceptable.
     * @param minimumScore puntaje mínimo requerido
     * @return true si el puntaje es aceptable, false en caso contrario
     */
    public boolean hasAcceptableCreditScore(int minimumScore) {
        return creditScore >= minimumScore;
    }

    /**
     * Enum que representa el estado de empleo del solicitante.
     */
    public enum EmploymentStatus {
        EMPLOYED,
        SELF_EMPLOYED,
        UNEMPLOYED,
        RETIRED
    }
}

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/domain/port/LoanEvaluationPort.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/domain/port/LoanRegistrationPort.java ===
package com.pragma.loanprocessing.domain.port;


import com.pragma.loanprocessing.domain.model.Status;
import com.pragma.loanprocessing.domain.model.Applicant;
import com.pragma.loanprocessing.domain.model.LoanApplication;
import java.util.UUID;
import java.util.concurrent.CompletionStage;

/**
 * Interfaz que define el puerto para registrar solicitudes de préstamo.
 * Aplica el patrón Controlador: esta interfaz actúa como el punto de entrada
 * para operaciones de registro de solicitudes.
 */
public interface LoanRegistrationPort {
    /**
     * Registra una nueva solicitud de préstamo en el sistema.
     * @param loanApplication solicitud de préstamo a registrar
     * @return CompletionStage<LoanApplication> que resuelve a la solicitud registrada con su ID generado
     */
    CompletionStage<LoanApplication> registerLoanApplication(LoanApplication loanApplication);

    /**
     * Verifica si ya existe una solicitud con el mismo número de solicitud.
     * @param applicationNumber número de solicitud a verificar
     * @return CompletionStage<Boolean> que resuelve a true si existe, false en caso contrario
     */
    CompletionStage<Boolean> existsByApplicationNumber(String applicationNumber);

    /**
     * Actualiza el estado de una solicitud existente.
     * @param applicationId ID de la solicitud
     * @param newStatus nuevo estado de la solicitud
     * @return CompletionStage<LoanApplication> que resuelve a la solicitud actualizada
     */
    CompletionStage<LoanApplication> updateApplicationStatus(UUID applicationId, LoanApplication.Status newStatus);

    /**
     * Obtiene una solicitud por su ID.
     * @param applicationId ID de la solicitud
     * @return CompletionStage<LoanApplication> que resuelve a la solicitud encontrada
     */
    CompletionStage<LoanApplication> getApplicationById(UUID applicationId);

    /**
     * Obtiene el solicitante asociado a una solicitud.
     * @param applicationId ID de la solicitud
     * @return CompletionStage<Applicant> que resuelve al solicitante asociado
     */
    CompletionStage<Applicant> getApplicantForApplication(UUID applicationId);
}

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/domain/model/LoanApplication.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/application/service/LoanEvaluationService.java ===
package com.pragma.loanprocessing.application.service;

import com.pragma.loanprocessing.domain.model.Applicant;
import com.pragma.loanprocessing.domain.model.LoanApplication;
import com.pragma.loanprocessing.domain.port.LoanEvaluationPort;
import com.pragma.loanprocessing.infrastructure.exception.LoanEvaluationException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class LoanEvaluationService {

    private static final Logger log = LoggerFactory.getLogger(LoanEvaluationService.class);
    private static final int DEFAULT_MINIMUM_AGE = 18;
    private static final int DEFAULT_MINIMUM_CREDIT_SCORE = 600;
    private static final BigDecimal DEFAULT_INCOME_MULTIPLIER = new BigDecimal("4");
    private static final String CIRCUIT_BREAKER_NAME = "loanEvaluation";
    private static final String RETRY_NAME = "loanEvaluation";
    private static final String TIME_LIMITER_NAME = "loanEvaluation";

    private final LoanEvaluationPort loanEvaluationPort;

    public LoanEvaluationService(LoanEvaluationPort loanEvaluationPort) {
        this.loanEvaluationPort = loanEvaluationPort;
    }

    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "evaluateEligibilityFallback")
    @Retry(name = RETRY_NAME)
    @TimeLimiter(name = TIME_LIMITER_NAME)
    public CompletionStage<LoanApplication> evaluateAndCreateApplication(
            Applicant applicant, BigDecimal requestedAmount, String applicationNumber) {
        
        log.info("Iniciando evaluación de elegibilidad para solicitante: {} con monto: {}", 
                applicant.identificationNumber(), requestedAmount);

        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean eligibilityResult = loanEvaluationPort.evaluateEligibility(
                        applicant, 
                        requestedAmount.doubleValue()
                ).get(2, TimeUnit.SECONDS);

                Integer creditScore = loanEvaluationPort.getCreditScore(
                        applicant.identificationNumber()
                ).get(2, TimeUnit.SECONDS);

                Boolean hasOverdue = loanEvaluationPort.hasOverdueDebts(
                        applicant.identificationNumber()
                ).get(2, TimeUnit.SECONDS);

                String reason = buildEvaluationReason(applicant, requestedAmount, creditScore, hasOverdue);

                return LoanApplication.create(
                        applicant,
                        requestedAmount,
                        applicationNumber,
                        eligibilityResult,
                        reason,
                        creditScore,
                        hasOverdue != null && hasOverdue
                );

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new LoanEvaluationException("Evaluación interrumpida para solicitante: " 
                        + applicant.identificationNumber(), e);
            } catch (ExecutionException e) {
                throw new LoanEvaluationException("Error en evaluación de solicitante: " 
                        + applicant.identificationNumber(), e);
            } catch (TimeoutException e) {
                throw new LoanEvaluationException("Timeout en evaluación de solicitante: " 
                        + applicant.identificationNumber(), e);
            }
        });
    }

    private String buildEvaluationReason(Applicant applicant, BigDecimal requestedAmount, 
                                          Integer creditScore, Boolean hasOverdue) {
        StringBuilder reason = new StringBuilder();
        
        if (!applicant.meetsMinimumAgeRequirement(DEFAULT_MINIMUM_AGE)) {
            reason.append("Edad mínima no cumplida. ");
        }
        
        if (!applicant.hasSufficientIncome(requestedAmount, DEFAULT_INCOME_MULTIPLIER)) {
            reason.append("Ingresos insuficientes para el monto solicitado. ");
        }
        
        if (!applicant.hasAcceptableCreditScore(DEFAULT_MINIMUM_CREDIT_SCORE)) {
            reason.append("Score crediticio insuficiente. ");
        }
        
        if (hasOverdue != null && hasOverdue) {
            reason.append("Tiene deudas vencidas. ");
        }
        
        if (reason.length() == 0) {
            return "Elegible según criterios establecidos";
        }
        
        return reason.toString().trim();
    }

    private LoanApplication evaluateEligibilityFallback(Applicant applicant, BigDecimal requestedAmount, 
                                                         String applicationNumber, Throwable t) {
        log.error("Fallback activado para solicitante {}: {}", applicant.identificationNumber(), t.getMessage());
        
        return LoanApplication.create(
                applicant,
                requestedAmount,
                applicationNumber,
                false,
                "Error en evaluación: servicio no disponible temporalmente. Intente más tarde.",
                null,
                false
        );
    }

    public boolean validateApplicantRequirements(Applicant applicant, BigDecimal requestedAmount) {
        if (applicant == null || requestedAmount == null) {
            return false;
        }
        
        return applicant.meetsMinimumAgeRequirement(DEFAULT_MINIMUM_AGE)
                && applicant.hasSufficientIncome(requestedAmount, DEFAULT_INCOME_MULTIPLIER)
                && applicant.hasAcceptableCreditScore(DEFAULT_MINIMUM_CREDIT_SCORE);
    }
}

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCase.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanEvaluationAdapter.java ===
package com.pragma.loanprocessing.infrastructure.adapter;

import com.pragma.loanprocessing.domain.model.Applicant;
import com.pragma.loanprocessing.domain.port.LoanEvaluationPort;
import com.pragma.loanprocessing.infrastructure.exception.LoanEvaluationException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

@Component
public class LoanEvaluationAdapter implements LoanEvaluationPort {

    private static final Logger log = LoggerFactory.getLogger(LoanEvaluationAdapter.class);
    private static final int MINIMUM_AGE = 18;
    private static final int MINIMUM_CREDIT_SCORE = 600;
    private static final BigDecimal INCOME_MULTIPLIER = new BigDecimal("4");
    private static final int TIMEOUT_SECONDS = 2;

    private final CircuitBreaker circuitBreaker;
    private final Retry retry;

    public LoanEvaluationAdapter(CircuitBreakerRegistry circuitBreakerRegistry, 
                                  RetryRegistry retryRegistry) {
        this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("loanEvaluation");
        this.retry = retryRegistry.retry("loanEvaluation");
        log.info("LoanEvaluationAdapter inicializado con CircuitBreaker y Retry configurados");
    }

    @Override
    public CompletionStage<Boolean> evaluateEligibility(Applicant applicant, double requestedAmount) {
        log.info("Iniciando evaluación de elegibilidad para solicitante: {}", applicant.identificationNumber());
        
        Supplier<CompletionStage<Boolean>> decoratedSupplier = CircuitBreaker.decorateCompletionStage(
                circuitBreaker,
                Retry.decorateCompletionStage(retry,
                        () -> performEvaluation(applicant, requestedAmount)
                )
        );
        
        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            log.error("Error en evaluación de elegibilidad: {}", e.getMessage());
            return CompletableFuture.failedFuture(
                    new LoanEvaluationException("Error al evaluar elegibilidad: " + e.getMessage())
            );
        }
    }

    private CompletionStage<Boolean> performEvaluation(Applicant applicant, double requestedAmount) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
                
                boolean meetsAge = applicant.meetsMinimumAgeRequirement(MINIMUM_AGE);
                boolean hasIncome = applicant.hasSufficientIncome(
                        BigDecimal.valueOf(requestedAmount), 
                        INCOME_MULTIPLIER
                );
                boolean hasCreditScore = applicant.hasAcceptableCreditScore(MINIMUM_CREDIT_SCORE);
                
                boolean eligible = meetsAge && hasIncome && hasCreditScore;
                
                log.info("Evaluación completada para {}: elegible={}", 
                        applicant.identificationNumber(), eligible);
                
                return eligible;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new LoanEvaluationException("Evaluación interrumpida");
            }
        });
    }

    @Override
    public CompletionStage<Integer> getCreditScore(String identificationNumber) {
        log.debug("Obteniendo score crediticio para: {}", identificationNumber);
        
        Supplier<CompletionStage<Integer>> decoratedSupplier = CircuitBreaker.decorateCompletionStage(
                circuitBreaker,
                Retry.decorateCompletionStage(retry,
                        () -> fetchCreditScore(identificationNumber)
                )
        );
        
        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            log.error("Error al obtener credit score: {}", e.getMessage());
            return CompletableFuture.failedFuture(
                    new LoanEvaluationException("Error al obtener credit score: " + e.getMessage())
            );
        }
    }

    private CompletionStage<Integer> fetchCreditScore(String identificationNumber) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(50);
                int score = 650 + (identificationNumber.hashCode() % 150);
                log.debug("Credit score obtenido: {}", score);
                return score;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new LoanEvaluationException("Error al obtener credit score");
            }
        });
    }

    @Override
    public CompletionStage<Boolean> hasOverdueDebts(String identificationNumber) {
        log.debug("Verificando deudas vencidas para: {}", identificationNumber);
        
        Supplier<CompletionStage<Boolean>> decoratedSupplier = CircuitBreaker.decorateCompletionStage(
                circuitBreaker,
                Retry.decorateCompletionStage(retry,
                        () -> checkOverdueDebts(identificationNumber)
                )
        );
        
        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            log.error("Error al verificar deudas vencidas: {}", e.getMessage());
            return CompletableFuture.failedFuture(
                    new LoanEvaluationException("Error al verificar deudas: " + e.getMessage())
            );
        }
    }

    private CompletionStage<Boolean> checkOverdueDebts(String identificationNumber) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(50);
                boolean hasDebts = identificationNumber.hashCode() % 3 == 0;
                log.debug("Deudas vencidas verificadas: {}", hasDebts);
                return hasDebts;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new LoanEvaluationException("Error al verificar deudas vencidas");
            }
        });
    }
}

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/infrastructure/adapter/LoanRegistrationAdapter.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/infrastructure/controller/LoanController.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/infrastructure/exception/LoanEvaluationException.java ===
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

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/infrastructure/config/ResilienceConfig.java ===
package com.pragma.loanprocessing.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ResilienceConfig {

    @Bean
    public CircuitBreakerRegistry circuitBreakerRegistry() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofSeconds(30))
                .slidingWindowSize(10)
                .minimumNumberOfCalls(5)
                .permittedNumberOfCallsInHalfOpenState(3)
                .automaticTransitionFromOpenToHalfOpenEnabled(true)
                .build();
        return CircuitBreakerRegistry.of(config);
    }

    @Bean
    public RetryRegistry retryRegistry() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(500))
                .build();
        return RetryRegistry.of(config);
    }

    @Bean
    public TimeLimiterRegistry timeLimiterRegistry() {
        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(2))
                .build();
        return TimeLimiterRegistry.of(config);
    }
}

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/infrastructure/exception/GlobalExceptionHandler.java ===
package com.pragma.loanprocessing.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoanEvaluationException.class)
    public ResponseEntity<ErrorResponse> handleLoanEvaluationException(
            LoanEvaluationException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                "EVALUATION_ERROR",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", ""),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(DuplicateLoanException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateLoanException(
            DuplicateLoanException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "DUPLICATE_APPLICATION",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", ""),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        error -> error.getDefaultMessage() != null 
                                ? error.getDefaultMessage() 
                                : "Invalid value",
                        (existing, replacement) -> existing
                ));

        ValidationErrorResponse errorResponse = new ValidationErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "VALIDATION_ERROR",
                "Error de validación en los datos de entrada",
                request.getDescription(false).replace("uri=", ""),
                LocalDateTime.now(),
                errors
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "INVALID_ARGUMENT",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", ""),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "INTERNAL_ERROR",
                "Error interno del servidor: " + ex.getMessage(),
                request.getDescription(false).replace("uri=", ""),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public record ErrorResponse(
            int status,
            String code,
            String message,
            String path,
            LocalDateTime timestamp
    ) {}

    public record ValidationErrorResponse(
            int status,
            String code,
            String message,
            String path,
            LocalDateTime timestamp,
            Map<String, String> fieldErrors
    ) {}
}

// === ARCHIVO: src/main/java/com/pragma/loanprocessing/infrastructure/exception/DuplicateLoanException.java ===
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

// === ARCHIVO: src/test/java/com/pragma/loanprocessing/application/service/LoanEvaluationServiceTest.java ===
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

// === ARCHIVO: src/test/java/com/pragma/loanprocessing/application/usecase/RegisterLoanUseCaseTest.java ===
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
```
