# OnlineMicroShop
Restful CRUD API for a simple online shop application using Spring Boot, Mysql, JPA and Hibernate.

Requirements
Java - 1.8.x

Maven - 3.x.x

Mysql - 5.x.x

Steps to Setup
1. Clone the application


2. Create Mysql database
  create database music-app
  
3. Change mysql username and password as per your installation

  open src/main/resources/application.properties

  change spring.datasource.username and spring.datasource.password as per your mysql installation

4. Build and run the app using maven

mvn package
java -jar target/easy-notes-1.0.0.jar
Alternatively, you can run the app without packaging it using -

mvn spring-boot:run
The app will start running at http://localhost:8080.

Explore Rest APIs
The app defines following CRUD APIs.

GET /api/shop/music-samples

POST /api/music-samples

GET /api/music-samples/{id}

PUT /api/music-samples/{id}

DELETE /api/music-samples/{id}
You can test them using postman or any other rest client.
