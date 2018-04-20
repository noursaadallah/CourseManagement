package com.univ.web.interfaces;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.univ.model.Course;

@Controller
@RequestMapping("courses")
@CrossOrigin(origins = "http://localhost:4200")
public interface ICourseController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody //return type is written to the HTTP response body (and not placed in a Model, or interpreted as a view name)
	public List<Course> getCourses();
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Course getCourse(@PathVariable("id") long id);
	
	@RequestMapping(value = "/byprofessor/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Course> getCoursesByProfessorId(@PathVariable("id") long id);
	
}
