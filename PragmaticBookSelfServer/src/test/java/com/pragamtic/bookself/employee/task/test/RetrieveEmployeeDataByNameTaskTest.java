/**
 * 
 * Copyright *
 *
 */
package com.pragamtic.bookself.employee.task.test;

import java.util.List;

import org.junit.Test;

import com.pragamtic.bookself.employee.task.RetrieveEmployeeDataByNameTask;
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
public class RetrieveEmployeeDataByNameTaskTest extends TestCase {
	@Test
	public void testRetrieveEmployeeDataByNameTask() throws PragmaticBookSelfException {
		String fname = "guriya";
		PragmaticBookselfTask<List<EmployeeEntity>> retrieve = new RetrieveEmployeeDataByNameTask(fname);
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();
		PragmaticBookSelfResult<List<EmployeeEntity>> result = retrieve.executeTask(session, context);
		List<EmployeeEntity> employeeEntityList = result.getResultedObject();

		for (EmployeeEntity entity : employeeEntityList) {
			System.out.println(entity.getAddress());
		}
	}

}
