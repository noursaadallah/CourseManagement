package com.univ.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UnitOfWork {

	private static UnitOfWork _uow;
	protected EntityManagerFactory emf;
	protected EntityManager em;
	
	
	public UnitOfWork() {
		super();
		emf = Persistence.createEntityManagerFactory("manager1");
		em = emf.createEntityManager();
	}
	
	//Singleton : maintain a unique connection to the Database at all times
	public static UnitOfWork getUnitOfWork() {
		if(_uow == null)
			_uow = new UnitOfWork();
		return _uow;
	}
}
