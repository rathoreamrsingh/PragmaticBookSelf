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
private int id;
private String s_name;
private String stream;
private String semester;
private int id_issue_book;
private Date book_issue_date;
private Date book_due_date;
public StudentEntity(int id, String s_name, String stream, String semester, int id_issue_book, Date book_issue_date,
		Date book_due_date) {
	super();
	this.id = id;
	this.s_name = s_name;
	this.stream = stream;
	this.semester= semester;
	this.id_issue_book = id_issue_book;
	this.book_issue_date = book_issue_date;
	this.book_due_date = book_due_date;
}
public StudentEntity() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getS_name() {
	return s_name;
}
public void setS_name(String s_name) {
	this.s_name = s_name;
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
public int getId_issue_book() {
	return id_issue_book;
}
public void setId_issue_book(int id_issue_book) {
	this.id_issue_book = id_issue_book;
}
public Date getBook_issue_date() {
	return book_issue_date;
}
public void setBook_issue_date(Date book_issue_date) {
	this.book_issue_date = book_issue_date;
}
public Date getBook_due_date() {
	return book_due_date;
}
public void setBook_due_date(Date book_due_date) {
	this.book_due_date = book_due_date;
}




}
