package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.model.Student;

@Controller
public class StudentController {
	List<Student> st = new ArrayList<>();
	@GetMapping("/home")
    public String showRegistration() {
        return "home";
    }
    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "registration";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute("student") Student student) {
    	st.add(student);
        return "redirect:/students";
    }
    
    @GetMapping("/students")
    public String showStudentList(Model model) {
        model.addAttribute("students", st);
        return "students";
    }
}
