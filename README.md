# Test assignment

This project is a Java application that connects to the Contact API to retrieve all contact records.

## Requirements

### Local application Setup

- Java 19
- Maven 3.9.2+


### Maven running
mvn spring-boot:run will setup the applcation on port 8080.
This application supports swagger on http://localhost:8080/swagger-ui/index.html#/

### Docker application setup

- Docker
- Docker-compose

If you are using docker, all you have to do is run `mvn clean package` and
then `docker-compose up -d --build`.

### Endpoint call

For calling the API, you have to execute the GET endpoint located on `/api/v1/contacts` It has no authentication and will consumes the provided contact API.



