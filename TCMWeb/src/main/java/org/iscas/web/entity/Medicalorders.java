package org.iscas.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Medicalorders extends IdEntity{

  private String residenceNo;
  private String sickId;
  private String visitNumber;
  private String sex;
  private java.sql.Date admissionTime;
  private java.sql.Date dischargeTime;
  private String inDept;
  private long age;
  private String prescribeTxt;
  private String physicSpec;
  private java.sql.Date startTime;
  private java.sql.Date stopTime;
  private String physicDoseage;
  private String doseUnit;
  private String freqDescribe;
  private long freqDuration;
  private long days;
  private String nowDiagnosis;




  public String getResidenceNo() {
    return residenceNo;
  }

  public void setResidenceNo(String residenceNo) {
    this.residenceNo = residenceNo;
  }


  public String getSickId() {
    return sickId;
  }

  public void setSickId(String sickId) {
    this.sickId = sickId;
  }


  public String getVisitNumber() {
    return visitNumber;
  }

  public void setVisitNumber(String visitNumber) {
    this.visitNumber = visitNumber;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
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

  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getPrescribeTxt() {
    return prescribeTxt;
  }

  public void setPrescribeTxt(String prescribeTxt) {
    this.prescribeTxt = prescribeTxt;
  }


  public String getPhysicSpec() {
    return physicSpec;
  }

  public void setPhysicSpec(String physicSpec) {
    this.physicSpec = physicSpec;
  }


  public java.sql.Date getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Date startTime) {
    this.startTime = startTime;
  }


  public java.sql.Date getStopTime() {
    return stopTime;
  }

  public void setStopTime(java.sql.Date stopTime) {
    this.stopTime = stopTime;
  }


  public String getPhysicDoseage() {
    return physicDoseage;
  }

  public void setPhysicDoseage(String physicDoseage) {
    this.physicDoseage = physicDoseage;
  }


  public String getDoseUnit() {
    return doseUnit;
  }

  public void setDoseUnit(String doseUnit) {
    this.doseUnit = doseUnit;
  }


  public String getFreqDescribe() {
    return freqDescribe;
  }

  public void setFreqDescribe(String freqDescribe) {
    this.freqDescribe = freqDescribe;
  }


  public long getFreqDuration() {
    return freqDuration;
  }

  public void setFreqDuration(long freqDuration) {
    this.freqDuration = freqDuration;
  }


  public long getDays() {
    return days;
  }

  public void setDays(long days) {
    this.days = days;
  }


  public String getNowDiagnosis() {
    return nowDiagnosis;
  }

  public void setNowDiagnosis(String nowDiagnosis) {
    this.nowDiagnosis = nowDiagnosis;
  }

}
