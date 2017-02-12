/**
 * 
 * Copyright *
 *
 */
package com.pragamtic.bookself.employee.task.test;

import java.util.List;

import org.junit.Test;

import com.pragamtic.bookself.employee.task.RetrieveAllEmployeeTask;
import com.pragamtic.bookself.exception.PragmaticBookSelfException;
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
public class RetrieveAllEmployeeTaskTest extends TestCase {

	@Test
	public void testRetrieveAllEmployeeData() throws PragmaticBookSelfException {
		PragmaticBookselfTask task = new RetrieveAllEmployeeTask();
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();
		List<EmployeeEntity> resultedObject = (List<EmployeeEntity>) task.executeTask(session, context)
				.getResultedObject();
		System.out.println("test");
	}
}
