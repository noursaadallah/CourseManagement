package com.univ.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.univ.model.Course;
import com.univ.model.Professor;
import com.univ.model.Student;

public class CourseRepository {

	protected UnitOfWork _uow;
	
	public CourseRepository() {
		super();
		this._uow = UnitOfWork.getUnitOfWork();
	}
	
	public List<Course> getCourses() {
		List<Course> res = _uow.em.createQuery("SELECT c FROM Course c").getResultList();
		return res;
	}
	
	public List<Course> getCoursesByProfessorId(long id) {
		Professor p = _uow.em.find(Professor.class , id);
		List<Course> res = new ArrayList<Course>( p.getCourses());
		return res;
	}
	
	public Course getCourseById(long id) {
		Course c = _uow.em.find(Course.class , id);
		return c;
	}
}
