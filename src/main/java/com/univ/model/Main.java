package com.univ.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main 
{
	public static void main( String[] args )
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();

		try{

			tx.begin();

			Student s = new Student();
			s.setLevel(5);
			s.setFirstName("firstname");
			s.setLastName("lastName");
			s.setEmail("email");
			s.setPassword("password");
			
			Professor p = new Professor();
			p.setFirstName("firstname");
			p.setLastName("lastName");
			p.setEmail("email");
			p.setPassword("password");

			Inscription i = new Inscription();

			Course c = new Course();
			c.setAvailable(true);
			c.setCapacity(30);
			c.setDescription("description");
			c.setLevel(4);
			c.setName("name");
			
			c.setProfessor(p);
			i.setCourse(c);
			i.setStudent(s);
			

			entityManager.persist(p);
			entityManager.persist(s);
			entityManager.persist(c);
			entityManager.persist(i);

			tx.commit();			

		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}

	}
}
