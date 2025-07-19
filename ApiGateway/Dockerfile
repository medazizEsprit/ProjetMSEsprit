## Step 1: Build the application with Maven
#FROM maven:3.9.6-eclipse-temurin-17 AS build
#WORKDIR /ApiGateway
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#
## Step 2: Run the application with a lightweight JDK image
#FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
#WORKDIR /ApiGateway
#
## Copy the JAR file from the build stage
#COPY --from=build /ApiGateway/target/*.jar ApiGateway-0.0.1-SNAPSHOT.jar
#
## Expose the port (must match server.port in application.yml/properties)
#EXPOSE 8888
#
## Run the application
#ENTRYPOINT ["java", "-jar", "ApiGateway-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17
EXPOSE 8888
COPY target/ApiGateway-0.0.1-SNAPSHOT.jar ApiGateway.jar
ENTRYPOINT ["java","-jar","ApiGateway.jar"]