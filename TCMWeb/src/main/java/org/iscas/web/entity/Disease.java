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
@Table
public class Disease extends IdEntity {

  @NotNull
  private String name;

  @NotNull
  private String nameChn;

  private String alias;
  
  private String namePinyin;

  public String getNamePinyin() {
	return namePinyin;
}

public void setNamePinyin(String namePinyin) {
	this.namePinyin = namePinyin;
}

//概述
  @Column(columnDefinition = "TEXT")
  private String overview;

  //病因病机 Etiology and Pathogenesis
  @Column(columnDefinition = "TEXT")
  private String EtPa;
  
  @Column(columnDefinition = "TEXT")
  //临床表现 clinical manifestation
  private String clma;
  
  //实验室及辅助检查
  @Column(columnDefinition = "TEXT")
  private String examination;
  
  //essentials of diagnosis 诊断要点
  @Column(columnDefinition = "TEXT")
  private String esdi;
  
  //Differential Diagnosis 鉴别诊断
  @Column(columnDefinition = "TEXT")
  private String didi;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getNameChn() {
	return nameChn;
}

public void setNameChn(String nameChn) {
	this.nameChn = nameChn;
}

public String getAlias() {
	return alias;
}

public void setAlias(String alias) {
	this.alias = alias;
}

public String getOverview() {
	return overview;
}

public void setOverview(String overview) {
	this.overview = overview;
}

public String getEtPa() {
	return EtPa;
}

public void setEtPa(String etPa) {
	EtPa = etPa;
}

public String getClma() {
	return clma;
}

public void setClma(String clma) {
	this.clma = clma;
}

public String getExamination() {
	return examination;
}

public void setExamination(String examination) {
	this.examination = examination;
}

public String getEsdi() {
	return esdi;
}

public void setEsdi(String esdi) {
	this.esdi = esdi;
}

public String getDidi() {
	return didi;
}

public void setDidi(String didi) {
	this.didi = didi;
}
  
}
