/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.book.task.test;

import org.junit.Test;

import com.pragamtic.bookself.book.task.DeleteBookDataByIdTask;
import com.pragamtic.bookself.employee.task.DeleteEmployeeDataTask;
import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragamtic.bookself.result.PragmaticBookSelfResult;
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
public class DeleteBookDataByIdTaskTest extends TestCase {
	@Test
	public void testDeleteBookDataById()  throws PragmaticBookSelfException{
		int book_Id=1;
		PragmaticBookselfTask<BookEntity> delete = new DeleteBookDataByIdTask(book_Id);
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();

		PragmaticBookSelfResult<BookEntity> result = delete.executeTask(session, context);
		
		System.out.print("Delete Successful");
		
	}

}
