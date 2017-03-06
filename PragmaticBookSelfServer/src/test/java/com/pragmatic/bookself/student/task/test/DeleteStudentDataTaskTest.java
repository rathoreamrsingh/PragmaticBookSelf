/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.student.task.test;

import org.junit.Test;

import com.pragamtic.bookself.book.task.DeleteBookDataByIdTask;
import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragamtic.bookself.result.PragmaticBookSelfResult;
import com.pragamtic.bookself.student.task.DeleteStudentDataTask;
import com.pragamtic.bookself.task.core.PragmaticBookselfTask;
import com.pragmatic.bookself.book.BookEntity;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;
import com.pragmatic.bookself.student.StudentEntity;

import junit.framework.TestCase;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class DeleteStudentDataTaskTest extends TestCase{
	@Test
	public void testDeleteStudentDataById() throws PragmaticBookSelfException{
		int studentId=1;
		PragmaticBookselfTask<StudentEntity> delete = new DeleteStudentDataTask(studentId);
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();

		PragmaticBookSelfResult<StudentEntity> result = delete.executeTask(session, context);
		
		System.out.print("Delete Successful");
		
	}

}
