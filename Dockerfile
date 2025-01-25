# Use an official Java runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot jar file to the container
COPY target/web-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your app runs on (default Spring Boot port is 8080)
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
