# CLAUDE.md

## Project Overview

This is a Java 21 Spring Boot application built with Maven.

The project uses:

* Java 21
* Spring Boot 4
* Maven
* Spring Data JPA
* PostgreSQL
* Flyway
* MapStruct
* Lombok
* Spotless
* JaCoCo
* SonarCloud

## Architecture

Follow the existing architecture and conventions of the project.

Prefer:

* Thin REST controllers
* Business logic in services
* Database access through repositories
* Clear separation between API, business, and persistence layers
* Existing project patterns over introducing new abstractions

Do not introduce new dependencies unless there is a clear justification.

## Code Review Priorities

When reviewing pull requests, prioritize findings in this order:

1. Security
2. Incorrect behavior and bugs
3. Data integrity
4. Reliability
5. Performance
6. Maintainability
7. Style

Only report issues that are genuinely worth addressing.

Do not report trivial stylistic issues that are already handled by Spotless.

Do not duplicate simple SonarCloud findings unless there is an additional architectural, behavioral, or security concern.

## Java and Spring

Pay particular attention to:

* Null handling
* Exception handling
* Transaction boundaries
* Spring dependency injection
* Incorrect bean configuration
* JPA entity relationships
* Lazy/eager loading problems
* N+1 queries
* Transactional behavior
* Repository query correctness
* Input validation
* REST API behavior
* HTTP status codes
* DTO/entity separation

Prefer clear, idiomatic Java and Spring Boot solutions.

Avoid unnecessary abstractions and over-engineering.

## Database

The application uses PostgreSQL and Flyway.

Review database-related changes for:

* Data integrity
* Migration correctness
* Backward compatibility
* Missing indexes where clearly necessary
* Incorrect relationships
* N+1 queries
* Potentially expensive queries
* Transactional consistency

Do not recommend changing a Flyway migration that has already been released or applied without considering the consequences.

Prefer new migrations for changes to an existing database schema.

## Testing

When a pull request introduces or changes behavior:

* Check whether appropriate tests exist.
* Identify important missing edge cases.
* Look for tests that do not actually verify the intended behavior.
* Pay particular attention to regression risks.

Prefer tests that verify observable behavior rather than implementation details.

New business logic should normally have appropriate unit tests.

Changes involving repositories, database behavior, controllers, or API integration should be considered for integration tests where appropriate.

## Security

Look for:

* Authentication and authorization problems
* Injection vulnerabilities
* Sensitive information exposure
* Credentials or secrets in source code
* Unsafe logging
* Insecure deserialization
* Improper input validation
* Broken access control
* Unsafe database queries
* Insecure configuration

Never recommend logging passwords, tokens, credentials, or other secrets.

If a secret or credential appears to have been committed, treat it as a high-priority security issue.

## Performance

Pay attention to:

* N+1 database queries
* Unnecessary database calls
* Unnecessary network calls
* Expensive operations inside loops
* Inefficient collection processing
* Excessive memory usage
* Unnecessary object creation
* Missing pagination for potentially large datasets

Only report performance issues when there is a reasonable basis for the concern.

Do not make speculative performance claims.

## REST API

When reviewing controllers and API changes, check:

* HTTP method correctness
* HTTP status codes
* Request validation
* Response consistency
* Error handling
* DTO usage
* Pagination
* API backwards compatibility
* Exposure of internal entities or implementation details

Controllers should remain relatively thin and delegate business logic to services.

## Code Formatting

The project uses Spotless with Google Java Format.

Do not report formatting or import-order issues that are automatically handled by Spotless.

Do not request manual formatting changes when Spotless can handle them.

## SonarCloud

The project uses SonarCloud for static analysis and code quality.

Do not duplicate trivial SonarCloud findings.

However, if a SonarCloud issue indicates a deeper architectural, security, reliability, or correctness problem, explain the higher-level concern.

## Pull Request Review Guidelines

Review the actual changes introduced by the pull request.

Do not review unrelated existing code unless it is directly relevant to a change in the pull request.

Prioritize actionable findings over general observations.

Do not report issues merely because you would personally implement the code differently.

A finding should have a concrete reason why the code could cause a problem or create meaningful technical debt.

Avoid excessive comments.

Prefer a small number of high-value findings over many low-value suggestions.

## Severity

Use these severity levels:

### CRITICAL

A serious security vulnerability, data-loss risk, or issue that can make the application unusable or severely compromised.

### HIGH

A significant bug, security problem, data-integrity issue, or reliability problem that should be fixed before merging.

### MEDIUM

A meaningful problem that could cause bugs, maintenance issues, or operational problems under realistic conditions.

### LOW

A minor improvement or low-risk issue that is still worth mentioning.

Do not use LOW for purely stylistic preferences.

## Review Output

For every finding:

1. Include the severity.
2. Clearly explain the problem.
3. Explain why it matters.
4. Identify the relevant code when possible.
5. Suggest a concrete fix when appropriate.

Keep findings concise and specific.

Do not overwhelm the developer with unnecessary explanations.

If there are no significant issues, explicitly state that the pull request looks good.

## Review-Only Mode

When running as an automated pull request reviewer:

* Do not modify project files.
* Do not create commits.
* Do not push changes.
* Do not change branches.
* Do not alter GitHub Actions workflows.
* Do not modify repository configuration.
* Only analyze the pull request and provide review feedback.

The purpose of the automated Claude review is to provide an additional perspective alongside Maven, Spotless, JaCoCo, and SonarCloud.

Human developers remain responsible for the final review and merge decision.
