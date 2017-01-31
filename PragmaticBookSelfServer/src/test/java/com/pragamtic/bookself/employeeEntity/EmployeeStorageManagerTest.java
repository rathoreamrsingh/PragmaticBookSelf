/**
 * 
 * @author amar
 *
 */
package com.pragamtic.bookself.employeeEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.employee.EmployeeStorageManager;
import com.pragmatic.bookself.storagecontext.StorageContext;

/**
 * @author amar
 *
 */
public class EmployeeStorageManagerTest {
	private static SessionFactory factory = null;
	private static Connection connection = null;

	@BeforeClass
	public static void setUpTestEnv() {
		try {
			Configuration configuration = new Configuration();
			factory = configuration.configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {

		}

		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://pragmaticbookself.ck9wnnstulez.ap-south-1.rds.amazonaws.com/pragmaticbookself",
					"scott", "scottscott");
		} catch (SQLException e) {

		}
	}

	@AfterClass
	public static void closeTestEnv() {
		if (factory != null) {
			factory.close();
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void insertEmployeeData() {
		int expectedResult = 2;
		/*
		 * Details of employee.
		 */
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setFname("Amar");
		employeeEntity.setLname("Singh");
		employeeEntity.setAddress("Room no 202, Anjali Gardens Apartment, Manikonda Hyderabad - 500089");
		employeeEntity.setPhoneNo("+917207244657");

		int actualResult = 0;
		try {
			/*
			 * Inserting data in database.
			 */
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			StorageContext storageContext = new StorageContext(session);
			actualResult = EmployeeStorageManager.getInstance().insertEmployeeData(employeeEntity, storageContext);
			tx.commit();

			if (session != null) {
				session.close();
			}
		} catch (PragmaticBookSelfException e) {
			fail("Caught exception" + e);
		}

		String selectQuery = "SELECT * from employee where fname = ? and lname = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(selectQuery);
			prepareStatement.setString(1, "Amar");
			prepareStatement.setString(2, "Singh");

			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				expectedResult = (int) resultSet.getInt("id");
			}
			prepareStatement.close();

			String deleteQuery = "DELETE FROM EMPLOYEE WHERE ID = ?";
			prepareStatement = connection.prepareStatement(deleteQuery);
			prepareStatement.setInt(1, actualResult);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(expectedResult, actualResult);
	}
}
