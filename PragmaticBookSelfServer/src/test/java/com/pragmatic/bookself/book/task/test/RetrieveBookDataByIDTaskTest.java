/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.book.task.test;

import org.junit.Test;

import com.pragamtic.bookself.book.task.RetrieveBookDataByIDTask;
import com.pragamtic.bookself.employee.task.RetrieveEmployeeDataByIDTask;
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
public class RetrieveBookDataByIDTaskTest extends TestCase{
	@Test
	public void testRetrieveEmployeeDataByIDTask() throws PragmaticBookSelfException {
		int bookID = 1;
		PragmaticBookselfTask<BookEntity> retrive = new RetrieveBookDataByIDTask(bookID);
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();
		
		PragmaticBookSelfResult<BookEntity> result = retrive.executeTask(session, context);
		BookEntity bookEntity = result.getResultedObject();
		
		System.out.println(bookEntity.getAuthor_id());

}
}
