package com.example.Students.Controller;

import com.example.Students.Exception.UserNotFoundException;
import com.example.Students.Model.Student;
import com.example.Students.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    // Save Student
    @PostMapping("/student-save")
    public String studentSave(Student student, RedirectAttributes redirectAttributes)
    {
        studentService.saveStudent(student);
        redirectAttributes.addFlashAttribute(
                "message",
                "The user has been successfully saved!");

        return "redirect:/student-management/home";
    }

    // Create new Student using form
    @GetMapping("/create-student")
    public String createStudentWithForm(Model model)
    {
        model.addAttribute("student", new Student());
        model.addAttribute("pageTitle", "Add new Student");

        return "student_form";
    }

    @GetMapping("/edit/student-{id}")
    public String editWithStudentForm(@PathVariable long id, Model model, RedirectAttributes redirectAttributes)
    {
        try {
            Student student = studentService.get(id);

            model.addAttribute("student", student);
            model.addAttribute("pageTitle", "Edit Student (ID :" + id + ")" );

            return "student_form";
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/student-management/home";
        }
    }

    @GetMapping("/delete/student-{id}")
    public String deleteUser(@PathVariable("id") long id, RedirectAttributes redirectAttributes)
    {
        try {
            studentService.delete(id);
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/student-management/home";
    }
}
