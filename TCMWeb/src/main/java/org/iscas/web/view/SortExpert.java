package org.iscas.web.view;

import java.util.List;

import org.iscas.web.entity.Dynasty;

public class SortExpert {
	private String name;
	List<String> experts; 
	List<String> expertsId; 

	

	


	public List<String> getExperts() {
		return experts;
	}


	public void setExperts(List<String> experts) {
		this.experts = experts;
	}


	public List<String> getExpertsId() {
		return expertsId;
	}


	public void setExpertsId(List<String> expertsId) {
		this.expertsId = expertsId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



}
