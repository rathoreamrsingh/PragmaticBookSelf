/**
 * 
 * Copyright *
 *
 */
package com.pragamtic.bookself.student.task;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragamtic.bookself.result.PragmaticBookSelfResult;
import com.pragamtic.bookself.result.ResultCode;
import com.pragamtic.bookself.result.ResultCode.ResultCodes;
import com.pragamtic.bookself.task.core.PragmaticBookselfTask;
import com.pragmatic.bookself.employee.EmployeeStorageManager;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;
import com.pragmatic.bookself.student.StudentEntity;
import com.pragmatic.bookself.student.StudentStorageManager;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class InsertStudentDatatTask extends PragmaticBookselfTask<Integer>{
	private StudentEntity student= null;

	/**
	 * @param message
	 */
	public InsertStudentDatatTask(StudentEntity student) {
		this.student=student;
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.pragamtic.bookself.task.core.PragmaticBookselfTask#validateParameter(com.pragmatic.bookself.session.PragmaticBookselfSession, com.pragmatic.bookself.storagecontext.StorageContext)
	 */
	@Override
	protected void validateParameter(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.pragamtic.bookself.task.core.PragmaticBookselfTask#execute(com.pragmatic.bookself.session.PragmaticBookselfSession, com.pragmatic.bookself.storagecontext.StorageContext)
	 */
	@Override
	protected PragmaticBookSelfResult<Integer> execute(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
			int resultId = 0;
			PragmaticBookSelfResult<Integer> result = new PragmaticBookSelfResult<Integer>();
			try {
				resultId = StudentStorageManager.getInstance().insertStudentData(student, context);
			} catch (PragmaticBookSelfException pbe) {
				throw pbe;
			}
			result.setRestltedObject((Integer) resultId);
			result.setResultCode(new ResultCode(ResultCodes.SUCCESSFUL));
			return result;
		
	}

}
