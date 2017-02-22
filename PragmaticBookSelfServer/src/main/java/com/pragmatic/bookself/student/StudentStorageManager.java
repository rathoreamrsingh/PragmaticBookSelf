/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.student;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.employee.EmployeeStorageManager;
import com.pragmatic.bookself.storagecontext.StorageContext;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class StudentStorageManager {
	private static StudentStorageManager instance = null;

	// constructor
	private StudentStorageManager() {
		/*
		 * creating a private constructor so that this class cannot be
		 * instantiated outside of this class boundaries
		 */
	}

	public static StudentStorageManager getInstance() {
		/*
		 * If no instance is present then creating a new one.
		 */
		if (instance == null) {
			synchronized (StudentStorageManager.class) {
				instance = new StudentStorageManager();
			}
		}
		return instance;
	}

	/**
	 * Insert student data in the table.
	 * 
	 * @param student
	 * @param context
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public int insertStudentData(StudentEntity student, StorageContext context) throws PragmaticBookSelfException {
		Integer result = 0;
		Session hibernateSession = context.getHibernateSession();
		try {
			result = (Integer) hibernateSession.save(student);
			hibernateSession.flush();
		} catch (HibernateException e) {
			throw new PragmaticBookSelfException(e);
		}

		return (int) result;
	}

	/**
	 * Updates specific student data
	 * 
	 * @param student
	 * @param context
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public StudentEntity updateEmployeeData(StudentEntity student, StorageContext context)
			throws PragmaticBookSelfException {

		Session hibernateSession = context.getHibernateSession();

		try {
			hibernateSession.update(student);
		} catch (HibernateException he) {
			throw new PragmaticBookSelfException(he);
		}

		hibernateSession.evict(student);

		return student;
	}

	/**
	 * Retrieves all the student data
	 * 
	 * @param context
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public List<StudentEntity> retrieveAllStudentData(StorageContext context) throws PragmaticBookSelfException {
		List<StudentEntity> listOfStudentData = null;

		Session hibernateSession = context.getHibernateSession();

		String queryString = "FROM StudentEntity"; // select * from student;//
		try {
			Query query = hibernateSession.createQuery(queryString);
			listOfStudentData = query.list();
		} catch (HibernateException he) {
			throw new PragmaticBookSelfException(he);
		}
		return listOfStudentData;
	}

	/**
	 * Delete specific student data based on employee id
	 * 
	 * @param studentId
	 * @param context
	 * @throws PragmaticBookSelfException
	 */
	public StudentEntity deleteStudentData(int studentId, StorageContext context) throws PragmaticBookSelfException {
		StudentEntity result = null;
		Session hibernateSession = context.getHibernateSession();
		result = (StudentEntity) hibernateSession.get(StudentEntity.class, studentId);
		return result;

	}

	/**
	 * Gets student data based on id
	 * 
	 * @param studentId
	 * @param context
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public StudentEntity getStudentDataById(int studentId, StorageContext context)
			throws PragmaticBookSelfException {
		StudentEntity result = null;
		Session hibernateSession = context.getHibernateSession();
		result = (StudentEntity) hibernateSession.get(StudentEntity.class, studentId);

		return result;
	}

	/**
	 * Gets all the student data which matches the name of provided in the
	 * parameter and returns that to the caller
	 * 
	 * @param name
	 * @param context
	 * @return
	 * @throws PragmaticBookSelfException
	 */
	public List<StudentEntity> getStudentDataByName(String name, StorageContext context)
			throws PragmaticBookSelfException {
		List<StudentEntity> result = null;
		try {
			Session hibernateSeesion = context.getHibernateSession();
			String retrieveEmployeebyNameQuery = "FROM StudentEntity e WHERE e.s_name LIKE :s_name or e.id_issue_book LIKE :id_issue_book";
			Query query = hibernateSeesion.createQuery(retrieveEmployeebyNameQuery);
			query.setParameter("s_name", name);
			query.setParameter("id_issue_book", name);
			result = (List<StudentEntity>) query.list();
		} catch (HibernateException he) {
			throw new PragmaticBookSelfException(he);
		}
		return result;
	}

}
