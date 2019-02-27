package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table
public class EntityBookRelation extends IdEntity{
	public static enum EntityBookRelationType {
        DISEASE,
        PRESCRIPTION,
        MATERIAL;
	}
	
	public EntityBookRelation() {
		// TODO Auto-generated constructor stub
	}
	
	
	private Long bookid;
	private String entityName;
	private String startPosition;
	private String path;
	
	private EntityBookRelationType relationType;

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(String startPosition) {
		this.startPosition = startPosition;
	}

	public EntityBookRelationType getRelationType() {
		return relationType;
	}

	public void setRelationType(EntityBookRelationType relationType) {
		this.relationType = relationType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


}
