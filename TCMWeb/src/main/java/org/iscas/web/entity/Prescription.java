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
public class Prescription extends IdEntity {

  @NotNull
  private String name;

  private String alias;
  
  private String namePinyin;

  public String getNamePinyin() {
	return namePinyin;
}

public void setNamePinyin(String namePinyin) {
	this.namePinyin = namePinyin;
}

//处方
  @Column(columnDefinition = "TEXT")
  private String composition;

  //炮制
  @Column(columnDefinition = "TEXT")
  private String processed;
  
  @Column(columnDefinition = "TEXT")
  //制法
  private String process;
  
  //药理作用
  @Column(columnDefinition = "TEXT")
  private String pharmacologicaleffects;
  
  //功能主治
  @Column(columnDefinition = "TEXT")
  private String function;
  
  //用法用量
  @Column(columnDefinition = "TEXT")
  private String dosage;

  //备注
  @Column(columnDefinition = "TEXT")
  private String remarks;
  
  //各家论述
  @Column(columnDefinition = "TEXT")
  private String variousDescription;
  
  //临床应用
  @Column(columnDefinition = "TEXT")
  private String application;
  
  //注意
  @Column(columnDefinition = "TEXT")
  private String attention;
  
  //摘录
  @Column(columnDefinition = "TEXT")
  private String source;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAlias() {
	return alias;
}

public void setAlias(String alias) {
	this.alias = alias;
}

public String getComposition() {
	return composition;
}

public void setComposition(String composition) {
	this.composition = composition;
}

public String getProcessed() {
	return processed;
}

public void setProcessed(String processed) {
	this.processed = processed;
}

public String getProcess() {
	return process;
}

public void setProcess(String process) {
	this.process = process;
}

public String getPharmacologicaleffects() {
	return pharmacologicaleffects;
}

public void setPharmacologicaleffects(String pharmacologicaleffects) {
	this.pharmacologicaleffects = pharmacologicaleffects;
}

public String getFunction() {
	return function;
}

public void setFunction(String function) {
	this.function = function;
}

public String getDosage() {
	return dosage;
}

public void setDosage(String dosage) {
	this.dosage = dosage;
}

public String getRemarks() {
	return remarks;
}

public void setRemarks(String remarks) {
	this.remarks = remarks;
}

public String getVariousDescription() {
	return variousDescription;
}

public void setVariousDescription(String variousDescription) {
	this.variousDescription = variousDescription;
}

public String getApplication() {
	return application;
}

public void setApplication(String application) {
	this.application = application;
}

public String getAttention() {
	return attention;
}

public void setAttention(String attention) {
	this.attention = attention;
}

public String getSource() {
	return source;
}

public void setSource(String source) {
	this.source = source;
}
  
}
