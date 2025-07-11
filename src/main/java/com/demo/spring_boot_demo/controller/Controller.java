package com.demo.spring_boot_demo.controller;

import com.demo.spring_boot_demo.model.Student;
import com.demo.spring_boot_demo.repositary.studentRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
     private studentRepositary StudentRepositary;
    @GetMapping("/getAll")
    public List<Student> getAllRecords()
    {
          return StudentRepositary.findAll();
    }
    @GetMapping("/get/{id}")
    public Optional<Student> getItemById(@PathVariable Integer id)
    {
                return StudentRepositary.findById(id);
    }
    @PostMapping("/insert")
    public List<Student> createRecord(@RequestBody List<Student> student)
    {
         return StudentRepositary.saveAll(student);
    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Integer id,@RequestBody Student student)
    {
        Student modifiedStudent = StudentRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        modifiedStudent.setName(student.getName());
       return StudentRepositary.save(modifiedStudent);
    }
    @DeleteMapping("/delete/{id}")
    public Student deleteRecord(@PathVariable Integer id)
    {
        Student data=StudentRepositary.findById(id) .orElseThrow(() -> new RuntimeException("Student not found"));
        StudentRepositary.delete(data);
        return data;

    }
}
