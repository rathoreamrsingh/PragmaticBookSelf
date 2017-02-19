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
public class UpdateBookDataTask extends PragmaticBookselfTask<BookEntity> {
	private BookEntity book = null;

	/**
	 * 
	 */
	public UpdateBookDataTask(BookEntity book) {
		this.book = book;
		// TODO Auto-generated constructor stub
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
		BookEntity updateBook = BookStorageManager.getInstance().updateBookData(book, context);
		PragmaticBookSelfResult<BookEntity> pragamaticBookSelfResult = new PragmaticBookSelfResult<BookEntity>();
		pragamaticBookSelfResult.setRestltedObject(updateBook);
		pragamaticBookSelfResult.setResultCode(new ResultCode(ResultCodes.SUCCESSFUL));

		return pragamaticBookSelfResult;
		// TODO Auto-generated method stub

	}

}
