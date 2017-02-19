/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.book.task.test;

import org.junit.Test;

import com.pragamtic.bookself.book.task.UpdateBookDataTask;
import com.pragamtic.bookself.employee.task.UpdateEmployeeDataTask;
import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragamtic.bookself.task.core.PragmaticBookselfTask;
import com.pragmatic.bookself.book.BookEntity;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;

import junit.framework.TestCase;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class UpdateBookDataTaskTest extends TestCase{
	@Test
	public void testUpdateBookData() throws PragmaticBookSelfException{
		BookEntity book= new BookEntity();
		book.setId(1);
		book.setB_name("organic chemestry");
		book.setAuthor_id(109);
		PragmaticBookselfTask task = new UpdateBookDataTask(book);
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();
		BookEntity resultedObject = (BookEntity) task.executeTask(session, context).getResultedObject();
		System.out.print("test");
	}

}
