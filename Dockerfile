FROM openjdk:21-jdk-slim
COPY target/assignment-1.0.0.jar app.jar
EXPOSE ${SERVER_PORT}
ENTRYPOINT ["java","-jar","app.jar"]