package org.iscas.web.view;

import java.util.List;

import org.iscas.web.entity.Dynasty;

public class SortPrescription {
	private String name;
	List<String> prescriptions; 
	List<String> prescriptionsId; 

	

	public List<String> getPrescriptions() {
		return prescriptions;
	}


	public void setPrescriptions(List<String> prescriptions) {
		this.prescriptions = prescriptions;
	}


	public List<String> getPrescriptionsId() {
		return prescriptionsId;
	}


	public void setPrescriptionsId(List<String> prescriptionsId) {
		this.prescriptionsId = prescriptionsId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



}
