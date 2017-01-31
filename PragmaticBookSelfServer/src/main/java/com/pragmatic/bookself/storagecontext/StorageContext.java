package com.pragmatic.bookself.storagecontext;

import org.hibernate.Session;

/**
 * This class is for keeping all the connection related object
 * 
 * @author amar
 *
 */
public class StorageContext {
	private Session hibernateSession = null;

	public StorageContext(Session hibernateSession) {
		this.hibernateSession = hibernateSession;
	}

	public Session getHibernateSession() {
		return hibernateSession;
	}

	public void setHibernateSession(Session hibernateSession) {
		this.hibernateSession = hibernateSession;
	}

}
