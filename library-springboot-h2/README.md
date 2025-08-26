# Library App (Spring Boot + H2)

Simple REST API for managing books.

## Run
- Java 17+ and Maven required.
- In terminal: `mvn spring-boot:run`
- API base: `http://localhost:8080/api/books`
- H2 console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`)

## Endpoints
- `GET /api/books` — list
- `POST /api/books` — create ({ "title": "1984", "author": "George Orwell" })
- `GET /api/books/{id}` — get one
- `PUT /api/books/{id}` — update
- `DELETE /api/books/{id}` — delete
- `GET /api/books/search?q=orwell` — search by title/author
