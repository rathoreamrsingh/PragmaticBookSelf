/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.book;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Synchronize;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.storagecontext.StorageContext;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class BookStorageManager {
	// instance variable
	private static BookStorageManager instance = null;

	private BookStorageManager() {
		/*
		 * creating a private constructor so that this class cannot be
		 * instantiated outside of this class boundaries
		 */

	}

	public static BookStorageManager getInstance() {
		if (instance == null) {
			synchronized (BookStorageManager.class) {
				instance = new BookStorageManager();
			}
		}
		return instance;

	}

	/**
	 * Insert book data in the table.
	 * 
	 * @param book
	 * @param context
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public int insertBookData(BookEntity book, StorageContext context) throws PragmaticBookSelfException {
		Integer result = 0;
		Session hibernetSession = context.getHibernateSession();
		try {
			result = (Integer) hibernetSession.save(book);
			hibernetSession.flush();
		} catch (HibernateException e) {
			throw new PragmaticBookSelfException(e);

		}
		return (int) result;

	}

	public BookEntity deleteBookData(int bookId, StorageContext context) throws PragmaticBookSelfException {
		BookEntity result = null;
		Session hibernateSession = context.getHibernateSession();
		result = (BookEntity) hibernateSession.get(BookEntity.class, bookId);
		return result;

	}
}
