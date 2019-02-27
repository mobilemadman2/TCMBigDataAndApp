package org.iscas.web.entity.relationship.intermediatestate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.iscas.web.entity.IdEntity;
import org.iscas.web.entity.relationship.BookRelation;

@Entity
@Table
public class AutoBookMaterialRelation extends BookRelation {

}
