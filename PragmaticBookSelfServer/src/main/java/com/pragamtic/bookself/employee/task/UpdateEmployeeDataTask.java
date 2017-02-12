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
 * @author krishna
 *
 * @version 1.0
 */
public class UpdateEmployeeDataTask extends PragmaticBookselfTask<EmployeeEntity>{
EmployeeEntity employee = new EmployeeEntity();
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
	protected PragmaticBookSelfResult<EmployeeEntity> execute(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		EmployeeEntity updateEmployee = EmployeeStorageManager.getInstance().updateEmployeeData(employee, context);
		PragmaticBookSelfResult<EmployeeEntity> pragamaticBookSelfResult = new PragmaticBookSelfResult<EmployeeEntity>();
		pragamaticBookSelfResult.setRestltedObject(updateEmployee);
		pragamaticBookSelfResult.setResultCode(new ResultCode(ResultCodes.SUCCESSFUL));
		
		
	
		return pragamaticBookSelfResult;
	}

}
