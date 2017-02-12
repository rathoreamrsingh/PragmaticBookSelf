/**
 * 
 * Copyright *
 *
 */
package com.pragamtic.bookself.employee.task.test;

import org.junit.Test;

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
public class RetrieveEmployeeDataByIDTaskTest extends TestCase {
	@Test
	public void testRetrieveEmployeeDataByIDTask() throws PragmaticBookSelfException {
		int empID = 1;
		PragmaticBookselfTask<EmployeeEntity> retrive = new RetrieveEmployeeDataByIDTask(empID);
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();
		//kyuki kal ham id pe ek entry dale the ok // kaise dekhe the
		PragmaticBookSelfResult<EmployeeEntity> result = retrive.executeTask(session, context);
		EmployeeEntity employeeEntity = result.getResultedObject();
		
		System.out.println(employeeEntity.getAddress());

	}
}
