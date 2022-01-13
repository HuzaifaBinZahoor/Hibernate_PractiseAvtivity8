package com.huzaifabinzahoor.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.huzaifabinzahoor.hibernate.entity.Employee;

public class DeleteEmployeeObject {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// Alternate approach for deleting the object
			// let suppose with id=2
			session.createQuery("delete from Employee where id=2").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			// New code for deleting

		} finally {
			// closing the sessionFactory
			factory.close();
		}
	}

}
