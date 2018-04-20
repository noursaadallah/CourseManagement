package com.univ.dal;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.univ.model.Professor;
import com.univ.model.Student;

public class ProfessorRepository {

	protected UnitOfWork _uow;
	
	public ProfessorRepository() {
		super();
		this._uow = UnitOfWork.getUnitOfWork();
	}
	
	public List<Professor> getProfessors() {
		List<Professor> res = _uow.em.createQuery("SELECT u FROM Professor u").getResultList();
		return res;
	}
	
	public void createProfessor(Professor p) {
		EntityTransaction tx = _uow.em.getTransaction();
		try {
			tx.begin();
			_uow.em.persist(p);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public Professor signIn(String email, String password) {
		Professor p = (Professor) _uow.em.createQuery(
				"SELECT p FROM Professor p WHERE p.email like :email and p.password like :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
		return p;
	}
}
