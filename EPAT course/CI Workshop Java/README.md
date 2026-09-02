# CI Workshop - Spring Boot Demo

This project implements Parts One and Two of the NUS CI Workshop. Part Three
(Railway deployment and Docker) is intentionally not included.

## Local run

```bash
./mvnw -B verify
./mvnw spring-boot:run
```

The demo endpoints are `/`, `/version`, `/nations`, and `/currencies`.

## GitHub setup for Part Two

1. Create a GitHub repository and push this project to the `main` branch.
2. GitHub Actions runs build, unit tests, JaCoCo coverage (minimum 90% line
   coverage), and uploads the JaCoCo HTML report on every push or pull request.
3. Create a SonarCloud project, add repository variable `SONAR_PROJECT_KEY`,
   and add repository secret `SONAR_TOKEN`. The Sonar job then runs automatically.
4. Add repository variable `SNYK_ENABLED` with value `true` and repository
   secret `SNYK_TOKEN` to enable the Snyk dependency scan.

The SonarCloud and Snyk jobs are skipped until their required secrets are
configured, so the basic CI build works immediately after the first push.
