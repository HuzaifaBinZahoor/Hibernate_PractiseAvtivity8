package com.huzaifabinzahoor.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.huzaifabinzahoor.hibernate.entity.Employee;

public class CreateEmployeeObject {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create student Object
			System.out.println("Creating new Employee Object");
			Employee Emp1 = new Employee("Ali", "Ahmed", "RFC");
			Employee Emp2 = new Employee("Shahzeeb", "Zahoor", "KFC");
			Employee Emp3 = new Employee("Max", "Saljook", "KINg");
			Employee Emp4 = new Employee("Schmidt", "Anarai", "AFC");
			Employee Emp5 = new Employee("Alex", "Hind", "Shinwari");
			Employee Emp6 = new Employee("Roy", "Lex", "ULOO");

			// begin the transaction
			System.out.println("transaction is begining");
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the Employee object in DB");
			session.save(Emp1);
			session.save(Emp2);
			session.save(Emp3);
			session.save(Emp4);
			session.save(Emp5);
			session.save(Emp6);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done, Saved the Employee Object Successfully !!! ");

		} finally {
			factory.close();
		}
	}

}
