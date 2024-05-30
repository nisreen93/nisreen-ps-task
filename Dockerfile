# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-11-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the project's POM file
COPY pom.xml .

# Download project dependencies
RUN mvn dependency:go-offline

# Copy the entire project source code
COPY src/ ./src/

# Build the application
RUN mvn package

# Specify the command to run when the container starts
CMD ["java", "-jar", "target/FXDealsAnalyzer-1.0.jar"]