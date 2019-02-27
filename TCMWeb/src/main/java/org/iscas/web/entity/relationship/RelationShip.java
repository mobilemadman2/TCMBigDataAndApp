package org.iscas.web.entity.relationship;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import org.iscas.web.entity.IdEntity;

@MappedSuperclass
public class RelationShip extends IdEntity {
	public RelationShip() {
		// TODO Auto-generated constructor stub
		super();
	}
  @NotNull
  private String baseEntity;
  
  @NotNull
  private String relatedEntity;

public String getBaseEntity() {
	return baseEntity;
}

public void setBaseEntity(String baseEntity) {
	this.baseEntity = baseEntity;
}

public String getRelatedEntity() {
	return relatedEntity;
}

public void setRelatedEntity(String relatedEntity) {
	this.relatedEntity = relatedEntity;
}

}
