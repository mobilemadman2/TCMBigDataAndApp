package org.iscas.web.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Created by yinrun on 17-7-1.
 */
@Entity
@Table
public class DiseaseClassify extends IdEntity {


	private String name;
	private String code;	
	private int parent;
	
	private DiseaseType.ClassifyType type;
	



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getParent() {
		return parent;
	}



	public void setParent(int parent) {
		this.parent = parent;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public DiseaseType.ClassifyType getType() {
		return type;
	}



	public void setType(DiseaseType.ClassifyType type) {
		this.type = type;
	}
	
	


}
