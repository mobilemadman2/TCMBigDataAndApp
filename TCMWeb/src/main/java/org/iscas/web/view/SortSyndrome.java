package org.iscas.web.view;

import java.util.List;

import org.iscas.web.entity.Syndrome;

public class SortSyndrome {
	private String name;
	List<String> syndrome; 

	public SortSyndrome() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSyndrome() {
		return syndrome;
	}

	public void setSyndrome(List<String> syndrome) {
		this.syndrome = syndrome;
	}
}
