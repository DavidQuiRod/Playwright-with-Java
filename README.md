# Playwright with Java

Proyecto de aprendizaje y práctica de automatización de pruebas web con
Playwright y Java, desde nivel básico hasta avanzado.

## Tecnologías
- Java 17+
- Java 21
- Maven
- Playwright for Java
- JUnit 5

## Requisitos previos
- JDK 17 o superior (`java -version`)
- Maven 3.8+ (`mvn -version`)
- IntelliJ IDEA (o el IDE de tu preferencia)

## Instalación
1. Clonar el repositorio:
```bash
   git clone <url-del-repo>
   cd playwright-java-academy
```
2. Descargar dependencias:
```bash
   mvn clean install -DskipTests
```
3. Instalar los navegadores de Playwright:
```bash
   mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
```

## Estructura del proyecto
```text
src/
 ├─ main/java/...      # Scripts de ejemplo y utilidades
 └─ test/java/...      # Pruebas automatizadas
pom.xml                # Dependencias y configuración de Maven
```

## Ejecución de pruebas
- Todas las pruebas:
```bash
  mvn test
```
- Una clase específica:
```bash
  mvn test -Dtest=EntornoTest
```
- Un método específico:
```bash
  mvn test -Dtest=EntornoTest#shouldRunChromium
```

## Configuración
- Navegador: Chromium / Firefox / WebKit
- Modo headless: activado o desactivado
- (Variables de entorno, URLs base, etc.)

## Evidencias
- Capturas de pantalla: `/screenshots`
- Trazas (trace viewer): `/traces`
- Reportes: `target/surefire-reports`

## Contenido del curso
- [x] Verificación del entorno
- [x] Primer script
- [x] Script con ventana (headed)
- [ ] Localizadores
- [ ] Esperas y aserciones
- [ ] Page Object Model
- [ ] Ejecución en CI

## Autor
David Quiroz