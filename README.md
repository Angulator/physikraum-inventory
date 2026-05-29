# Physikraum Inventory

Ein Inventarsystem für den Physik-Nebenraum auf Basis von Spring Boot, Spring Security, JPA (Hibernate), Thymeleaf und Flyway.

## Schnellstart

Voraussetzungen: Docker und Docker Compose.

1. Datei `.env` aus `.env.example` erstellen und Werte ggf. anpassen.
2. Build und Start:
   docker compose up --build
3. Anwendung: http://localhost:8080

Standardzugang wird über Flyway-Seed erzeugt:
- Benutzer: admin
- Passwort: admin123 (wird beim ersten Login geändert)

## Entwicklung
- Start lokal (mit H2 oder Postgres): mvn spring-boot:run
- Tests: mvn test

## Docker
- Build: docker build -t physikraum-inventory .
- Run: docker run -p 8080:8080 physikraum-inventory

## Datenbankmigrationen
Flyway-Migrationen befinden sich unter `src/main/resources/db/migration`.
