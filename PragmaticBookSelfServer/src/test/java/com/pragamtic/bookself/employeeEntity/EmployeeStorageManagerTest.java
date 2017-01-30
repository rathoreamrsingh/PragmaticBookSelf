/**
 * 
 * @author amar
 *
 */
package com.pragamtic.bookself.employeeEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pragamtic.bookself.exception.PragmaticBookSelfException;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.employee.EmployeeStorageManager;

/**
 * @author amar
 *
 */
public class EmployeeStorageManagerTest {
	private static SessionFactory factory = null;

	@BeforeClass
	public static void setUpTestEnv() {
		try {
			Configuration configuration = new Configuration();
			factory = configuration.configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@AfterClass
	public static void closeTestEnv() {
		if (factory != null) {
			factory.close();
		}
	}

	@Test
	public void insertEmployeeData() {
		int expectedResult = 2;
		List<EmployeeEntity> listOfEmployee = new ArrayList<EmployeeEntity>();
		/*
		 * Details of employee one.
		 */
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setFname("Amar");
		employeeEntity.setLname("Singh");
		employeeEntity.setAddress("Room no 202, Anjali Gardens Apartment, Manikonda Hyderabad - 500089");
		employeeEntity.setPhoneNo("+917207244657");
		listOfEmployee.add(employeeEntity);

		/*
		 * Details of employee two.
		 */
		employeeEntity = new EmployeeEntity();
		employeeEntity.setFname("Amar2");
		employeeEntity.setLname("Singh2");
		employeeEntity.setAddress("Room no 202, Anjali Gardens Apartment, Manikonda Hyderabad - 500089");
		employeeEntity.setPhoneNo("+917207244657");
		listOfEmployee.add(employeeEntity);

		int actualResult;
		try {
			actualResult = EmployeeStorageManager.getInstance().insertEmployeeData(listOfEmployee,
					factory.openSession());
			assertEquals(0, 0);
		} catch (PragmaticBookSelfException e) {
			fail("Caught exception" + e);
		}
	}
}
