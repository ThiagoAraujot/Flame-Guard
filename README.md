# Flame Guard - Forest Fire Detection and Response System

FlameGuard is a real-time monitoring system for detecting and responding to forest fires using drones, images, and location-based intelligence. Built with Java 17 and Spring Boot, it provides a robust RESTful API for managing drones, missions, images, alerts, and locations. Authentication and authorization are handled using Spring Security and JWT (JSON Web Tokens). All endpoints are documented and accessible via Swagger UI.

## 🚀 Badges

![Java 17](https://img.shields.io/badge/Java-17-brightgreen)
![Maven](https://img.shields.io/badge/Maven-4.0.0-blue)
![Status](https://img.shields.io/badge/Status-Finished-brightgreen)

## 🛠 Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **Swagger / OpenAPI**
- **Apache Maven**
- **Spring Data JPA**
- **PostgreSQL Database**

## ✅ Features

- 🔧 Full CRUD operations for:
  - Drones
  - Missions
  - Locations
  - Images
  - Alerts
  - Users
- 🔐 User authentication and authorization (JWT)
- 📄 API documentation with Swagger UI

## 📦 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/ThiagoAraujot/Flame-Guard.git
cd Flame-Guard
```

### 2. Build the project with Maven

```bash
mvn clean install
```

### 3. Run the application

```bash
mvn spring-boot:run
```

### 4. Access Swagger UI

Visit: http://localhost:8080/swagger-ui.html
