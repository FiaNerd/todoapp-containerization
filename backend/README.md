# Todo App - Backend

This is the backend service for the Todo application, built with **Java** and **Spring Boot**, connected to a **PostgreSQL** database running in Docker.

## Prerequisites

Make sure you have the following installed on your machine before getting started:
- **Java 17** (or newer)
- **Maven** (or you can use the included `./mvnw` wrapper)
- **Docker Desktop** (required to run the PostgreSQL database)

---

## Getting Started & Installation

### 1. Start the Database (Docker)
Make sure Docker Desktop is running. Start your PostgreSQL database container (either via your `docker-compose.yml` file in the project root or by running your container directly):
```bash
docker compose up -d

```

### 2. Run the Application

```bash
./mvnw spring-boot:run

```

## API Endpoints

* `GET http://localhost:8080/api/todos` - Get all todos
* `GET http://localhost:8080/api/todos/{id}` - Get a single todo by ID
* `POST http://localhost:8080/api/todos` - Create a new todo
* `PATCH http://localhost:8080/api/todos/{id}` - Update a todo
* `DELETE http://localhost:8080/api/todos/{id}` - Delete a todo
