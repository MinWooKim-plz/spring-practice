package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    //!!!!!!!!
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            // TODO: Implement population of Student data
            Student kim = new Student("kim", LocalDate.of(2004, 1, 3), 14, "kim@gamil.com");
            Student jane = new Student("jane", LocalDate.of(1998, 3, 15), 18, "jane@gmail.com");
            studentRepository.saveAll(List.of(kim, jane));
        };
    }
}
