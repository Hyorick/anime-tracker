# Anime Tracker

A Spring Boot REST API for cataloging anime, their seasons and episodes — built as a hexagonal (ports & adapters) architecture on top of PostgreSQL.

## Tech Stack

- **Java 21** / **Spring Boot 4.0**
- **Spring Data JPA** + **PostgreSQL**
- **Flyway** for schema migrations (production)
- **MapStruct** for entity/DTO/domain mapping
- **springdoc-openapi** (Swagger UI)
- **Lombok**
- **Maven**

## Architecture

The `catalog` module follows a hexagonal architecture:

```
catalog/
├── domain/          # Core domain model (Anime, Season, Episode, Genre, Studio...)
├── usecase/          # Application services (ports) and their implementations
└── adapter/
    ├── web/          # REST controllers, request/response DTOs, mappers
    └── persistence/   # JPA entities, repositories, entity mappers
```

Two other bounded contexts (`identity`, `library`) currently hold domain models only and are not yet wired up to persistence or the API.

## Domain Model

- **Anime** — has a title, synopsis, release date, belongs to a `Studio`, and is tagged with one or more `Genre`s.
- **Season** — belongs to an `Anime`.
- **Episode** — belongs to a `Season`.

```
Anime (1) ─── (N) Season (1) ─── (N) Episode
  │
  ├── (1) Studio
  └── (N) Genre  (many-to-many)
```

## Getting Started

### Prerequisites

- JDK 21+
- Docker (for PostgreSQL)

### Run the database

```bash
docker compose -f docker-compose.yml -f docker-compose-dev.yml up -d
```

This starts PostgreSQL on `localhost:5432` with database `anime_tracker`. Set the following environment variables (e.g. in a `.env` file) before starting the containers:

```
POSTGRES_USER=<your-user>
POSTGRES_PASSWORD=<your-password>
```

### Run the application

The `dev` profile expects the datasource connection details as environment variables:

```
POSTGRES_URL=jdbc:postgresql://localhost:5432/anime_tracker
POSTGRES_USERNAME=<your-user>
POSTGRES_PASSWORD=<your-password>
```

Then run:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

In `dev`, Hibernate manages the schema directly (`ddl-auto=update`) and Flyway is disabled. In `prod`, Flyway migrations (`src/main/resources/db/migration`) manage the schema and Hibernate only validates it.

### API Documentation

With the app running, Swagger UI is available at:

```
http://localhost:8080/swagger-ui.html
```

## API Overview

Base path: `/api/catalog`

### Anime

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/animes` | List all anime |
| `GET` | `/animes/page` | List anime (paginated) |
| `GET` | `/animes/search` | Search by title, genre and/or studio (paginated) |
| `GET` | `/animes/{animeId}` | Get anime details |
| `GET` | `/animes/genre/{genre}` | Search anime by genre |
| `GET` | `/animes/studio/{studio}` | Search anime by studio |
| `POST` | `/animes` | Create an anime |
| `PUT` | `/animes/{animeId}` | Replace an anime |
| `PATCH` | `/animes/{animeId}` | Partially update an anime |
| `DELETE` | `/animes/{animeId}` | Delete an anime |

### Seasons

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/animes/{animeId}/seasons` | Add a season to an anime |
| `PUT` | `/animes/{animeId}/seasons/{seasonId}` | Replace a season |
| `PATCH` | `/animes/{animeId}/seasons/{seasonId}` | Partially update a season |
| `DELETE` | `/animes/{animeId}/seasons/{seasonId}` | Delete a season |

### Episodes

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/animes/{animeId}/seasons/{seasonId}/episodes` | Add an episode to a season |
| `PUT` | `/animes/{animeId}/seasons/{seasonId}/episodes/{episodeId}` | Replace an episode |
| `PATCH` | `/animes/{animeId}/seasons/{seasonId}/episodes/{episodeId}` | Partially update an episode |
| `DELETE` | `/animes/{animeId}/seasons/{seasonId}/episodes/{episodeId}` | Delete an episode |

## Roadmap

- Seasonal anime browsing (`GET /animes/seasonal`) — endpoint stubbed, not yet implemented
- `identity` module (users) and `library` module (per-user watch tracking) — domain modeled, not yet exposed via the API

## Testing

```bash
./mvnw test
```