package org.iscas.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Inspection extends IdEntity{

  //private String id;
  private String sickId;
  private java.sql.Date admissionTime;
  private java.sql.Date dischargeTime;
  private String inDept;
  private String residenceNo;
  private long age;
  private String sex;
  private String prescribeTxt;
  private String reportdate;
  private String itemname;
  private String result;
  private String ref;




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


  public String getReportdate() {
    return reportdate;
  }

  public void setReportdate(String reportdate) {
    this.reportdate = reportdate;
  }


  public String getItemname() {
    return itemname;
  }

  public void setItemname(String itemname) {
    this.itemname = itemname;
  }


  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }


  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

}
