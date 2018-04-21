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
	
	public void createCourse(long professorId , Course c) {
		Professor p = _uow.em.find(Professor.class , professorId);
		p.addCourse(c);
		c.setProfessor(p);
		_uow.em.merge(p);
	}
	
	public Course updateCourse(long id , Course update) {
		Course origin = _uow.em.getReference(Course.class , id);
		origin.setAvailable(update.getAvailable() );
		origin.setCapacity(update.getCapacity() );
		origin.setDescription(update.getDescription() );
		origin.setLevel(update.getLevel());
		origin.setName(update.getName());
		_uow.em.merge(origin);
		return origin;
	}
	
	public void deleteCourse(long id) {
		Course c = _uow.em.getReference(Course.class , id);
		Professor p = _uow.em.find(Professor.class , c.getProfessor().getId());
		p.removeCourse(c);
		_uow.em.remove(c);
		_uow.em.merge(p);
	}
}
