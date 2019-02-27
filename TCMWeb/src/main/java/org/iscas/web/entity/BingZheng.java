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

import org.hibernate.annotations.Cascade;

/**
 * Created by suemi on 17-7-1.
 */
@Entity
@Table
public class BingZheng extends IdEntity {

  @NotNull
  private String name;

  @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
  @JoinColumn(name="disease.id")
  private Disease disease;
  
  //症候
  @Column(columnDefinition = "TEXT")
  private String zhenghou;

  //治法
  @Column(columnDefinition = "TEXT")
  private String zhifa;
  
  //主方
  @Column(columnDefinition = "TEXT")
  private String zhufang;
  
  //加减
  @Column(columnDefinition = "TEXT")
  private String jiajian;

public Disease getDisease() {
	return disease;
}

public void setDisease(Disease disease) {
	this.disease = disease;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getZhenghou() {
	return zhenghou;
}

public void setZhenghou(String zhenghou) {
	this.zhenghou = zhenghou;
}

public String getZhifa() {
	return zhifa;
}

public void setZhifa(String zhifa) {
	this.zhifa = zhifa;
}

public String getZhufang() {
	return zhufang;
}

public void setZhufang(String zhufang) {
	this.zhufang = zhufang;
}

public String getJiajian() {
	return jiajian;
}

public void setJiajian(String jiajian) {
	this.jiajian = jiajian;
}
  
}
