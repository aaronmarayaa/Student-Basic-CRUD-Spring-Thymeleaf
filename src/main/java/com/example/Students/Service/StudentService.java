package com.example.Students.Service;

import com.example.Students.Model.Student;
import com.example.Students.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        try {
            studentRepository.save(student);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Email already exists");
            // Or handle the error in a way that makes sense for your application
        }
        return student;
    }

    public List<Student> listAll()
    {
        return studentRepository.findAll();
    }
}
