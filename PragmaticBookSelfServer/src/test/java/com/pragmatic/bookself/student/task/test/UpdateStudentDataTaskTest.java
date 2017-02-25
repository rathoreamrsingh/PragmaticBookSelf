/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.student.task.test;

import org.junit.Test;

import com.pragamtic.bookself.employee.task.UpdateEmployeeDataTask;
import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragamtic.bookself.student.task.UpdateStudentDataTask;
import com.pragamtic.bookself.task.core.PragmaticBookselfTask;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;
import com.pragmatic.bookself.student.StudentEntity;

import junit.framework.TestCase;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class UpdateStudentDataTaskTest extends TestCase {
	@Test
	public void testUpdateStudentDataTask() throws PragmaticBookSelfException {

		StudentEntity student = new StudentEntity();
		student.setId(011143);
		student.setS_name("Priya");
		PragmaticBookselfTask task = new UpdateStudentDataTask(student);
		PragmaticBookselfSession session = new PragmaticBookselfSession();
		StorageContext context = new StorageContext();
		StudentEntity resultedObject = (StudentEntity) task.executeTask(session, context).getResultedObject();
		System.out.print("test");
	}

}
