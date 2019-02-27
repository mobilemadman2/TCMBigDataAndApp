package org.iscas.web.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Book extends IdEntity {
  @NotNull
  private String name;
  
  private String namePinyin;
  
  //作者
  @Column(columnDefinition = "TEXT")
  private String author;
  
  @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
  @JoinColumn(name="dynasty.id")
  private Dynasty dynasty;

  //来源
  @Column(columnDefinition = "TEXT")
  private String source;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public Dynasty getDynasty() {
	return dynasty;
}

public void setDynasty(Dynasty dynasty) {
	this.dynasty = dynasty;
}

public String getSource() {
	return source;
}

public void setSource(String source) {
	this.source = source;
}

public String getNamePinyin() {
	return namePinyin;
}

public void setNamePinyin(String namePinyin) {
	this.namePinyin = namePinyin;
}
}
