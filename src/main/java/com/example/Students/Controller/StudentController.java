package com.example.Students.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student-management/home")
public class StudentController
{
    @GetMapping
    public String home() {
        return "index";
    }
}
