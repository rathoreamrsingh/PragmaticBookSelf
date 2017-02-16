package com.pragmatic.bookself.book;

import java.sql.Date;

public class BookEntity {
	private int id;
	private String b_name;
	private int author_id;
	private int rating;
	private String pub_date;
	public BookEntity(int id, String b_name, int author_id, int rating, String pub_date) {
		super();
		this.id = id;
		this.b_name = b_name;
		this.author_id = author_id;
		this.rating = rating;
		this.pub_date = pub_date;
	}
	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	
}
