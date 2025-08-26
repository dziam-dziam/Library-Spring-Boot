## Description
A simple REST API for managing books, built with Spring Boot and H2 in-memory database.  
The project demonstrates CRUD operations, search functionality, and enum-based status management.

## Features
- Create, read, update, and delete books
- Manage book status (AVAILABLE, BORROWED, RESERVED)
- Search books by title or author
- Store books in H2 in-memory database
- REST endpoints tested with Postman

## Technologies
- Java 17
- Spring Boot (Web, Data JPA, Validation)
- H2 Database
- Maven

## Endpoints
- `GET /api/books` – list all books
- `GET /api/books/{id}` – get a specific book
- `POST /api/books` – create a book (`{ "title": "1984", "author": "George Orwell" }`)
- `PUT /api/books/{id}` – update a book
- `DELETE /api/books/{id}` – delete a book
- `GET /api/books/search?q=orwell` – search by title/author
