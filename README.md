# Spring-JWT-Auth

This is a simple Spring Boot application that uses JWT for authentication. The project was created using the new Spring Security version 6.

## How it works

The application uses JWT for authentication. The JWT is generated using the user's username and password. 
The JWT is then sent to the client and stored in the local storage. The JWT is then sent to the server with every request. 
The server then validates the JWT and if it is valid, the request is processed.

## How the routes work

The application has 3 routes:

- /register
- /authenticate
- /demo

The `/register` route is used to register a new user. The user's username and password are sent to the server and the server creates a new user in the database.
The `/authenticate` route is used to authenticate a user. The user's username and password are sent to the server and the server generates a JWT for the user. To authenticate a user sucessfully, you need to provide the JWT Token in the header of the request.
The `/demo` route is used to test the authentication. The user needs to be authenticated to access this route.

## How to run the application

To run the application, you need to have Java 17+ and Maven installed on your machine. You also need to have a MySQL database running on your machine.

To run the application, follow the steps below:

- Clone the repository
- Open the `application.properties` file and change the `spring.datasource.username` and `spring.datasource.password` properties to match your MySQL database username and password
- Run `mvn clean install` to build the application
- Run `mvn spring-boot:run` to run the application

