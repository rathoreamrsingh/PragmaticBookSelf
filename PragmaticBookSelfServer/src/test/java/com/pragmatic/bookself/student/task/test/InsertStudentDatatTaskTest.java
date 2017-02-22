/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.student.task.test;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.pragamtic.bookself.employee.task.InsertEmployeeDatatTask;
import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragamtic.bookself.student.task.InsertStudentDatatTask;
import com.pragamtic.bookself.task.core.PragmaticBookselfTask;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;
import com.pragmatic.bookself.student.StudentEntity;

import junit.framework.TestCase;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class InsertStudentDatatTaskTest extends TestCase{
	@Test
	public void testInsertStudentData() throws PragmaticBookSelfException {
		int actualResult = 0;
	StudentEntity student = new StudentEntity();
		student.setS_name("amar");
		student.setStream("CSE");
		student.setSemester("2");
		student.setStream("CSE");
		student.setId_issue_book(1);
		student.setBook_due_date(new Date(12-8-2016));
		PragmaticBookselfTask task = new InsertStudentDatatTask(student);
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();
		actualResult = (int) task.executeTask(session, context).getResultedObject();

		int expectedResult = 0;
		String selectQuery = "SELECT * from employee where s_name = ?";
		context = new StorageContext();
		try {
			PreparedStatement prepareStatement = context.getConnection().prepareStatement(selectQuery);
			prepareStatement.setString(1, "amar");
		

			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				expectedResult = (int) resultSet.getInt("id");
			}
			prepareStatement.close();

			
		} catch (PragmaticBookSelfException | SQLException e) {
			throw new PragmaticBookSelfException(e);
		}
		assertEquals(expectedResult, actualResult);
		System.out.print("Test");
	}
	

}
