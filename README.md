# Spring Boot CRUD Application

## Overview

This project is a simple CRUD (Create, Read, Update, Delete) application built using Spring Boot, Lombok, and PostgreSQL. The application manages a collection of books, each identified by a unique ISBN.

## Features

- **Create**: Add a new book to the collection.
- **Read**: Retrieve details of all books or a specific book by its ID.
- **Update**: Update the details of an existing book.
- **Delete**: Remove a book from the collection.

## Technologies Used

- **Spring Boot**: For building the REST API and managing dependencies.
- **Spring Data JPA**: For data persistence and repository support.
- **PostgreSQL**: As the relational database to store book data.
- **Lombok**: To reduce boilerplate code for model classes.
- **Gradle**: For project build and dependency management.

## Getting Started

### Prerequisites

- Java 17 or higher
- PostgreSQL
- Gradle

## Endpoints

- **GET /api/books**: Retrieve details of all books.
- **GET /api/books/{id}**: Retrieve details of a specific book by its ID.
- **POST /api/books**: Add a new book to the collection.
- **PUT /api/books/{id}**: Update details of an existing book.
- **DELETE /api/books/{id}**: Delete a book from the collection.
