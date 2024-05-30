#Clustered Data Warehouse Documentation

##Overview
The Clustered Data Warehouse is designed to accept FX deal details and persist them into a database. It ensures that duplicate requests are not imported, and it provides proper error handling and logging. Let’s dive into the details:

##Components
###Spring Boot Application: Handles request processing, validation, and data import.
###Database (MySQL): Stores FX deal details.
###Docker Compose: Sets up the development environment.

##Getting Started
Clone the GitHub repository: https://github.com/nisreen93/nisreen-ps-task
Ensure you have Docker and Docker Compose installed.
Set up environment variables (if needed) for database connection details.

##Project Structure
FXDealsAnalyzer/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.demo.config/
│   │   │       ├── SecurityConfig
│	│	│		├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── SecurityConfig.java
│	│	│	└── com.demo.dao/
│	│			└── DealDao.java
│	│	│	└── com.demo.exception.handler/
│	│	│		├── GlobalExceptionHandler.java
│	│	│	    └── DataIntegrityViolationException.java
│	│	│	└── com.demo.FXDealsAnalyzer/
│	│	│		├── AnalyzingRestController.java
│	│	│		└── FxDealsAnalyzerApplication.java
│	│	│	└── com.demo.model/
│	│	│		└── Deal.java
│	│	│	└── com.demo.service/
│	│	│		└── DealService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── logback.xml
│   └── test/
│       └── java/
│           └── com.demo.FXDealsAnalyzer/
│               └── FxDealsAnalyzerApplicationTest
├── docker-compose.yml
├── Makefile
├── FXAnalyzer.postman_collection.json (to import it from postman and test the API)
└── README.md

##Implementation Details
###Data Validation:
Validate request fields (Deal Unique Id, Currency ISO Codes, timestamp, and amount).
Handle missing fields and incorrect data types.
###Database Schema:
Create a MySQL table to store FX deal details.
Use an appropriate primary key (e.g., Deal Unique Id).

###Import Logic:
Check if the Deal Unique Id already exists in the database.
If not, insert the record.

###Error Handling:
Handle exceptions (e.g., invalid data, database errors).
Log errors using Logback.

###Unit Testing:
Write JUnit tests for service methods.
Aim for high test coverage.

##Deployment with Docker Compose:
Follow Makefile steps

##Usage
Build the project using Maven.
Start the Docker containers.
Send FX deal details via REST API (e.g., POST request to http://localhost:8080/fx/deal/save), you can use the attached postman collection for sample request.
