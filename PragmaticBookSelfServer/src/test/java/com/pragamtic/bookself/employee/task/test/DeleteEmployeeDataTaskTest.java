/**
 * 
 * Copyright *
 *
 */
package com.pragamtic.bookself.employee.task.test;

import org.junit.Test;

import com.pragamtic.bookself.employee.task.DeleteEmployeeDataTask;
import com.pragamtic.bookself.employee.task.RetrieveEmployeeDataByIDTask;
import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragamtic.bookself.result.PragmaticBookSelfResult;
import com.pragamtic.bookself.task.core.PragmaticBookselfTask;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;

import junit.framework.TestCase;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class DeleteEmployeeDataTaskTest extends TestCase {
	@Test
	public void testDeleteEmployeeData() throws PragmaticBookSelfException {
		int empId = 1;
		PragmaticBookselfTask<EmployeeEntity> delete = new DeleteEmployeeDataTask(empId);
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();

		PragmaticBookSelfResult<EmployeeEntity> result = delete.executeTask(session, context);
		
		System.out.print("Delete Successful");
		

	}

}
