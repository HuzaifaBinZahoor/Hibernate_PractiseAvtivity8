package com.huzaifabinzahoor.hibernate;

import java.text.ParseException;
import java.util.Date;

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
		Date theDateOfBirth = null;
		try {

			String theDateOfBirthStr = "31/12/1998";
			try {
				theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// create student Object
			System.out.println("Creating new Employee Object");
			Employee Emp1 = new Employee("A", "B", "AB", theDateOfBirth);

			// begin the transaction
			System.out.println("transaction is begining");
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the Employee object in DB");
			session.save(Emp1);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done, Saved the Employee Object Successfully !!! ");

		} finally {
			factory.close();
		}
	}

}
