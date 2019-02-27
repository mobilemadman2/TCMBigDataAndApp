package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="compound_register") 
public class CompoundRegister extends IdEntity {



	private String accessNobak;
	  //@Id //@id注意选择这个javax.persistence
	  //@GeneratedValue
	  /*@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)*/
	  private long accessNo;
	  private String elRegistryNumber;
	  private String regCn1;
	  private String regCn2;
	  private String casRegistryNumber1;
	  private String casRegistryNumber2;
	  private String cnn;
	  @Column(columnDefinition = "TEXT")
	  private String chineseSystemicName;
	  @Column(columnDefinition = "TEXT")
	  private String chineseSynonyms;
	  @Column(columnDefinition = "TEXT")
	  private String englishName;
	  @Column(columnDefinition = "TEXT")
	  private String systemicName;
	  @Column(columnDefinition = "TEXT")
	  private String englishSynonyms;
	  private String chinesePinyin;
	  private String tc;
	  private String classification;
	  private String molecularFormula;
	  private String patentOrigin;
	  private String materialOrigin;
	  private String picMol;
	  private String picTif;
	  private String picGif;
	  private String picJpg;
	  private String picBmp;
	  @Column(columnDefinition = "TEXT")
	  private String note;
	  @Column(columnDefinition = "TEXT")
	  private String state;


	  public String getAccessNobak() {
	    return accessNobak;
	  }

	  public void setAccessNobak(String accessNobak) {
	    this.accessNobak = accessNobak;
	  }


	  public long getAccessNo() {
	    return accessNo;
	  }

	  public void setAccessNo(long accessNo) {
	    this.accessNo = accessNo;
	  }


	  public String getElRegistryNumber() {
	    return elRegistryNumber;
	  }

	  public void setElRegistryNumber(String elRegistryNumber) {
	    this.elRegistryNumber = elRegistryNumber;
	  }


	  public String getRegCn1() {
	    return regCn1;
	  }

	  public void setRegCn1(String regCn1) {
	    this.regCn1 = regCn1;
	  }


	  public String getRegCn2() {
	    return regCn2;
	  }

	  public void setRegCn2(String regCn2) {
	    this.regCn2 = regCn2;
	  }


	  public String getCasRegistryNumber1() {
	    return casRegistryNumber1;
	  }

	  public void setCasRegistryNumber1(String casRegistryNumber1) {
	    this.casRegistryNumber1 = casRegistryNumber1;
	  }


	  public String getCasRegistryNumber2() {
	    return casRegistryNumber2;
	  }

	  public void setCasRegistryNumber2(String casRegistryNumber2) {
	    this.casRegistryNumber2 = casRegistryNumber2;
	  }


	  public String getCnn() {
	    return cnn;
	  }

	  public void setCnn(String cnn) {
	    this.cnn = cnn;
	  }


	  public String getChineseSystemicName() {
	    return chineseSystemicName;
	  }

	  public void setChineseSystemicName(String chineseSystemicName) {
	    this.chineseSystemicName = chineseSystemicName;
	  }


	  public String getChineseSynonyms() {
	    return chineseSynonyms;
	  }

	  public void setChineseSynonyms(String chineseSynonyms) {
	    this.chineseSynonyms = chineseSynonyms;
	  }


	  public String getEnglishName() {
	    return englishName;
	  }

	  public void setEnglishName(String englishName) {
	    this.englishName = englishName;
	  }


	  public String getSystemicName() {
	    return systemicName;
	  }

	  public void setSystemicName(String systemicName) {
	    this.systemicName = systemicName;
	  }


	  public String getEnglishSynonyms() {
	    return englishSynonyms;
	  }

	  public void setEnglishSynonyms(String englishSynonyms) {
	    this.englishSynonyms = englishSynonyms;
	  }


	  public String getChinesePinyin() {
	    return chinesePinyin;
	  }

	  public void setChinesePinyin(String chinesePinyin) {
	    this.chinesePinyin = chinesePinyin;
	  }


	  public String getTc() {
	    return tc;
	  }

	  public void setTc(String tc) {
	    this.tc = tc;
	  }


	  public String getClassification() {
	    return classification;
	  }

	  public void setClassification(String classification) {
	    this.classification = classification;
	  }


	  public String getMolecularFormula() {
	    return molecularFormula;
	  }

	  public void setMolecularFormula(String molecularFormula) {
	    this.molecularFormula = molecularFormula;
	  }


	  public String getPatentOrigin() {
	    return patentOrigin;
	  }

	  public void setPatentOrigin(String patentOrigin) {
	    this.patentOrigin = patentOrigin;
	  }


	  public String getMaterialOrigin() {
	    return materialOrigin;
	  }

	  public void setMaterialOrigin(String materialOrigin) {
	    this.materialOrigin = materialOrigin;
	  }


	  public String getPicMol() {
	    return picMol;
	  }

	  public void setPicMol(String picMol) {
	    this.picMol = picMol;
	  }


	  public String getPicTif() {
	    return picTif;
	  }

	  public void setPicTif(String picTif) {
	    this.picTif = picTif;
	  }


	  public String getPicGif() {
	    return picGif;
	  }

	  public void setPicGif(String picGif) {
	    this.picGif = picGif;
	  }


	  public String getPicJpg() {
	    return picJpg;
	  }

	  public void setPicJpg(String picJpg) {
	    this.picJpg = picJpg;
	  }


	  public String getPicBmp() {
	    return picBmp;
	  }

	  public void setPicBmp(String picBmp) {
	    this.picBmp = picBmp;
	  }


	  public String getNote() {
	    return note;
	  }

	  public void setNote(String note) {
	    this.note = note;
	  }


	  public String getState() {
	    return state;
	  }

	  public void setState(String state) {
	    this.state = state;
	  }

}
