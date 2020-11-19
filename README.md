Spring Boot, MySQL, JPA, Hibernate Rest API Tutorial
Build Restful CRUD API for a simple Note-Taking application using Spring Boot, Mysql, JPA and Hibernate.

Requirements
Java - 11

Maven - 4.x.x

Mysql - 8.x.x

Steps to Setup
1. Clone the application

git clone https://github.com/rbbarreto/desafioBrasilpred.git
2. Create Mysql database

create database clientes
3. Change mysql username and password as per your installation

open src/main/resources/application.properties

change spring.datasource.username and spring.datasource.password as per your mysql installation

4. Build and run the app using maven

mvn spring-boot:run
The app will start running at http://localhost:9000.

Explore Rest APIs
The app defines following CRUD APIs.

GET /api/clientes

POST /api/clientes

GET /api/clientes/{Id}

PUT /api/clientes/{Id}

DELETE /api/clientes/{Id}
You can test them using postman or any other rest client.

