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
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;
import com.pragmatic.bookself.student.StudentEntity;
import com.pragmatic.bookself.student.StudentStorageManager;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class UpdateStudentDataTask extends PragmaticBookselfTask<StudentEntity> {
	private StudentEntity student = null;

	public UpdateStudentDataTask(StudentEntity student) {

		this.student = student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pragamtic.bookself.task.core.PragmaticBookselfTask#validateParameter(
	 * com.pragmatic.bookself.session.PragmaticBookselfSession,
	 * com.pragmatic.bookself.storagecontext.StorageContext)
	 */
	@Override
	protected void validateParameter(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pragamtic.bookself.task.core.PragmaticBookselfTask#execute(com.
	 * pragmatic.bookself.session.PragmaticBookselfSession,
	 * com.pragmatic.bookself.storagecontext.StorageContext)
	 */
	@Override
	protected PragmaticBookSelfResult<StudentEntity> execute(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		// TODO Auto-generated method stub
		StudentEntity updateStudent = StudentStorageManager.getInstance().updateStudentData(student, context);
		PragmaticBookSelfResult<StudentEntity> pragmaticBookselfResult = new PragmaticBookSelfResult<StudentEntity>();
		pragmaticBookselfResult.setRestltedObject(updateStudent);
		pragmaticBookselfResult.setResultCode(new ResultCode(ResultCodes.SUCCESSFUL));
		return pragmaticBookselfResult;
	}

}
