package com.univ.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.univ.web.interfaces.ICourseController;
import com.univ.dal.CourseRepository;
import com.univ.model.Course;

@Controller
public class CourseController implements ICourseController {
	
	CourseRepository cr = new CourseRepository();
	
	public List<Course> getCourses(){
		return cr.getCourses();
	}


	public Course getCourse(@PathVariable("id") long id){
		return cr.getCourseById(id);
	}


	public List<Course> getCoursesByProfessorId(@PathVariable("id") long id){
		return cr.getCoursesByProfessorId(id);
	}
}
