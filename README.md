# Student Database CRUD API - Spring Boot

This is a simple Spring Boot application demonstrating basic CRUD operations on a **Student** database. The application uses Spring Data JPA repository, a REST controller, and a Student model.

---

## Features

- Create multiple student records
- Read all student records
- Read a student record by ID
- Update a student record by ID
- Delete a student record by ID

---

## Technologies Used

- Java 11+
- Spring Boot
- Spring Data JPA
- H2 / MySQL / any database (configure as per your application.properties)
- Maven/Gradle

---

## Project Structure

- **Model:** Student entity class
- **Repository:** StudentRepository extending JpaRepository
- **Controller:** REST Controller with CRUD endpoints

---

## Controller Endpoints

| HTTP Method | Endpoint        | Description                 | Request Body                 | Response                 |
|-------------|-----------------|-----------------------------|------------------------------|--------------------------|
| GET         | `/getAll`       | Get all student records     | None                         | List of Students         |
| GET         | `/get/{id}`     | Get student by ID           | None                         | Student object           |
| POST        | `/insert`       | Insert multiple students    | JSON array of Student objects | List of saved Students   |
| PUT         | `/update/{id}`  | Update student by ID        | JSON Student object          | Updated Student object   |
| DELETE      | `/delete/{id}`  | Delete student by ID        | None                         | Deleted Student object   |

---

## Sample Code Snippets

```java
@Autowired
private StudentRepository studentRepository;

@GetMapping("/getAll")
public List<Student> getAllRecords() {
    return studentRepository.findAll();
}

@GetMapping("/get/{id}")
public Optional<Student> getItemById(@PathVariable Integer id) {
    return studentRepository.findById(id);
}

@PostMapping("/insert")
public List<Student> createRecord(@RequestBody List<Student> student) {
    return studentRepository.saveAll(student);
}

@PutMapping("/update/{id}")
public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
    Student modifiedStudent = studentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Student not found"));
    modifiedStudent.setName(student.getName());
    return studentRepository.save(modifiedStudent);
}

@DeleteMapping("/delete/{id}")
public Student deleteRecord(@PathVariable Integer id) {
    Student data = studentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Student not found"));
    studentRepository.delete(data);
    return data;
}
