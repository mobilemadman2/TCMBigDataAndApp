package org.iscas.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Diagnosis extends IdEntity{

  //private String id;
  private String residenceNo;
  private String sickId;
  private long visitNumber;
  private String sex;
  private String diagnosisSequence;
  private String diagnosisClass;
  private String diagnosisName;




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


  public long getVisitNumber() {
    return visitNumber;
  }

  public void setVisitNumber(long visitNumber) {
    this.visitNumber = visitNumber;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getDiagnosisSequence() {
    return diagnosisSequence;
  }

  public void setDiagnosisSequence(String diagnosisSequence) {
    this.diagnosisSequence = diagnosisSequence;
  }


  public String getDiagnosisClass() {
    return diagnosisClass;
  }

  public void setDiagnosisClass(String diagnosisClass) {
    this.diagnosisClass = diagnosisClass;
  }


  public String getDiagnosisName() {
    return diagnosisName;
  }

  public void setDiagnosisName(String diagnosisName) {
    this.diagnosisName = diagnosisName;
  }

}
