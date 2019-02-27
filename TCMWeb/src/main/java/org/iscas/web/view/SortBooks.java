package org.iscas.web.view;

import java.util.List;

import org.iscas.web.entity.Dynasty;

public class SortBooks {
	private String name;
	List<String> books; 

	public SortBooks() {
		// TODO Auto-generated constructor stub
	}


	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



}
