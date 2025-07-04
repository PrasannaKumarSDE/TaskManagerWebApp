# TaskManagerWebApp
TaskManageWebApp
A simple Spring Boot web application Developed Java Backend Technologies using Java , Springboot ,hibernate,Maven to manage tasks using REST APIs, 

Technologies;
- Java 7 
- Spring Boot 3.5.3
- Spring MVC
- Spring Data JPA (Hibernate)
- Thymeleaf
- H2 
- Maven

Api Endpoints;
localhost:8080/api/tasks -->to post method (Create new task)
localhost:8080/api/tasks --> To get method (Get all tasks)
localhost:8080/api/tasks/{id} --> To put method (Update task by ID)
localhost:8080/api/tasks/{id} --> To delete method (Delete task by ID)

localhost:8080/h2-console:
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:TaskManagerWebApp
Username: sa
Password: 

To enter data using postman API Json for Post;
{
  "title": "Matter",
  "description": "Description",
  "dueDate": "yyyy-mm-dd",
  "status": "status"
}

Author:
Prasannakumar kanakala
