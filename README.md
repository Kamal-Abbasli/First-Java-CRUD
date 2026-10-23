# Java CRUD Student

A beginner-friendly CRUD web application built with Java, Spring Boot, Maven, Thymeleaf, Spring Data JPA, and an H2 database.

## Features

- **Create:** Add a new student.
- **Read:** View all students and student details.
- **Update:** Edit an existing student.
- **Delete:** Remove a student.
- Form validation for student name and email.
- H2 in-memory database with sample data.

## Requirements

- JDK 17 or newer
- IntelliJ IDEA
- Internet connection for Maven to download dependencies

## Run in IntelliJ IDEA

1. Extract the project ZIP file.
2. Open IntelliJ IDEA and select **File → Open**.
3. Select the extracted `java-crud-student` folder (the folder containing `pom.xml`).
4. Allow IntelliJ to import the Maven project and download dependencies.
5. Make sure the project SDK is Java 17 or newer.
6. Open `src/main/java/com/student/crud/JavaCrudStudentApplication.java`.
7. Click the green Run icon next to `JavaCrudStudentApplication`.
8. Open <http://localhost:8080> in your browser.

## Database console

While the application is running, open <http://localhost:8080/h2-console>.

Use these connection settings:

- JDBC URL: `jdbc:h2:mem:studentdb`
- User Name: `sa`
- Password: leave blank

The database is in memory, so its data is reset when the application stops.

## Main project structure

```text
java-crud-student/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/com/student/crud/
    │   │   ├── JavaCrudStudentApplication.java
    │   │   ├── controller/StudentController.java
    │   │   ├── model/Student.java
    │   │   ├── repository/StudentRepository.java
    │   │   └── config/DataInitializer.java
    │   └── resources/
    │       ├── application.properties
    │       ├── static/css/style.css
    │       └── templates/
    │           ├── students.html
    │           ├── student-form.html
    │           └── student-details.html
    └── test/java/com/student/crud/
        └── JavaCrudStudentApplicationTests.java
```

## CRUD mapping

| Operation | URL | HTTP method |
|---|---|---|
| List students | `/students` | GET |
| Show create form | `/students/new` | GET |
| Save a student | `/students` | POST |
| Show student details | `/students/{id}` | GET |
| Show edit form | `/students/{id}/edit` | GET |
| Delete a student | `/students/{id}/delete` | POST |

## Publish to GitHub

### Partner Review
Reviewed and contributed by Kamal Abbasli (Student ID: 73740).

```bash
git init
git add .
git commit -m "Create Java CRUD application"
git branch -M main
git remote add origin https://github.com/amurota74025/First-Java-CRUD
git push -u origin main
```


