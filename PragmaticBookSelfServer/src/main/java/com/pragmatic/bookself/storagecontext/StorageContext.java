package com.pragmatic.bookself.storagecontext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;

/**
 * This class is for keeping all the connection related data
 * 
 * @author amar
 *
 */
public class StorageContext {
	private SessionFactory factory = null;
	private Connection connection = null;
	private Session session = null;
	private Transaction transaction = null;

	/**
	 * constructor
	 */
	public StorageContext() {
		try {
			init();
		} catch (PragmaticBookSelfException e) {
			e.printStackTrace();
		}
	}

	/**
	 * creates session factory, connection and opens Hibernate connection for
	 * the operation
	 * 
	 * @throws PragmaticBookSelfException
	 */
	public void init() throws PragmaticBookSelfException {
		createFactory();
		createConnection();
		openHibernateSession();
	}

	/**
	 * Opens Hibernate Session
	 * 
	 * @throws PragmaticBookSelfException
	 */
	private void openHibernateSession() throws PragmaticBookSelfException {
		try {
			if (session == null) {
				session = factory.openSession();
			}
		} catch (HibernateException he) {
			throw new PragmaticBookSelfException(he);
		}

	}

	/**
	 * Creates Session factory.
	 * 
	 * @throws PragmaticBookSelfException
	 */
	private void createFactory() throws PragmaticBookSelfException {
		try {
			Configuration configuration = new Configuration();
			factory = configuration.configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new PragmaticBookSelfException(ex);
		}
	}

	/**
	 * Creates Database Connection object.
	 * 
	 * @throws PragmaticBookSelfException
	 */
	private void createConnection() throws PragmaticBookSelfException {
		try {
			instantiateDatabaseDriverClass();
			connection = DriverManager.getConnection(
					"jdbc:postgresql://pragmaticbookself.ck9wnnstulez.ap-south-1.rds.amazonaws.com/pragmaticbookself",
					"scott", "scottscott");
		} catch (PragmaticBookSelfException | SQLException e) {
			throw new PragmaticBookSelfException(e);
		}
	}

	/**
	 * Instantiates Database Driver class
	 * 
	 * @throws PragmaticBookSelfException
	 */
	private void instantiateDatabaseDriverClass() throws PragmaticBookSelfException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new PragmaticBookSelfException(e);
		}
	}

	/**
	 * Closes the session, connection and factory
	 * 
	 * @throws PragmaticBookSelfException
	 */
	public void close() throws PragmaticBookSelfException {
		try {
			closeSession();
			closeConnection();
			closeFactory();
		} catch (PragmaticBookSelfException pbe) {
			throw pbe;
		}
	}

	/**
	 * Commits the transcation
	 */
	public void commitTransaction() throws PragmaticBookSelfException {
		try {
			if (transaction != null)
				transaction.commit();
		} catch (HibernateException he) {
			throw new PragmaticBookSelfException(he.getMessage());
		}
	}

	public void rollbackTransaction() throws PragmaticBookSelfException {
		try {
			if (transaction != null)
				transaction.rollback();
		} catch (HibernateException he) {
			throw new PragmaticBookSelfException(he.getMessage());
		}
	}

	/**
	 * Flushes the session and closes that for the user
	 * 
	 * @throws PragmaticBookSelfException
	 */
	private void closeSession() throws PragmaticBookSelfException {
		if (session != null) {
			try {
				session.flush();
				session.close();
			} catch (HibernateException hbe) {
				throw new PragmaticBookSelfException(hbe);
			}
		}
	}

	/**
	 * Closes connection
	 * 
	 * @throws PragmaticBookSelfException
	 */
	private void closeConnection() throws PragmaticBookSelfException {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PragmaticBookSelfException(e);
			}
		}
	}

	/**
	 * Closes factory
	 * 
	 * @throws PragmaticBookSelfException
	 */
	private void closeFactory() throws PragmaticBookSelfException {
		if (factory != null) {
			try {
				factory.close();
			} catch (HibernateException hbe) {
				throw new PragmaticBookSelfException(hbe);
			}
		}
	}

	/**
	 * Returns Hibernate session object
	 * 
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public Session getHibernateSession() throws PragmaticBookSelfException {
		if (factory == null)
			init();
		return session;
	}

	/**
	 * Returns JDBC connection object.
	 * 
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public Connection getConnection() throws PragmaticBookSelfException {
		if (connection == null)
			init();
		return connection;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
