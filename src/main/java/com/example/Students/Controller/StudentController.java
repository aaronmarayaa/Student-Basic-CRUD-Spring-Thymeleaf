package com.example.Students.Controller;

import com.example.Students.Model.Student;
import com.example.Students.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student-management/home")
public class StudentController
{
    @Autowired
    StudentService studentService;

    @GetMapping
    public String home() {
        return "index";
    }

    // Create Student
    @PostMapping("/student-save")
    public String createStudent(Student student)
    {
        studentService.saveStudent(student);

        return "redirect:/student-management/home";
    }
}
