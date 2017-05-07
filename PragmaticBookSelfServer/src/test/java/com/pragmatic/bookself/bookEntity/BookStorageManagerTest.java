/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.bookEntity;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragmatic.bookself.book.BookEntity;
import com.pragmatic.bookself.book.BookStorageManager;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.employee.EmployeeStorageManager;
import com.pragmatic.bookself.storagecontext.StorageContext;

import junit.framework.TestCase;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class BookStorageManagerTest extends TestCase {
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
		 * Details of book.
		 */
		BookEntity bookEntity = new BookEntity();
		bookEntity.setB_name("algebra");
		bookEntity.setAuthor_id(201);
		bookEntity.setRating(4);
		bookEntity.setPub_date(Date(1/22/2001));

		int actualResult = 0;
		try {
			/*
			 * Inserting data in database.
			 */
			Session session = storageContext.getHibernateSession();
			Transaction tx = session.beginTransaction();

			actualResult = BookStorageManager.getInstance().insertBookData(bookEntity, storageContext);
			session.flush();
			tx.commit();

			if (session != null) {
				session.close();
			}
		} catch (PragmaticBookSelfException e) {
			fail("Caught exception" + e);
			e.printStackTrace();
		}

		String selectQuery = "SELECT * from book where b_name = ? and author_id = ?";
		try {
			PreparedStatement prepareStatement = storageContext.getConnection().prepareStatement(selectQuery);
			prepareStatement.setString(1, "algebra");
			prepareStatement.setInt(2,201);

			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				expectedResult = (int) resultSet.getInt("id");
			}
			prepareStatement.close();

			String deleteQuery = "DELETE FROM BOOK WHERE ID = ?";
			prepareStatement = storageContext.getConnection().prepareStatement(deleteQuery);
			prepareStatement.setInt(1, actualResult);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (PragmaticBookSelfException | SQLException e) {
			throw new PragmaticBookSelfException(e);
		}
		assertEquals(expectedResult, actualResult);

}

	/**
	 * @param i
	 * @return
	 */
	private Date Date(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
