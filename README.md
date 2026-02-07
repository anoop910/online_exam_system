# online_exam_system
Project Setup Instructions
# Prerequisites
Java 17 (as specified in pom.xml)
Maven (for dependency management and building)
MySQL Database
Git
# Clone the Repository
git clone https://github.com/anoop910/online_exam_system.git
cd online_exam_system/onlineexamsystem
# Install Dependencies
The project uses Maven for dependency management.
Install all dependencies:
# Using Maven wrapper (recommended)
./mvnw clean install

# Or using Maven directly (if installed)
maven clean install
# Configure Database
Create a MySQL database for the project:

CREATE DATABASE online_exam_system;
Update the database configuration in:

src/main/resources/application.properties or application.yml
Add the following properties:
spring.datasource.url=jdbc:mysql://localhost:3306/online_exam_system
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
# Build the Project
./mvnw clean package

# Run the Application
./mvnw spring-boot:run
The application will start at: http://localhost:8080 (default Spring Boot port)
# Project Structure
online_exam_system/
│
├── onlineexamsystem/                    # Main Spring Boot application
│   ├── .mvn/                            # Maven wrapper configuration
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/techmaa/         # Main package root
│   │   │   │       ├── entity/          # JPA Entity classes (Model)
│   │   │   │       ├── repository/      # Spring Data JPA Repositories
│   │   │   │       ├── service/         # Business Logic Layer
│   │   │   │       ├── controller/      # REST API Controllers
│   │   │   │       ├── dto/             # Data Transfer Objects
│   │   │   │       ├── security/        # Security Configuration & JWT
│   │   │   │       ├── config/          # Application Configuration
│   │   │   │       └── OnlineexamsystemApplication.java  # Main Application Class
│   │   │   │
│   │   │   └── resources/
│   │   │       ├── application.properties    # Database & App Configuration
│   │   │       ├── application-dev.properties    # Development Profile
│   │   │       ├── application-prod.properties   # Production Profile
│   │   │       └── templates/           # HTML Templates (if using Thymeleaf)
│   │   │
│   │   └── test/                        # Unit & Integration Tests
│   │       └── java/
│   │           └── com/techmaa/
│   │
│   ├── pom.xml                          # Maven configuration file
│   ├── mvnw                             # Maven wrapper script (Linux/Mac)
│   ├── mvnw.cmd                         # Maven wrapper script (Windows)
│   ├── .gitignore                       # Git ignore rules
│   └── .gitattributes                   # Git attributes
│
├── projectAnalysis.excalidraw           # Project architecture diagram
├── README.md                             # Project documentation
└── .vscode/                             # VS Code configuration

Backend:

Framework: Spring Boot 4.0.2
Language: Java 17
ORM: Spring Data JPA
Database: MySQL
Authentication: Spring Security + JWT (JSON Web Tokens)
Validation: Spring Validation
Code Generator: Lombok (for boilerplate reduction)