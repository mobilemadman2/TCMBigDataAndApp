package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Created by wch on 2018.
 */
@Entity
@Table
public class Expert extends IdEntity {

/*	  @NotNull
	  private long id;*/
	  private String name;
	  private String courtesyname;
	  private String pseudonym;
	  private String alias;
	  private String sex;
	  private String dynasty;
	  private String ethnic;
	  private String birthday;
	  private String endtime;
	  private String party;
	  private String work;
	  private String position;
	  private String department;
	  private String status;
	  private String book;
	  private String paper;
	  private String patent;
	  private String medicalcase;
	  private String prescription;
	  private String honor;
	  private String flag;
	  private String photo;
	  private String note;
	  private String namePinyin;

/*
	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }*/

	  public String getNamePinyin() {
		return namePinyin;
	}

	public void setNamePinyin(String namePinyin) {
		this.namePinyin = namePinyin;
	}

	public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }


	  public String getCourtesyname() {
	    return courtesyname;
	  }

	  public void setCourtesyname(String courtesyname) {
	    this.courtesyname = courtesyname;
	  }


	  public String getPseudonym() {
	    return pseudonym;
	  }

	  public void setPseudonym(String pseudonym) {
	    this.pseudonym = pseudonym;
	  }


	  public String getAlias() {
	    return alias;
	  }

	  public void setAlias(String alias) {
	    this.alias = alias;
	  }


	  public String getSex() {
	    return sex;
	  }

	  public void setSex(String sex) {
	    this.sex = sex;
	  }


	  public String getDynasty() {
	    return dynasty;
	  }

	  public void setDynasty(String dynasty) {
	    this.dynasty = dynasty;
	  }


	  public String getEthnic() {
	    return ethnic;
	  }

	  public void setEthnic(String ethnic) {
	    this.ethnic = ethnic;
	  }


	  public String getBirthday() {
	    return birthday;
	  }

	  public void setBirthday(String birthday) {
	    this.birthday = birthday;
	  }


	  public String getEndtime() {
	    return endtime;
	  }

	  public void setEndtime(String endtime) {
	    this.endtime = endtime;
	  }


	  public String getParty() {
	    return party;
	  }

	  public void setParty(String party) {
	    this.party = party;
	  }


	  public String getWork() {
	    return work;
	  }

	  public void setWork(String work) {
	    this.work = work;
	  }


	  public String getPosition() {
	    return position;
	  }

	  public void setPosition(String position) {
	    this.position = position;
	  }


	  public String getDepartment() {
	    return department;
	  }

	  public void setDepartment(String department) {
	    this.department = department;
	  }


	  public String getStatus() {
	    return status;
	  }

	  public void setStatus(String status) {
	    this.status = status;
	  }


	  public String getBook() {
	    return book;
	  }

	  public void setBook(String book) {
	    this.book = book;
	  }


	  public String getPaper() {
	    return paper;
	  }

	  public void setPaper(String paper) {
	    this.paper = paper;
	  }


	  public String getPatent() {
	    return patent;
	  }

	  public void setPatent(String patent) {
	    this.patent = patent;
	  }


	  public String getMedicalcase() {
	    return medicalcase;
	  }

	  public void setMedicalcase(String medicalcase) {
	    this.medicalcase = medicalcase;
	  }


	  public String getPrescription() {
	    return prescription;
	  }

	  public void setPrescription(String prescription) {
	    this.prescription = prescription;
	  }


	  public String getHonor() {
	    return honor;
	  }

	  public void setHonor(String honor) {
	    this.honor = honor;
	  }


	  public String getFlag() {
	    return flag;
	  }

	  public void setFlag(String flag) {
	    this.flag = flag;
	  }


	  public String getPhoto() {
	    return photo;
	  }

	  public void setPhoto(String photo) {
	    this.photo = photo;
	  }


	  public String getNote() {
	    return note;
	  }

	  public void setNote(String note) {
	    this.note = note;
	  }

	}

