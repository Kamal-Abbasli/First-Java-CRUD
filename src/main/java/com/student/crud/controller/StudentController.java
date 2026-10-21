package com.student.crud.controller;

import com.student.crud.model.Student;
import com.student.crud.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }

    @GetMapping("/students/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("pageTitle", "Add Student");
        model.addAttribute("formAction", "/students");
        return "student-form";
    }

    @PostMapping("/students")
    public String createStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Add Student");
            model.addAttribute("formAction", "/students");
            return "student-form";
        }

        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String showStudent(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        model.addAttribute("student", student);
        return "student-details";
    }

    @GetMapping("/students/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        model.addAttribute("student", student);
        model.addAttribute("pageTitle", "Edit Student");
        model.addAttribute("formAction", "/students/" + id);
        return "student-form";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(
            @PathVariable Long id,
            @Valid @ModelAttribute("student") Student student,
            BindingResult bindingResult,
            Model model) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        if (bindingResult.hasErrors()) {
            student.setId(existingStudent.getId());
            model.addAttribute("pageTitle", "Edit Student");
            model.addAttribute("formAction", "/students/" + id);
            return "student-form";
        }

        student.setId(existingStudent.getId());
        studentRepository.save(student);
        return "redirect:/students";
    }

    @PostMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
        return "redirect:/students";
    }
}
