package com.huzaifabinzahoor.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.huzaifabinzahoor.hibernate.entity.Employee;

public class ReadingEmployeeObject {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// begin the transaction
			System.out.println("transaction is begining");
			session.beginTransaction();

			// My Code for object retrieval
			// query students
			List<Employee> theEmployees = session.createQuery("from Employee").list();

			// display the Employees
			displayEmployees(theEmployees);

			// code to retrieve an object by primary key

			theEmployees = session.createQuery("from Employee e where e.id='1'").list();

			// display the Employees
			displayEmployees(theEmployees);

			// code to query objects to find employees for a given company
			theEmployees = session.createQuery("from Employee e where e.company='KFC'").list();
			// display the Employees
			displayEmployees(theEmployees);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done !!! ");

		} finally {
			factory.close();
		}

	}

	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee allEmployee : theEmployees) {
			System.out.println(allEmployee);
		}
	}

}
