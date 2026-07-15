# Visitor Log API

## Description

Visitor Log API is a simple Spring Boot REST API used to manage visitor records for a training center.

Data is stored in memory using a Java List, which means all data is lost when the application restarts.

## Endpoints

| Method | Endpoint | Description |
|----------|----------|----------|
| GET | /api/visitors | Get all visitors |
| GET | /api/visitors/{id} | Get visitor by ID |
| POST | /api/visitors | Add a visitor |
| DELETE | /api/visitors/{id} | Delete a visitor |
| GET | /api/visitors/count | Get total visitors |
| GET | /api/health | Health check |

### Bonus

| Method | Endpoint |
|----------|----------|
| PUT | /api/visitors/{id} |
| GET | /api/visitors/filter?purpose=meeting |

## Run Locally

```bash
mvn spring-boot:run
```

## Developer

Shahd Al Abdali
