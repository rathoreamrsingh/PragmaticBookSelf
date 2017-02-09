/**
 * 
 * Copyright *
 *
 */
package com.pragamtic.bookself.employee.task;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragamtic.bookself.result.PragmaticBookSelfResult;
import com.pragamtic.bookself.result.ResultCode;
import com.pragamtic.bookself.result.ResultCode.ResultCodes;
import com.pragamtic.bookself.task.core.PragmaticBookselfTask;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.employee.EmployeeStorageManager;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;

/**
 * @author amar
 *
 * @version 1.0
 */
public class InsertEmployeeDatatTask extends PragmaticBookselfTask<Integer> {

	private EmployeeEntity employee = null;

	/**
	 * constructor
	 */
	public InsertEmployeeDatatTask(EmployeeEntity employee) {
		this.employee = employee;
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
	protected PragmaticBookSelfResult<Integer> execute(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		// TODO Auto-generated method stub
		int resultId = 0;
		PragmaticBookSelfResult<Integer> result = new PragmaticBookSelfResult<Integer>();
		try {
			resultId = EmployeeStorageManager.getInstance().insertEmployeeData(employee, context);
		} catch (PragmaticBookSelfException pbe) {
			throw pbe;
		}
		result.setRestltedObject((Integer) resultId);
		result.setResultCode(new ResultCode(ResultCodes.SUCCESSFUL));
		return result;
	}

}
