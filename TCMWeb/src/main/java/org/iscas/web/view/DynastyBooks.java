package org.iscas.web.view;

import java.util.List;

import org.iscas.web.entity.Dynasty;

public class DynastyBooks {
	private Dynasty dynasty;
	List<String> books; 

	public DynastyBooks() {
		// TODO Auto-generated constructor stub
	}

	public Dynasty getDynasty() {
		return dynasty;
	}

	public void setDynasty(Dynasty dynasty) {
		this.dynasty = dynasty;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

}
