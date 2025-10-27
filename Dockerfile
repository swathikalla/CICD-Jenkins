# Multi-stage build for Java application

# Stage 1: Build stage
FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
FROM openjdk:11-jre-slim
WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/target/java-ci-demo-1.0-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
