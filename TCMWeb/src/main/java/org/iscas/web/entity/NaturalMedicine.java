package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="naturalmedicine_register") 
public class NaturalMedicine extends IdEntity {



  //private long id;
  private String reg;
  private String nameCn;
  private String aliasCn;
  private String wrong;
  private String similar;
  private String nameEn;
  @Column(columnDefinition = "TEXT")
  private String aliasEn;
  @Column(columnDefinition = "TEXT")
  private String nameLatin;
  @Column(columnDefinition = "TEXT")
  private String nameLatinAa;
  private String chinesePinyin;
  private String familyCn;
  private String familyLatin;
  private String genusCn;
  private String genusLatin;
  @Column(columnDefinition = "TEXT")
  private String note;
  @Column(columnDefinition = "TEXT")
  private String state;





  public String getReg() {
    return reg;
  }

  public void setReg(String reg) {
    this.reg = reg;
  }


  public String getNameCn() {
    return nameCn;
  }

  public void setNameCn(String nameCn) {
    this.nameCn = nameCn;
  }


  public String getAliasCn() {
    return aliasCn;
  }

  public void setAliasCn(String aliasCn) {
    this.aliasCn = aliasCn;
  }


  public String getWrong() {
    return wrong;
  }

  public void setWrong(String wrong) {
    this.wrong = wrong;
  }


  public String getSimilar() {
    return similar;
  }

  public void setSimilar(String similar) {
    this.similar = similar;
  }


  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }


  public String getAliasEn() {
    return aliasEn;
  }

  public void setAliasEn(String aliasEn) {
    this.aliasEn = aliasEn;
  }


  public String getNameLatin() {
    return nameLatin;
  }

  public void setNameLatin(String nameLatin) {
    this.nameLatin = nameLatin;
  }


  public String getNameLatinAa() {
    return nameLatinAa;
  }

  public void setNameLatinAa(String nameLatinAa) {
    this.nameLatinAa = nameLatinAa;
  }


  public String getChinesePinyin() {
    return chinesePinyin;
  }

  public void setChinesePinyin(String chinesePinyin) {
    this.chinesePinyin = chinesePinyin;
  }


  public String getFamilyCn() {
    return familyCn;
  }

  public void setFamilyCn(String familyCn) {
    this.familyCn = familyCn;
  }


  public String getFamilyLatin() {
    return familyLatin;
  }

  public void setFamilyLatin(String familyLatin) {
    this.familyLatin = familyLatin;
  }


  public String getGenusCn() {
    return genusCn;
  }

  public void setGenusCn(String genusCn) {
    this.genusCn = genusCn;
  }


  public String getGenusLatin() {
    return genusLatin;
  }

  public void setGenusLatin(String genusLatin) {
    this.genusLatin = genusLatin;
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
