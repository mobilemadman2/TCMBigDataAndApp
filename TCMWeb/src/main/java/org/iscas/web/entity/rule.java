package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Created by suemi on 17-7-1.
 */
@Entity
@Table(name = "setting_rule")
public class rule extends IdEntity {


//规则
@Column(columnDefinition = "TEXT")
private String rules;

public String getRules() {
	return rules;
}

public void setRules(String rules) {
	this.rules = rules;
}

  
}
