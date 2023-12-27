package com.example.Students;

import com.example.Students.Model.Student;
import com.example.Students.Service.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentsApplicationTests {

	@Autowired
	StudentService studentService;

	@Test
	public void saveStudentTest()
	{
		Student student = studentService.get(1);
		student.setPassword("thor123");
		Student saveStudent1 = studentService.saveStudent(student);

		Assertions.assertThat(saveStudent1).isNotNull();
		Assertions.assertThat(saveStudent1.getId()).isGreaterThan(0);
	}

}
