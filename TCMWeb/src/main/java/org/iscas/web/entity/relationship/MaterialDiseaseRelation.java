package org.iscas.web.entity.relationship;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table
public class MaterialDiseaseRelation extends MaterialRelation {
	public MaterialDiseaseRelation() {
		super();
	}

}
