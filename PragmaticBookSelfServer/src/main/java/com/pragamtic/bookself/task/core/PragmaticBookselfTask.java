/**
 * 
 * Copyright *
 *
 */
package com.pragamtic.bookself.task.core;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;

/**
 * Base task for all the task upcoming. 
 * 
 * @author amar
 *
 */
public abstract class PragmaticBookselfTask {
	/**
	 * Initializes all the required data along with the validation of security
	 * session
	 * 
	 * @param session
	 *            - PragmaticBookSelf SecuritySession
	 * @param context
	 *            - PragmaticBookSelf StorageContext.
	 * @throws PragmaticBookSelfException
	 */
	public void init(PragmaticBookselfSession session, StorageContext context) throws PragmaticBookSelfException {
		/*
		 * todo : session check for existance of session
		 */

		Transaction transaction = null;
		try {
			transaction = context.getHibernateSession().beginTransaction();
		} catch (HibernateException | PragmaticBookSelfException e) {
			/*
			 * reverting the changes made in db.
			 */
			if (transaction != null)
				transaction.rollback();
			throw new PragmaticBookSelfException(e);
		} finally {
			/*
			 * committing the changes made to db.
			 */
			if (transaction != null)
				transaction.commit();
		}

	}

	/**
	 * Closes the connetion stablished. 
	 * @param session
	 *            - PragmaticBookSelf SecuritySession
	 * @param context
	 *            - PragmaticBookSelf StorageContext.
	 * @throws PragmaticBookSelfException
	 */
	private void close(PragmaticBookselfSession session, StorageContext context) throws PragmaticBookSelfException {
		try {
			context.close();
		} catch (Exception e) {
			throw new PragmaticBookSelfException(e);
		}
	}

	/**
	 * Validates the parameter passed based requirement of task.
	 * 
	 * @param session
	 *            - PragmaticBookSelf SecuritySession
	 * @param context
	 *            - PragmaticBookSelf StorageContext.
	 * @throws PragmaticBookSelfException
	 */
	protected abstract void validateParameter(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException;

	/**
	 * Defines the basic step for execution of task.
	 * @param session
	 *            - PragmaticBookSelf SecuritySession
	 * @param context
	 *            - PragmaticBookSelf StorageContext.
	 * @throws PragmaticBookSelfException
	 */
	public void executeTask(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		try {
			init(session, context);
			validateParameter(session, context);
			execute(session, context);
		} catch (Exception e) {
			throw new PragmaticBookSelfException(e);
		} finally {
			try {
				close(session, context);
			} catch (Exception e) {
				throw new PragmaticBookSelfException(e);
			}
		}

	}

	/**
	 * 
	 * @param session
	 *            - PragmaticBookSelf SecuritySession
	 * @param context
	 *            - PragmaticBookSelf StorageContext.
	 * @throws PragmaticBookSelfException
	 */
	protected abstract void execute(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException;
}
