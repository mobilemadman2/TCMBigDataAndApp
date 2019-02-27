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
public class DiseaseType extends IdEntity {

	public enum ClassifyType {
		TYPE_TCM,
		TYPE_GB;
	}

	@NotNull
	private String name;

	private String firstLevel;

	private String secondLevel;

	private ClassifyType type;
	
	private int parent;
	
	// @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	// @JoinColumn(name="disease.id")
	// private Disease disease;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstLevel() {
		return firstLevel;
	}

	public void setFirstLevel(String firstLevel) {
		this.firstLevel = firstLevel;
	}

	public String getSecondLevel() {
		return secondLevel;
	}

	public void setSecondLevel(String secondLevel) {
		this.secondLevel = secondLevel;
	}

	public ClassifyType getType() {
		return type;
	}

	public void setType(ClassifyType type) {
		this.type = type;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

}
