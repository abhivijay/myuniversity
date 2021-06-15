###################University ######################

-- Prerequisite
Java 11 Open JDK

---------------------------------
 
 
 This Application is a spring boot rest API application which contain certain API. by using that API you can 
 perform CURD operation and custom query data.
 
 App will create an H2 database after successfully run and you can find DB detail in application.properties.
 
 Data base can be access through URL http://localhost:8080/myapp/h2 with valid login details.
 
 Application also insert some data based on data.sql file at resource folder.
 
 Application documentation can be access through swagger UI.
 http://localhost:8080/myapp/swagger-ui.html.
 
 you have to generate jwt token to access all API  expect /api/v1/user/login which use to generate token.
 userName=admin
 password=admin
 
 API can be run through swagger or postman based on documentation available inside project repo with name api-docs.json.
 
 
#########################################################################