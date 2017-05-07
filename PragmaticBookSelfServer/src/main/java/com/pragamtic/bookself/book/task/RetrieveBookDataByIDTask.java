/**
 * 
 * Copyright *
 *
 */
package com.pragamtic.bookself.book.task;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragamtic.bookself.result.PragmaticBookSelfResult;
import com.pragamtic.bookself.result.ResultCode;
import com.pragamtic.bookself.result.ResultCode.ResultCodes;
import com.pragamtic.bookself.task.core.PragmaticBookselfTask;
import com.pragmatic.bookself.book.BookEntity;
import com.pragmatic.bookself.book.BookStorageManager;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.employee.EmployeeStorageManager;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class RetrieveBookDataByIDTask extends PragmaticBookselfTask<BookEntity> {

	private int bookID;

	public RetrieveBookDataByIDTask(int bookID) {

		// TODO Auto-generated constructor stub
		this.bookID = bookID;
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
	protected PragmaticBookSelfResult<BookEntity> execute(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		// TODO Auto-generated method stub
		PragmaticBookSelfResult<BookEntity> result = new PragmaticBookSelfResult<BookEntity>();
		BookStorageManager.getInstance().getBookDataById(bookID, context);
		BookEntity bookEntity = BookStorageManager.getInstance().getBookDataById(bookID, context);
		result.setRestltedObject(bookEntity);
		result.setResultCode(new ResultCode(ResultCodes.SUCCESSFUL));
		return result;

	}

}
