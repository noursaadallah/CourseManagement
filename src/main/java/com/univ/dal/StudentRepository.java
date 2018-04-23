package com.univ.dal;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.univ.model.Course;
import com.univ.model.Inscription;
import com.univ.model.Professor;
import com.univ.model.Student;
import com.univ.model.User;

public class StudentRepository {

	protected UnitOfWork _uow;
	
	public StudentRepository() {
		super();
		this._uow = UnitOfWork.getUnitOfWork();
	}
	
	public List<Student> getStudents() {
		List<Student> res = _uow.em.createQuery("SELECT u FROM Student u").getResultList();
		return res;
	}
	
	public void createStudent(Student s) {
		EntityTransaction tx = _uow.em.getTransaction();
		try {
			tx.begin();
			_uow.em.persist(s);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public Student signIn(String email, String password) {
		Student s = (Student) _uow.em.createQuery(
				"SELECT p FROM Student p WHERE p.email like :email and p.password like :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
		return s;
	}
	
	public void enrollToCourse(long studentId, long courseId ) {
		Student s = _uow.em.getReference(Student.class, studentId);
		Course c = _uow.em.getReference(Course.class , courseId);
		Inscription i = new Inscription(c,s);
		s.addInscription(i);
		c.addInscription(i);
		EntityTransaction tx = _uow.em.getTransaction();
		try {
			tx.begin();
			_uow.em.merge(s);
			_uow.em.merge(c);
			_uow.em.persist(i);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public void withdrawFromCourse(long studentId, long courseId ) {
		Student s = _uow.em.getReference(Student.class, studentId);
		Course c = _uow.em.getReference(Course.class , courseId);
		
		Inscription i = (Inscription) _uow.em.createQuery(
				"SELECT i FROM Inscription i WHERE i.student = :student and i.course = :course")
				.setParameter("student", s)
				.setParameter("course", c)
				.getSingleResult();
		
		s.removeInscription(i);
		c.removeInscription(i);
		
		EntityTransaction tx = _uow.em.getTransaction();
		try {
			tx.begin();
			_uow.em.merge(s);
			_uow.em.merge(c);
			_uow.em.remove(i);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
}
