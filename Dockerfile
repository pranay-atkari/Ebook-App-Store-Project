# Use official OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and project files
COPY . .

# Make mvnw executable
RUN chmod +x mvnw

# Build the Spring Boot app (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the Spring Boot jar
CMD ["java", "-jar", "target/Ebook-App-Project-0.0.1-SNAPSHOT.jar"]