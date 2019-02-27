package org.iscas.web.view;

import java.util.List;

import org.iscas.web.entity.Dynasty;

public class AlphabetBooks {
	private String alpha;
	List<String> books; 

	public AlphabetBooks() {
		// TODO Auto-generated constructor stub
	}

	public String getAlpha() {
		return alpha;
	}

	public void setAlpha(char alpha) {
		this.alpha = ""+alpha;
	}
	
	public void setAlpha(String alpha) {
		this.alpha = alpha;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}



}
