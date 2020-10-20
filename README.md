# **_Task Manager_**

>## **_Instructions_**
>#### **_Backend: Java + Spring_**
>Esta prueba técnica consistirá en crear una pequeña aplicación backend que exponga una API
 REST que permita a un usuario gestionar una lista de tareas personalizada.
>
> La aplicación debe permitir tanto la creación de tareas nuevas, como el borrado y la edición
 de tareas existentes. Asímismo, una tarea ya realizada debe poder marcarse como finalizada.
>
> El candidato tendrá que desarrollar este ejercicio utilizando Java y Spring Framework,
 dejando a su libre elección tanto las versiones a utilizar como el resto de tecnologías que
 puedan necesitarse para completar la funcionalidad, como por ejemplo, la tecnología con la
 que se va a construir el proyecto (Maven, Gradle, Ant, etc).
>
> Como entregable final, se facilitará el acceso al código fuente original, en el formato elegido por
 el candidato, así como los pasos a seguir para poner la aplicación en marcha.

### **_1. How to start the backend application_**
After loading the zipped project in your preferred IDE, use Maven for compiling it:
```
mvn clean install
```
There aren't any profiles configured.

Run the application once it is already compiled using the IDE's command or button intended for it. For this project it has been used the IntelliJ platform, for example.

### **_2. Main specifications_**
The project has been developed with JAVA 8 and Spring Boot v2.3.4. 

It consists on an API REST with the typical HTTP crud operations:
- List all tasks
- Find a task by its _id_ attribute
- Create a new one task
- Delete a task
- Update an specific field from a task
- Update an entirily task

In order to save the data and be able to make changes on it, it has been included on the project an H2 embedded database.
Moreover, some dummy data is pre-loaded in the database when the project execution starts. 

Embedded database link:
http://localhost:8080/h2

See below the connection details: 

![H2 connection details](h2-connection.png) 


### **_3. Easy to check the final results_**
A Swagger implementation has been developed in order to see all the REST operations available, adding the possibility to make some testing calls with them. 

Swagger link:
http://localhost:8080/swagger-ui.html#

Also, some REST calls launched with Postman has been added to the project.