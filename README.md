
# 📋 Dynamic Form Builder SaaS Platform

![Java](https://img.shields.io/badge/java-25-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring%20boot-4.0-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/postgresql-15-%23336791.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-%23000000.svg?style=for-the-badge&logo=jsonwebtokens&logoColor=white)

> **🚧 PROJECT STATUS: ACTIVE / IN DEVELOPMENT 🚧**
>
> Core modules including form management, authentication, payments, and workflow tracking are implemented and functional.  
> Additional optimizations, UI improvements, and scalability features are under development.

---

## 📋 Overview

The Dynamic Form Builder SaaS Platform is a centralized system for managing digital forms, payments, and workflows for E-Governance centers (CSC), educational institutes, and service providers.

It allows administrators to create dynamic forms, distribute them via public links or QR codes, and manage multi-branch submissions through a secure dashboard.

---

## ✨ Features

### ✅ Implemented

- **Dynamic Form Builder**  
  Configurable form fields (text, files, dropdowns, validation rules).

- **Multi-Branch Management**  
  Role-based access for Main Admins and Sub-Admins.

- **Integrated Payments**  
  Support for Razorpay and Stripe gateways.

- **Workflow Tracking**  
  Status lifecycle: Pending → In Review → Processing → Completed → Rejected.

- **Secure Storage & Export**  
  Encrypted uploads with Excel, PDF, and CSV exports.

- **Automated Notifications**  
  Email, SMS, and WhatsApp integration.

### 🚀 In Progress

- Advanced reporting dashboards  
- Performance optimization  
- Mobile-first UI enhancements  
- Cloud deployment automation  
- Audit logs and compliance features

---

## 🛠️ Tech Stack

### Backend (Java / Spring Boot)

- **Language:** Java 25  
- **Framework:** Spring Boot 4.0  
- **Security:** Spring Security, JWT (jjwt)  
- **Database:** PostgreSQL 15  
- **ORM:** Spring Data JPA (Hibernate)  
- **Documentation:** SpringDoc OpenAPI  
- **Utilities:** Lombok  

### Infrastructure

- **Containerization:** Docker, Docker Compose  
- **DB Management:** pgAdmin

---

## 📂 Project Structure

```text
root/
├── backend/
│   ├── src/main/java/...     # Controllers, Services, Security
│   ├── src/main/resources/  # Configurations
│   └── pom.xml              # Maven dependencies
│
├── docker-compose.yml       # PostgreSQL & pgAdmin setup
│
└── docs/                    # Technical documentation
````

---

## ⚙️ Getting Started

### Prerequisites

* Java 25+
* Maven
* Docker & Docker Compose

---

### 1. Database Setup (Docker)

Start PostgreSQL and pgAdmin:

```bash
docker-compose up -d
```

Access services:

* PostgreSQL: `localhost:5432`
* pgAdmin: `http://localhost:8081`

Login:

* Email: `admin@example.com`
* Password: `admin`

---

### 2. Backend Setup

Navigate to the backend directory:

```bash
cd backend
```

Configure:

```
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dynamic_forms_db
spring.datasource.username=postgres
spring.datasource.password=postgres
jwt.secret=your_secret_key
```

Run the application:

```bash
./mvnw spring-boot:run
```

Server starts at:

```
http://localhost:8080
```

---

### 3. API Documentation

Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

---


## 📌 Reference Files

The following files are included in this repository for technical reference:

* `pom.xml` — Maven dependencies and build configuration
* `docker-compose.yml` — PostgreSQL and pgAdmin setup
* API schemas and workflow diagrams (as per documentation)

These files represent previously available configurations and serve as the baseline for development and deployment.

---

## 🤝 Contributing

Contributions are welcome.

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/NewFeature`)
3. Commit changes
4. Push to branch
5. Open a Pull Request

---

*Created by **ANAS AJMERI***
