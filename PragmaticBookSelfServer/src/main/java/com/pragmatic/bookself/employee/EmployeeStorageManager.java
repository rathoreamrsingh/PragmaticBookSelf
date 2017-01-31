package com.pragmatic.bookself.employee;

import java.util.List;

import org.hibernate.HibernateException;
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
		Transaction tx = null;
		try {
			result = (Integer) hibernateSession.save(employee);
			hibernateSession.flush();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
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
	public int updateEmployeeData(EmployeeEntity employee, StorageContext context) throws PragmaticBookSelfException {
		int result = 0;

		return result;
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

		return listOfEmployeeData;
	}

	/**
	 * Delete specific employee data based on employee id
	 * 
	 * @param employeeId
	 * @param context
	 * @throws PragmaticBookSelfException
	 */
	public void deleteEmployeeData(int employeeId, StorageContext context) throws PragmaticBookSelfException {

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
	public List<EmployeeEntity> getEmployeeDataByName(String name, StorageContext context)
			throws PragmaticBookSelfException {
		List<EmployeeEntity> listOfEmployees = null;

		return listOfEmployees;
	}
}
