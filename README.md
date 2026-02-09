# 📦 Warehouse Management System – Secure REST API

A **Spring Boot–based Warehouse Management System** that provides secure RESTful APIs for managing warehouse products.  
The application uses **JWT authentication**, **Spring Security**, and an **H2 in-memory database** to ensure secure and efficient backend operations.

---

## 📌 Project Overview

This project implements a **secure backend service** for warehouse product management.  
It allows authenticated users to perform CRUD operations on warehouse resources while ensuring proper access control using **JWT-based authentication**.

The system demonstrates real-world backend concepts such as authentication, authorization, token expiration, encrypted passwords, and REST API design.

---

## 🎯 Objectives

- Build a secure backend REST API using Spring Boot  
- Implement JWT-based authentication and authorization  
- Protect endpoints using Spring Security  
- Manage warehouse products with CRUD operations  
- Demonstrate clean backend architecture and security practices  

---


## 🧠 System Architecture

Client → Authentication API → JWT Token.

Client → Secured REST APIs → Warehouse Resources.


---

## ⚙️ Features

- User authentication using JWT
- Encrypted password storage
- Token expiration handling
- Secured RESTful APIs
- CRUD operations for warehouse products
- In-memory database for fast development and testing

---

## 🛠️ Tech Stack

### Backend
- Java  
- Spring Boot  
- Spring Security  
- JWT (JSON Web Token)

### Database
- H2 In-Memory Database

### API
- RESTful Web Services

---


## 🔐 Security Implementation

- JWT tokens are generated upon successful authentication
- Tokens are required to access secured endpoints
- Passwords are stored in encrypted format
- Token expiration is enforced to prevent unauthorized access
- Spring Security filters validate tokens for every request

---

## 🧪 Sample Authentication Flow

1. User sends credentials to `/authenticate`
2. Server validates credentials
3. JWT token is generated and returned
4. Client includes token in `Authorization` header
5. Secured endpoints validate the token before processing requests

---

### Steps to Run

1. Clone the repository
   ```bash
   - git clone https://github.com/thelogeshwer/Warehouse_Project.git
2. Navigate to the project directory
     - cd Warehouse_Project
3. Build and run the application
     - mvn spring-boot:run
4.Access the application
   - API runs on: http://localhost:8080
   - H2 Console: http://localhost:8080/h2-console

--- 

👤 Author

Logeshwer V
