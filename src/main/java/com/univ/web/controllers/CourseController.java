package com.univ.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

	public void createCourse(@PathVariable("professorId") long professorId, @RequestBody Course c) {
		cr.createCourse(professorId,c);
	}
	
	public void updateCourse(@PathVariable("id") long id, @RequestBody Course c) {
		cr.updateCourse(id, c);
	}
	
	public void deleteCourse(@PathVariable("id") long id) {
		cr.deleteCourse(id);
	}
	
	public List<Course> getCoursesByLevel(@PathVariable("level") int level){
		return cr.getCoursesByLevel(level);
	}
}
