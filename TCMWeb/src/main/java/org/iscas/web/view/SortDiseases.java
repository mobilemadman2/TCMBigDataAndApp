package org.iscas.web.view;

import java.util.List;

import org.iscas.web.entity.Dynasty;

public class SortDiseases {
	private String name;
	List<String> diseases; 
	List<String> diseasesId; 

	public List<String> getDiseases() {
		return diseases;
	}


	public void setDiseases(List<String> diseases) {
		this.diseases = diseases;
	}


	public List<String> getDiseasesId() {
		return diseasesId;
	}


	public void setDiseasesId(List<String> diseasesId) {
		this.diseasesId = diseasesId;
	}


	

	public SortDiseases() {
		// TODO Auto-generated constructor stub
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



}
