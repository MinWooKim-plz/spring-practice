package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "Alice", LocalDate.of(1990, 1, 1), 28, "alice@example.com")
        );
    }

}
