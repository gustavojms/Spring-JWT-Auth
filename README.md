# Spring-JWT-Auth

This is a simple Spring Boot application that uses JWT for authentication. The project was created using the new Spring Security version 6.

## How it works

The application uses JWT for authentication. The JWT is generated using the user's username and password. 
The JWT is then sent to the client and stored in the local storage. The JWT is then sent to the server with every request. 
The server then validates the JWT and if it is valid, the request is processed.

