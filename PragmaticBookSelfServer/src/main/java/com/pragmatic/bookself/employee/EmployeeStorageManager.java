package com.pragmatic.bookself.employee;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;

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
	 * Insert employee data provided in employee table
	 * 
	 * @param listOfEmployee
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public int insertEmployeeData(List<EmployeeEntity> listOfEmployee, Session hibernateSessionx)
			throws PragmaticBookSelfException {
		int result = 0;

		Transaction tx = null;
		try {
			tx = hibernateSessionx.beginTransaction();
			for (EmployeeEntity emp : listOfEmployee) {
				result += (Integer) hibernateSessionx.save(emp);
				hibernateSessionx.flush();
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			hibernateSessionx.close();
		}

		return result;
	}

	/**
	 * Updates specific employee data
	 * 
	 * @param employee
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public int updateEmployeeData(EmployeeEntity employee) throws PragmaticBookSelfException {
		int result = 0;

		return result;
	}

	/**
	 * Retrieves all the employee data
	 * 
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public List<EmployeeEntity> retrieveAllEmployeeData() throws PragmaticBookSelfException {
		List<EmployeeEntity> listOfEmployeeData = null;

		return listOfEmployeeData;
	}

	/**
	 * Delete specific employee data based on employee id
	 * 
	 * @param employeeId
	 * @throws PragmaticBookSelfException
	 */
	public void deleteEmployeeData(int employeeId) throws PragmaticBookSelfException {

	}

	/**
	 * Gets employee data based on id
	 * 
	 * @param employeeId
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public EmployeeEntity getEmployeeDataById(int employeeId) throws PragmaticBookSelfException {
		EmployeeEntity result = null;

		return result;
	}

	/**
	 * Gets all the employee data which matches the name of provided in the
	 * parameter and returns that to the caller
	 * 
	 * @param name
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public List<EmployeeEntity> getEmployeeDataByName(String name) throws PragmaticBookSelfException {
		List<EmployeeEntity> listOfEmployees = null;

		return listOfEmployees;
	}
}
