package org.iscas.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Mainrecord extends IdEntity{

  //private String id;
  private String residenceNo;
  private long visitNumber;
  private String sickId;
  private String sickName;
  private long age;
  private String sex;
  private String status;
  private String confirm;
  private String exitReason;
  private String toDate_A_AdmissionTime_;
  private String admiYear;
  private String toDate_A_DischargeTime_;
  private long inday;
  private long indays;
  private String diseaseStatus;
  private String nowDiagnosis;
  private double sumCost;




  public String getResidenceNo() {
    return residenceNo;
  }

  public void setResidenceNo(String residenceNo) {
    this.residenceNo = residenceNo;
  }


  public long getVisitNumber() {
    return visitNumber;
  }

  public void setVisitNumber(long visitNumber) {
    this.visitNumber = visitNumber;
  }


  public String getSickId() {
    return sickId;
  }

  public void setSickId(String sickId) {
    this.sickId = sickId;
  }


  public String getSickName() {
    return sickName;
  }

  public void setSickName(String sickName) {
    this.sickName = sickName;
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


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getConfirm() {
    return confirm;
  }

  public void setConfirm(String confirm) {
    this.confirm = confirm;
  }


  public String getExitReason() {
    return exitReason;
  }

  public void setExitReason(String exitReason) {
    this.exitReason = exitReason;
  }


  public String getToDate_A_AdmissionTime_() {
    return toDate_A_AdmissionTime_;
  }

  public void setToDate_A_AdmissionTime_(String toDate_A_AdmissionTime_) {
    this.toDate_A_AdmissionTime_ = toDate_A_AdmissionTime_;
  }


  public String getAdmiYear() {
    return admiYear;
  }

  public void setAdmiYear(String admiYear) {
    this.admiYear = admiYear;
  }


  public String getToDate_A_DischargeTime_() {
    return toDate_A_DischargeTime_;
  }

  public void setToDate_A_DischargeTime_(String toDate_A_DischargeTime_) {
    this.toDate_A_DischargeTime_ = toDate_A_DischargeTime_;
  }


  public long getInday() {
    return inday;
  }

  public void setInday(long inday) {
    this.inday = inday;
  }


  public long getIndays() {
    return indays;
  }

  public void setIndays(long indays) {
    this.indays = indays;
  }


  public String getDiseaseStatus() {
    return diseaseStatus;
  }

  public void setDiseaseStatus(String diseaseStatus) {
    this.diseaseStatus = diseaseStatus;
  }


  public String getNowDiagnosis() {
    return nowDiagnosis;
  }

  public void setNowDiagnosis(String nowDiagnosis) {
    this.nowDiagnosis = nowDiagnosis;
  }


  public double getSumCost() {
    return sumCost;
  }

  public void setSumCost(double sumCost) {
    this.sumCost = sumCost;
  }

}
