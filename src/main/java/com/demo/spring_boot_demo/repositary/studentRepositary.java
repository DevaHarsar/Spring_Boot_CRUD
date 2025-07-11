package com.demo.spring_boot_demo.repositary;

import com.demo.spring_boot_demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepositary extends JpaRepository<Student,Integer> {
}
