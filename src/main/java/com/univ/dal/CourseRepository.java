package com.univ.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.univ.model.Course;
import com.univ.model.Inscription;
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
	
	public List<Course> getCoursesByLevel(int level) {
		List<Course> res = _uow.em.createQuery(
				"SELECT c FROM Course c WHERE c.level = :level")
				.setParameter("level", level)
				.getResultList();
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
		
		EntityTransaction tx = _uow.em.getTransaction();
		try {
			tx.begin();
			_uow.em.merge(p);
			_uow.em.persist(c);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public Course updateCourse(long id , Course update) {
		Course origin = _uow.em.getReference(Course.class , id);
		origin.setAvailable(update.getAvailable() );
		origin.setCapacity(update.getCapacity() );
		origin.setDescription(update.getDescription() );
		origin.setLevel(update.getLevel());
		origin.setName(update.getName());
		EntityTransaction tx = _uow.em.getTransaction();
		try {
		tx.begin();
		_uow.em.merge(origin);
		tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return origin;
	}
	
	public void deleteCourse(long id) {
		Course c = _uow.em.getReference(Course.class , id);
		Professor p = _uow.em.getReference(Professor.class , c.getProfessor().getId());
		p.removeCourse(c);
		EntityTransaction tx = _uow.em.getTransaction();
		try {
		tx.begin();
		_uow.em.remove(c);
		_uow.em.merge(p);
		tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public List<Course> getCoursesByStudentId(long studentId) {
		Student s = _uow.em.getReference(Student.class, studentId);
		List<Course> res = new ArrayList<Course>();
		for(Inscription i : s.getInscriptions())
			res.add(i.getCourse());
		return res;
	}
}
