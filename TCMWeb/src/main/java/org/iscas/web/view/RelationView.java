package org.iscas.web.view;

import org.iscas.web.entity.Disease;
import org.iscas.web.entity.Expert;
import org.iscas.web.entity.Material;
import org.iscas.web.entity.Prescription;

public class RelationView {

	public RelationView() {
		// TODO Auto-generated constructor stub
	}

	String relatedEntity;
	String uri;
	
	public RelationView(Disease disease) {
		this.relatedEntity = disease.getName();
		this.uri = "/disease/info.html?diseaseId="+disease.getId();
	}
	
	public RelationView(Material material) {
		this.relatedEntity = material.getNameCn();
		this.uri = "/material/info.html?materialId=" + material.getId();
	}
	
	public RelationView(Prescription prescription) {
		this.relatedEntity = prescription.getName();
		this.uri = "/prescription/info.html?prescriptionId=" + prescription.getId();
	}
	
	public RelationView(org.iscas.graph.nodeentity.Prescription prescription) {
		this.relatedEntity = prescription.getName();
		this.uri = "/prescription/info.html?prescriptionId=" + prescription.getId();
	}
	
	public RelationView(Expert expert) {
		this.relatedEntity = expert.getName();
		this.uri = "/expert/info.html?expertId="+ expert.getId();
	}
	
	public RelationView(String name, String address) {
		this.relatedEntity = name;
		this.uri = address;
	}
	
	public String getRelatedEntity() {
		return relatedEntity;
	}
	public void setRelatedEntity(String relatedEntity) {
		this.relatedEntity = relatedEntity;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}

}
