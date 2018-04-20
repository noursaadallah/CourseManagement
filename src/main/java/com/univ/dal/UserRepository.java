package com.univ.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.univ.model.Professor;
import com.univ.model.Student;
import com.univ.model.User;

public class UserRepository {

	protected UnitOfWork _uow;
	
	public UserRepository() {
		super();
		this._uow = UnitOfWork.getUnitOfWork();
	}
	
	public void addUser(String firstName , String lastName , String email , String password) {
		EntityTransaction tx = _uow.em.getTransaction();
		try {
			tx.begin();
			User u = new User(firstName , lastName , email , password );
			_uow.em.persist(u);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public List<User> getUsers() {
		List<User> res = _uow.em.createQuery("SELECT u FROM User u").getResultList();
		return res;
	}
}
