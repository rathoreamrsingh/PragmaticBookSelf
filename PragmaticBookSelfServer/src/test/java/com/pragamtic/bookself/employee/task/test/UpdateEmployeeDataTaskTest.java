/**
 * 
 * Copyright *
 *
 */
package com.pragamtic.bookself.employee.task.test;

import junit.framework.TestCase;
import org.junit.Test;

import com.pragamtic.bookself.employee.task.UpdateEmployeeDataTask;
import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragamtic.bookself.task.core.PragmaticBookselfTask;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;
/**
 * @author krishna
 *
 * @version 1.0
 */
public class UpdateEmployeeDataTaskTest extends TestCase {
	@Test
public void updateEmployeeData() throws PragmaticBookSelfException{
		PragmaticBookselfTask task = new UpdateEmployeeDataTask();
		PragmaticBookselfSession session =new PragmaticBookselfSession();
		StorageContext context = new StorageContext();
		EmployeeEntity resultedObject = (EmployeeEntity) task.executeTask(session, context).getResultedObject();
		System.out.print("test");
	}	

}
