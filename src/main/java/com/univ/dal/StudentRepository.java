package com.univ.dal;

import java.util.List;

import javax.persistence.EntityTransaction;

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
}
