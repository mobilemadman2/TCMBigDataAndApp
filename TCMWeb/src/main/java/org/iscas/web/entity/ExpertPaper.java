package org.iscas.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="expert_paper_back")
public class ExpertPaper extends IdEntity {


  private String doctorInstitution;
  private String doctorName;
  private String doctorUrl;
  private String paperName;
  private String paperNameEn;
  private String paperUrl;
  private String periodicalTime;
  private String periodicalEmployList;
  private String periodicalName;
  private String classNumList;
  private String keyWordsChineseList;
  private String periodicalPages;
  private String periodicalUrl;
  private String keyWordsEnglishList;
  private String paperAbstract;
  private String authorInfoList;
  private String columnName;
  private String doi;







  public String getDoctorInstitution() {
    return doctorInstitution;
  }

  public void setDoctorInstitution(String doctorInstitution) {
    this.doctorInstitution = doctorInstitution;
  }


  public String getDoctorName() {
    return doctorName;
  }

  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
  }


  public String getDoctorUrl() {
    return doctorUrl;
  }

  public void setDoctorUrl(String doctorUrl) {
    this.doctorUrl = doctorUrl;
  }


  public String getPaperName() {
    return paperName;
  }

  public void setPaperName(String paperName) {
    this.paperName = paperName;
  }


  public String getPaperNameEn() {
    return paperNameEn;
  }

  public void setPaperNameEn(String paperNameEn) {
    this.paperNameEn = paperNameEn;
  }


  public String getPaperUrl() {
    return paperUrl;
  }

  public void setPaperUrl(String paperUrl) {
    this.paperUrl = paperUrl;
  }


  public String getPeriodicalTime() {
    return periodicalTime;
  }

  public void setPeriodicalTime(String periodicalTime) {
    this.periodicalTime = periodicalTime;
  }


  public String getPeriodicalEmployList() {
    return periodicalEmployList;
  }

  public void setPeriodicalEmployList(String periodicalEmployList) {
    this.periodicalEmployList = periodicalEmployList;
  }


  public String getPeriodicalName() {
    return periodicalName;
  }

  public void setPeriodicalName(String periodicalName) {
    this.periodicalName = periodicalName;
  }


  public String getClassNumList() {
    return classNumList;
  }

  public void setClassNumList(String classNumList) {
    this.classNumList = classNumList;
  }


  public String getKeyWordsChineseList() {
    return keyWordsChineseList;
  }

  public void setKeyWordsChineseList(String keyWordsChineseList) {
    this.keyWordsChineseList = keyWordsChineseList;
  }


  public String getPeriodicalPages() {
    return periodicalPages;
  }

  public void setPeriodicalPages(String periodicalPages) {
    this.periodicalPages = periodicalPages;
  }


  public String getPeriodicalUrl() {
    return periodicalUrl;
  }

  public void setPeriodicalUrl(String periodicalUrl) {
    this.periodicalUrl = periodicalUrl;
  }


  public String getKeyWordsEnglishList() {
    return keyWordsEnglishList;
  }

  public void setKeyWordsEnglishList(String keyWordsEnglishList) {
    this.keyWordsEnglishList = keyWordsEnglishList;
  }


  public String getPaperAbstract() {
    return paperAbstract;
  }

  public void setPaperAbstract(String paperAbstract) {
    this.paperAbstract = paperAbstract;
  }


  public String getAuthorInfoList() {
    return authorInfoList;
  }

  public void setAuthorInfoList(String authorInfoList) {
    this.authorInfoList = authorInfoList;
  }


  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }


  public String getDoi() {
    return doi;
  }

  public void setDoi(String doi) {
    this.doi = doi;
  }

}
