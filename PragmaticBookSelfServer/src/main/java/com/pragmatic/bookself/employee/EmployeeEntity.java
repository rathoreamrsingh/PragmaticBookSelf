package com.pragmatic.bookself.employee;

/**
 * 
 * @author amar
 *
 */
public class EmployeeEntity {
	private int id;
	private String fname;
	private String lname;
	private String address;
	private String phoneNo;

	public EmployeeEntity(int id, String fname, String lname, String address, String phoneNo) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public EmployeeEntity() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
