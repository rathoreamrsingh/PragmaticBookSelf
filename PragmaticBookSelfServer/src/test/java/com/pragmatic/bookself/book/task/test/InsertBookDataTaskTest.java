/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.book.task.test;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.pragamtic.bookself.book.task.InsertBookDatatTask;
import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragamtic.bookself.task.core.PragmaticBookselfTask;
import com.pragmatic.bookself.book.BookEntity;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;

import junit.framework.TestCase;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class InsertBookDataTaskTest extends TestCase {
	@Test
	public void testInsertBookData() throws PragmaticBookSelfException {
		int result = 0;
		BookEntity book = new BookEntity();
		book.setB_name("Math");
		book.setAuthor_id(103);
		book.setRating(3);

		book.setPub_date(new Date(1991, 05, 19));
		PragmaticBookselfTask task = new InsertBookDatatTask(book);
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();
		result = (int) task.executeTask(session, context).getResultedObject();
		int expectedResult = 0;
		
		
		/**
		 * is code ki wajah se insert ho k delete ho jaega.
		 */
		String selectQuery = "SELECT * from book where b_name = ? and author_id = ?";
		context = new StorageContext();
		try {
			PreparedStatement prepareStatement = context.getConnection().prepareStatement(selectQuery);
			prepareStatement.setString(1, "Math");
			prepareStatement.setInt(2, 103);

			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				expectedResult = (int) resultSet.getInt("id");
			}
			prepareStatement.close();

			String deleteQuery = "DELETE FROM BOOK WHERE ID = ?";
			prepareStatement = context.getConnection().prepareStatement(deleteQuery);
			prepareStatement.setInt(1, result);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (PragmaticBookSelfException | SQLException e) {
			throw new PragmaticBookSelfException(e);
		}
		assertEquals(expectedResult, result);
	}

}
