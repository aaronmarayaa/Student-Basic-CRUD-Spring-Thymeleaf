package com.example.Students.Service;

import com.example.Students.Exception.UserNotFoundException;
import com.example.Students.Model.Student;
import com.example.Students.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Student get(long id)
    {
        Optional<Student> result = studentRepository.findById(id);
        if(result.isPresent())
        {
            return result.get();
        }

        throw new UserNotFoundException("Student Not Found!");
    }

    public void delete(long id) throws UserNotFoundException
    {
        Long count = studentRepository.countById(id);
        if(count == null || count == 0) {
            throw new UserNotFoundException("Could not find user with ID: " + id);
        }

        studentRepository.deleteById(id);
    }
}
