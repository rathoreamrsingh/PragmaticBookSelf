/**
 * 
 * @author amar
 *
 */
package com.pragamtic.bookself.employeeEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.employee.EmployeeStorageManager;
import com.pragmatic.bookself.storagecontext.StorageContext;

import junit.framework.TestCase;

/**
 * @author amar
 *
 */
public class EmployeeStorageManagerTest extends TestCase{
	private static StorageContext storageContext = new StorageContext();

	@BeforeClass
	public static void setUpTestEnv() throws PragmaticBookSelfException {
		storageContext.init();
	}

	@AfterClass
	public static void closeTestEnv() throws PragmaticBookSelfException {
		storageContext.close();
	}

	@Test
	public void insertEmployeeData() throws PragmaticBookSelfException {
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
			Session session = storageContext.getHibernateSession();
			Transaction tx = session.beginTransaction();

			actualResult = EmployeeStorageManager.getInstance().insertEmployeeData(employeeEntity, storageContext);
			session.flush();
			tx.commit();

			if (session != null) {
				session.close();
			}
		} catch (PragmaticBookSelfException e) {
			fail("Caught exception" + e);
			e.printStackTrace();
		}

		String selectQuery = "SELECT * from employee where fname = ? and lname = ?";
		try {
			PreparedStatement prepareStatement = storageContext.getConnection().prepareStatement(selectQuery);
			prepareStatement.setString(1, "Amar");
			prepareStatement.setString(2, "Singh");

			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				expectedResult = (int) resultSet.getInt("id");
			}
			prepareStatement.close();

			String deleteQuery = "DELETE FROM EMPLOYEE WHERE ID = ?";
			prepareStatement = storageContext.getConnection().prepareStatement(deleteQuery);
			prepareStatement.setInt(1, actualResult);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (PragmaticBookSelfException | SQLException e) {
			throw new PragmaticBookSelfException(e);
		}
		assertEquals(expectedResult, actualResult);
	}
}
