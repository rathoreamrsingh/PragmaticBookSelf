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
	//galati testcase ka naam hamesha test se chalu hona chahiye
	@Test
	public void testUpdateEmployeeData() throws PragmaticBookSelfException {
		//galati kisko update karna hai wo object pass nahi kar rahe.
		//employee ka krna h pr kisme pass hoga
		EmployeeEntity employee = new EmployeeEntity();
		employee.setId(1);
		employee.setAddress("Bangalore karnataka "); //pehle ye sirf bangalore tha ab update kar rahe.
		employee.setFname("Guriya");
		employee.setLname("Kumari");
		employee.setPhoneNo("+9123456789"); //pehle ye sirf +91 tha
		PragmaticBookselfTask task = new UpdateEmployeeDataTask(employee);
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();
		EmployeeEntity resultedObject = (EmployeeEntity) task.executeTask(session, context).getResultedObject();
		System.out.print("test");
		
	}

}
