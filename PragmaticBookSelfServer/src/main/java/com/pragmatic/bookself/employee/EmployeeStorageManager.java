package com.pragmatic.bookself.employee;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragmatic.bookself.storagecontext.StorageContext;

/**
 * This class is for the performing basic CRUD operation on employee data. This
 * is a singleton class, means at a time only one object of the class can exist
 * in the system.
 * 
 * @author amar
 *
 */
public class EmployeeStorageManager {
	// instance object
	private static EmployeeStorageManager instance = null;

	// constructor
	private EmployeeStorageManager() {
		/*
		 * creating a private constructor so that this class cannot be
		 * instantiated outside of this class boundaries
		 */
	}

	public static EmployeeStorageManager getInstance() {
		/*
		 * If no instance is present then creating a new one.
		 */
		if (instance == null) {
			synchronized (EmployeeStorageManager.class) {
				instance = new EmployeeStorageManager();
			}
		}
		return instance;
	}

	/**
	 * Insert employee data in the table.
	 * 
	 * @param employee
	 * @param context
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public int insertEmployeeData(EmployeeEntity employee, StorageContext context) throws PragmaticBookSelfException {
		Integer result = 0;
		Session hibernateSession = context.getHibernateSession();
		try {
			result = (Integer) hibernateSession.save(employee);
			hibernateSession.flush();
		} catch (HibernateException e) {
			throw new PragmaticBookSelfException(e);
		}

		return (int) result;
	}

	/**
	 * Updates specific employee data
	 * 
	 * @param employee
	 * @param context
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public EmployeeEntity updateEmployeeData(EmployeeEntity employee, StorageContext context)
			throws PragmaticBookSelfException {

		Session hibernateSession = context.getHibernateSession();
		
		try {
			hibernateSession.update(employee);
		} catch (HibernateException he) {
			throw new PragmaticBookSelfException(he);
		}
		
		
		hibernateSession.evict(employee);

		return employee;
	}

	/**
	 * Retrieves all the employee data
	 * 
	 * @param context
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public List<EmployeeEntity> retrieveAllEmployeeData(StorageContext context) throws PragmaticBookSelfException {
		List<EmployeeEntity> listOfEmployeeData = null;

		Session hibernateSession = context.getHibernateSession();

		String queryString = "FROM EmployeeEntity"; // select * from employee;//
		try {
			Query query = hibernateSession.createQuery(queryString);
			listOfEmployeeData = query.list();
		} catch (HibernateException he) {
			throw new PragmaticBookSelfException(he);
		}
		return listOfEmployeeData;
	}

	/**
	 * Delete specific employee data based on employee id
	 * 
	 * @param employeeId
	 * @param context
	 * @throws PragmaticBookSelfException
	 */
	public EmployeeEntity deleteEmployeeData(int employeeId, StorageContext context) throws PragmaticBookSelfException {
		EmployeeEntity result=null;
		Session hibernateSession=context.getHibernateSession();
		result=(EmployeeEntity) hibernateSession.get(EmployeeEntity.class, employeeId);
		return result;

	}

	/**
	 * Gets employee data based on id
	 * 
	 * @param employeeId
	 * @param context
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public EmployeeEntity getEmployeeDataById(int employeeId, StorageContext context)
			throws PragmaticBookSelfException {
		EmployeeEntity result = null;
		Session hibernateSession = context.getHibernateSession();
		result = (EmployeeEntity) hibernateSession.get(EmployeeEntity.class, employeeId);

		return result;
	}

	/**
	 * Gets all the employee data which matches the name of provided in the
	 * parameter and returns that to the caller
	 * 
	 * @param name
	 * @param context
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public EmployeeEntity getEmployeeDataByName(String name, StorageContext context)
			throws PragmaticBookSelfException {
		EmployeeEntity result = null;
Session hibernateSeesion = context.getHibernateSession();
result = (EmployeeEntity) hibernateSeesion.get(EmployeeEntity.class,  name);
		return result;
	}
}
