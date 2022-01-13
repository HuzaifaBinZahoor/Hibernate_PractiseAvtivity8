package com.huzaifabinzahoor.jdbcTesting;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJBDBC {

	public static void main(String[] args) {

		String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to Database:" + jdbcurl);
			Connection myConn = DriverManager.getConnection(jdbcurl, user, pass);
			System.out.println("Connection Successful");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
