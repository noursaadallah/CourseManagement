package com.univ.web.interfaces;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.univ.model.Student;

@Controller
@RequestMapping("students")
@CrossOrigin(origins = "http://localhost:4200")
public interface IStudentController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Student> getStudents();
	
	@RequestMapping(method = RequestMethod.POST , consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public void createStudent(@RequestBody Student student);
	
	@RequestMapping(value="/{email}/{password}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Student signIn( @PathVariable("email") String email,
						   @PathVariable("password") String password );
}
