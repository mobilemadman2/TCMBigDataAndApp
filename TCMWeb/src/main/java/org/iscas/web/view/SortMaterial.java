package org.iscas.web.view;

import java.util.List;

import org.iscas.web.entity.Dynasty;

public class SortMaterial {
	private String name;
	List<String> materials; 
	List<String> materialsId; 

	public List<String> getMaterialsId() {
		return materialsId;
	}


	public void setMaterialsId(List<String> materialsId) {
		this.materialsId = materialsId;
	}


	public SortMaterial() {
		// TODO Auto-generated constructor stub
	}


	public List<String> getMaterials() {
		return materials;
	}

	public void setMaterials(List<String> materials) {
		this.materials = materials;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



}
