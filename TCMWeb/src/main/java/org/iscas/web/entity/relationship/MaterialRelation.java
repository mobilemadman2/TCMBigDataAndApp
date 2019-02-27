package org.iscas.web.entity.relationship;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.iscas.web.entity.IdEntity;

@MappedSuperclass
public class MaterialRelation extends RelationShip {
	public MaterialRelation() {
		super();
	}
	long baseId;
	
	public long getBaseId() {
		return baseId;
	}
	public void setBaseId(long baseId) {
		this.baseId = baseId;
	}
	


}
