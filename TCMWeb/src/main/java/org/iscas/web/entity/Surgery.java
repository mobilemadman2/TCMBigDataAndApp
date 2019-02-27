package org.iscas.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Surgery extends IdEntity{

  //private String id;
  private String residenceNo;
  private String sickId;
  private long visitNumber;
  private String sex;
  private String operatItemName;



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


  public String getOperatItemName() {
    return operatItemName;
  }

  public void setOperatItemName(String operatItemName) {
    this.operatItemName = operatItemName;
  }

}
