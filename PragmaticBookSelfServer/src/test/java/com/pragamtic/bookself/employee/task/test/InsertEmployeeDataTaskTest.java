/**
 * 
 * Copyright *
 *
 */
package com.pragamtic.bookself.employee.task.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.pragamtic.bookself.employee.task.InsertEmployeeDatatTask;
import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragamtic.bookself.task.core.PragmaticBookselfTask;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;

import junit.framework.TestCase;

/**
 * @author amar
 *
 * @version 1.0
 */
public class InsertEmployeeDataTaskTest extends TestCase {

	/**
	 * Insert test case for insertion of data in employee table
	 * 
	 * @throws PragmaticBookSelfException
	 */
	@Test
	public void testInsertEmployeeData() throws PragmaticBookSelfException {
		int actualResult = 0;
		EmployeeEntity employee = new EmployeeEntity();
		employee.setAddress("room no 202");
		employee.setFname("Amar");
		employee.setLname("Singh");
		employee.setPhoneNo("+917207244657");
		PragmaticBookselfTask task = new InsertEmployeeDatatTask(employee);
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();
		actualResult = (int) task.executeTask(session, context).getResultedObject();

		int expectedResult = 0;
		String selectQuery = "SELECT * from employee where fname = ? and lname = ?";
		context = new StorageContext();
		try {
			PreparedStatement prepareStatement = context.getConnection().prepareStatement(selectQuery);
			prepareStatement.setString(1, "Amar");
			prepareStatement.setString(2, "Singh");

			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				expectedResult = (int) resultSet.getInt("id");
			}
			prepareStatement.close();

			String deleteQuery = "DELETE FROM EMPLOYEE WHERE ID = ?";
			prepareStatement = context.getConnection().prepareStatement(deleteQuery);
			prepareStatement.setInt(1, actualResult);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (PragmaticBookSelfException | SQLException e) {
			throw new PragmaticBookSelfException(e);
		}
		assertEquals(expectedResult, actualResult);
	}
}
