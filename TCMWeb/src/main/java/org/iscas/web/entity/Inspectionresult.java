package org.iscas.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Inspectionresult extends IdEntity{

  //private String id;
  private String sickId;
  private java.sql.Date admissionTime;
  private java.sql.Date dischargeTime;
  private String inDept;
  private String residenceNo;
  private long age;
  private String sex;
  private String prescribeTxt;
  private String ldescription;
  private String impression;
  private String diagnosis;



  public String getSickId() {
    return sickId;
  }

  public void setSickId(String sickId) {
    this.sickId = sickId;
  }


  public java.sql.Date getAdmissionTime() {
    return admissionTime;
  }

  public void setAdmissionTime(java.sql.Date admissionTime) {
    this.admissionTime = admissionTime;
  }


  public java.sql.Date getDischargeTime() {
    return dischargeTime;
  }

  public void setDischargeTime(java.sql.Date dischargeTime) {
    this.dischargeTime = dischargeTime;
  }


  public String getInDept() {
    return inDept;
  }

  public void setInDept(String inDept) {
    this.inDept = inDept;
  }


  public String getResidenceNo() {
    return residenceNo;
  }

  public void setResidenceNo(String residenceNo) {
    this.residenceNo = residenceNo;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getPrescribeTxt() {
    return prescribeTxt;
  }

  public void setPrescribeTxt(String prescribeTxt) {
    this.prescribeTxt = prescribeTxt;
  }


  public String getLdescription() {
    return ldescription;
  }

  public void setLdescription(String ldescription) {
    this.ldescription = ldescription;
  }


  public String getImpression() {
    return impression;
  }

  public void setImpression(String impression) {
    this.impression = impression;
  }


  public String getDiagnosis() {
    return diagnosis;
  }

  public void setDiagnosis(String diagnosis) {
    this.diagnosis = diagnosis;
  }

}
