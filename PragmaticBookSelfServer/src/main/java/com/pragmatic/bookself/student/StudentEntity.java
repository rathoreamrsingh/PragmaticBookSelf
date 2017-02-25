/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.student;

import java.sql.Date;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class StudentEntity {
	/**
	 * Please read naming convention from java. Do not use _ in names use camel
	 * case. You can keep _ in db object name, but do not repeat as it is here.
	 */
	private int id;
	private String sName;
	private String stream;
	private String semester;
	private int idBookIssue;
	private Date bookIssueDate;
	private Date bookDueDate;

	public StudentEntity(int id, String sName, String stream, String semester, int idBookIssue, Date bookIssueDate,
			Date bookDueDate) {
		super();
		this.id = id;
		this.sName = sName;
		this.stream = stream;
		this.semester = semester;
		this.idBookIssue = idBookIssue;
		this.bookIssueDate = bookIssueDate;
		this.bookDueDate = bookDueDate;
	}

	public StudentEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getIdBookIssue() {
		return idBookIssue;
	}

	public void setIdBookIssue(int idBookIssue) {
		this.idBookIssue = idBookIssue;
	}

	public Date getBookIssueDate() {
		return bookIssueDate;
	}

	public void setBookIssueDate(Date bookIssueDate) {
		this.bookIssueDate = bookIssueDate;
	}

	public Date getBookDueDate() {
		return bookDueDate;
	}

	public void setBookDueDate(Date bookDueDate) {
		this.bookDueDate = bookDueDate;
	}

}
