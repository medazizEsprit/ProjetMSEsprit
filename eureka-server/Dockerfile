FROM openjdk:17
EXPOSE 8761
ADD target/eureka-server-0.0.1-SNAPSHOT.jar Eureka-docker.jar
ENTRYPOINT ["java","-jar","Eureka-docker.jar"]