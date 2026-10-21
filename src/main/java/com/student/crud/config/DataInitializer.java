package com.student.crud.config;

import com.student.crud.model.Student;
import com.student.crud.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadSampleStudents(StudentRepository studentRepository) {
        return args -> {
            if (studentRepository.count() == 0) {
                studentRepository.save(new Student(
                        "Alex Johnson", "alex.johnson@example.com", "Computer Science"));
                studentRepository.save(new Student(
                        "Emily Davis", "emily.davis@example.com", "Software Engineering"));
                studentRepository.save(new Student(
                        "Michael Brown", "michael.brown@example.com", "Data Science"));
            }
        };
    }
}
