# Diseño y Desarrollo de Sistema con Patrones GRASP

Como Desarrollador Backend Junior en un equipo de banca, tu tarea es diseñar y desarrollar un sistema para gestionar solicitudes de préstamos. El sistema debe manejar la información de los clientes, evaluar su elegibilidad y registrar las solicitudes en la base de datos. Deberás aplicar al menos dos patrones GRASP para asegurar un diseño sólido y mantenible. Los actores involucrados son el 'solicitante del préstamo', el'motor de evaluación' y el'registro de solicitudes'. El sistema debe asegurar que no se registren solicitudes duplicadas (idempotencia del registro por número de solicitud), manejar errores de red del motor de evaluación (timeout >2s) y garantizar que las solicitudes sean consistentes entre el motor y el registro bajo eventos de alta carga (1 500 solicitudes/segundo en hora pico).

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Aplicación de Patrones GRASP en el Desarrollo de Sistemas |
| **Nivel** | junior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 15 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición del Sistema

**Objetivo:** Definir las entidades y relaciones del sistema de gestión de préstamos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Identifica las entidades clave del sistema (solicitante, préstamo, solicitud) y sus relaciones.
- Establece las reglas de negocio para la gestión de solicitudes (idempotencia, manejo de errores, consistencia).

**Entregable:** Diagrama de clases que representa las entidades y relaciones del sistema.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la aplicación del patrón 'Experto en Información' para asignar responsabilidades.
- Piensa en cómo aplicar el patrón 'Alta Cohesión y Bajo Acoplamiento' para mejorar la estructura del sistema.

</details>

### Fase 2: Implementación del Motor de Evaluación

**Objetivo:** Implementar el motor de evaluación que determina la elegibilidad de los solicitantes.

**Tiempo estimado:** 5 horas

**Instrucciones:**

- Desarrolla el componente que evalúa la elegibilidad de los solicitantes basándote en las reglas de negocio.
- Aplica el patrón 'Creador' para gestionar la creación de solicitudes.

**Entregable:** Componente funcional que evalúa la elegibilidad de los solicitantes y crea solicitudes.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la aplicación del patrón 'Creador' para separar la responsabilidad de crear solicitudes.
- Piensa en cómo manejar los errores de red del motor de evaluación.

</details>

### Fase 3: Registro de Solicitudes

**Objetivo:** Implementar el componente que registra las solicitudes en la base de datos.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Desarrolla el componente que registra las solicitudes en la base de datos, asegurando la idempotencia y consistencia.
- Aplica el patrón 'Controlador' para gestionar las solicitudes entrantes.

**Entregable:** Componente funcional que registra las solicitudes en la base de datos con garantías de idempotencia y consistencia.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la aplicación del patrón 'Controlador' para gestionar las solicitudes entrantes.
- Piensa en cómo asegurar la consistencia entre el motor de evaluación y el registro de solicitudes.

</details>

### Fase 4: Integración y Optimización

**Objetivo:** Integrar los componentes y optimizar el sistema para manejar la carga de solicitudes.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Integra el motor de evaluación y el componente de registro para formar un sistema completo.
- Optimiza el sistema para manejar la carga de solicitudes (1 500 solicitudes/segundo en hora pico).

**Entregable:** Sistema completo que gestiona solicitudes de préstamos con garantías de idempotencia, consistencia y capacidad para manejar alta carga.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la aplicación de patrones adicionales como 'Polimorfismo' para mejorar la flexibilidad del sistema.
- Piensa en cómo aplicar 'Indirección' para mejorar la escalabilidad.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los patrones GRASP y cómo se aplican en el diseño de sistemas?
- **paraQueSirve**: ¿Para qué sirven los patrones GRASP en el contexto del sistema de gestión de préstamos?
- **comoSeUsa**: ¿Cómo se aplican los patrones GRASP en la implementación del sistema?
- **erroresComunes**: ¿Cuáles son los errores comunes al aplicar patrones GRASP y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica la aplicación de patrones GRASP en el diseño y desarrollo del sistema?

## Criterios de Evaluacion

- Aplicación correcta de al menos dos patrones GRASP en el diseño y desarrollo del sistema.
- Garantía de idempotencia en el registro de solicitudes.
- Manejo adecuado de errores de red del motor de evaluación.
- Consistencia entre el motor de evaluación y el registro de solicitudes bajo alta carga.
- Optimización del sistema para manejar la carga de solicitudes (1 500 solicitudes/segundo en hora pico).

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
