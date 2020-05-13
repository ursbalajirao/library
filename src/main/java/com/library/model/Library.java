package com.library.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY")
public class Library {

	@Id
	private int id;
	private String library_name;
	private String location;
	private int no_of_books;
	private LocalDate created_date;

	public int getNo_of_books() {
		return no_of_books;
	}

	public void setNo_of_books(int no_of_books) {
		this.no_of_books = no_of_books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibrary_name() {
		return library_name;
	}

	public void setLibrary_name(String library_name) {
		this.library_name = library_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

}
