package com.example.Students.Controller;

import com.example.Students.Model.Student;
import com.example.Students.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student-management")
public class StudentController
{
    @Autowired
    StudentService studentService;

    @GetMapping("/home")
    public String home(Model model)
    {
        List<Student> listAll = studentService.listAll();
        model.addAttribute("listStudents", listAll);

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
