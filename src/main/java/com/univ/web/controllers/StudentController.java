package com.univ.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.univ.dal.StudentRepository;
import com.univ.model.Student;
import com.univ.web.interfaces.IStudentController;

@Controller
public class StudentController implements IStudentController {

	StudentRepository sr = new StudentRepository();
	
	public List<Student> getStudents() {
		return sr.getStudents();
	}
	
	public void createStudent(@RequestBody Student student) {
		sr.createStudent(student);
	}

	public Student signIn( @PathVariable("email") String email,
			   			   @PathVariable("password") String password ) {
		return sr.signIn(email, password);
	}
	
	public void enrollToCourse( @PathVariable("studentId") long studentId,
	   		   						@PathVariable("courseId") long courseId ) {
		sr.enrollToCourse(studentId, courseId);
	}
	
	public void withdrawFromCourse( @PathVariable("studentId") long studentId,
									@PathVariable("courseId") long courseId ) {
		sr.withdrawFromCourse(studentId, courseId);
	}

}
