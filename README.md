# Crudapp-with-REST-API

Crudapp is a basic Rest API that can perform a bunch of crud operations as follows:
1. Add a User
2. Delete a User
3. Show all Users
4. Count the number of Users
5. Show Users by their Ids
6. Show Users by their names
7. Show Users by their phone number
8. Show Users by their email

The language, frameworks and development tools used are:
1. Java
2. Spring & Spring Boot (application framework)
3. Spring MVC
4. Spring Data JPA with Hibernate
5. MySql (sql database)
6. Apache Maven (build automation tool)
7. Apache Tomcat (web application server)

If you want to clone this repo and run it on your local machine, you should install java 17 on your system. Also, you'll have to 
install maven in order to download all the dependencies in your local machine. You won't be needing a tomcat server installed because 
there is an in-build server provided by the spring boot starter pack. By default, the API would be  running on localhost port 8090.
However, if this port is busy in your machine, you can change the port number by going to src/main/resources/application.properties 
and change server.port=8090 to any available port. Happy Crudding!!!

