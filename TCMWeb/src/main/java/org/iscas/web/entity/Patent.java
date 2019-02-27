package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


@Entity
@Table
public class Patent extends IdEntity {

  @NotNull
  private long patno;

  @Column(columnDefinition = "TEXT")
  private String errFieldName;

  //
  @Column(columnDefinition = "TEXT")
  private String errFieldValue;
//
  @Column(columnDefinition = "Longtext")
  private String tm;

  //
  @Column(columnDefinition = "Longtext")
  private String pn;
  //
  @Column(columnDefinition = "Longtext")
  private String kc;
  //
  @Column(columnDefinition = "Longtext")
  private String pd;
  //
  @Column(columnDefinition = "Longtext")
  private String an;
  //
  @Column(columnDefinition = "Longtext")
  private String ad;
  //
  @Column(columnDefinition = "Longtext")
  private String ipnf;
  //
  @Column(columnDefinition = "Longtext")
  private String iapf;
  //
  @Column(columnDefinition = "Longtext")
  private String ipr;
  //
  @Column(columnDefinition = "Longtext")
  private String cinr;
  //
  @Column(columnDefinition = "Longtext")
  private String einr;
  //
  @Column(columnDefinition = "Longtext")
  private String cpa;
  //
  @Column(columnDefinition = "Longtext")
  private String epa;
  //
  @Column(columnDefinition = "Longtext")
  private String mpa;
  //
  @Column(columnDefinition = "Longtext")
  private String caddr;
  //
  @Column(columnDefinition = "Longtext")
  private String eaddr;
  //
  @Column(columnDefinition = "Longtext")
  private String cpti;
  //
  @Column(columnDefinition = "Longtext")
  private String ti;
  //
  @Column(columnDefinition = "Longtext")
  private String tiPinyin;
  //
  @Column(columnDefinition = "Longtext")
  private String epti;
  //
  @Column(columnDefinition = "Longtext")
  private String eti;
  //
  @Column(columnDefinition = "Longtext")
  private String cpab;
  
  //
  @Column(columnDefinition = "Longtext")
  private String ab;  
  //
  @Column(columnDefinition = "Longtext")
  private String epab;  
  //
  @Column(columnDefinition = "Longtext")
  private String eab;  
  //
  @Column(columnDefinition = "Longtext")
  private String ic;  
  //
  @Column(columnDefinition = "Longtext")
  private String it;  
  //
  @Column(columnDefinition = "Longtext")
  private String eit;  
  //
  @Column(columnDefinition = "Longtext")
  private String itc;  
  //
  @Column(columnDefinition = "Longtext")
  private String ceff;  
  //
  @Column(columnDefinition = "Longtext")
  private String eeff;  
  //
  @Column(columnDefinition = "Longtext")
  private String rn;  
  //
  @Column(columnDefinition = "Longtext")
  private String formula;  
  //
  @Column(columnDefinition = "Longtext")
  private String eformula;  
  //
  @Column(columnDefinition = "Longtext")
  private String newformula;  
  //
  @Column(columnDefinition = "Longtext")
  private String neweformula;  
  //
  @Column(columnDefinition = "Longtext")
  private String cdn;  
  //
  @Column(columnDefinition = "Longtext")
  private String edn;  
  //
  @Column(columnDefinition = "Longtext")
  private String cn;  
  //
  @Column(columnDefinition = "Longtext")
  private String prb;  
  //
  @Column(columnDefinition = "Longtext")
  private String pac;  
  //
  @Column(columnDefinition = "Longtext")
  private String unf;  
  //
  @Column(columnDefinition = "Longtext")
  private String img;
public long getPatno() {
	return patno;
}
public void setPatno(long patno) {
	this.patno = patno;
}
public String getErrFieldName() {
	return errFieldName;
}
public void setErrFieldName(String errFieldName) {
	this.errFieldName = errFieldName;
}
public String getErrFieldValue() {
	return errFieldValue;
}
public void setErrFieldValue(String errFieldValue) {
	this.errFieldValue = errFieldValue;
}
public String getTm() {
	return tm;
}
public String getTiPinyin() {
	return tiPinyin;
}
public void setTiPinyin(String tiPinyin) {
	this.tiPinyin = tiPinyin;
}
public void setTm(String tm) {
	this.tm = tm;
}
public String getPn() {
	return pn;
}
public void setPn(String pn) {
	this.pn = pn;
}
public String getKc() {
	return kc;
}
public void setKc(String kc) {
	this.kc = kc;
}
public String getPd() {
	return pd;
}
public void setPd(String pd) {
	this.pd = pd;
}
public String getAn() {
	return an;
}
public void setAn(String an) {
	this.an = an;
}
public String getAd() {
	return ad;
}
public void setAd(String ad) {
	this.ad = ad;
}
public String getIpnf() {
	return ipnf;
}
public void setIpnf(String ipnf) {
	this.ipnf = ipnf;
}
public String getIapf() {
	return iapf;
}
public void setIapf(String iapf) {
	this.iapf = iapf;
}
public String getIpr() {
	return ipr;
}
public void setIpr(String ipr) {
	this.ipr = ipr;
}
public String getCinr() {
	return cinr;
}
public void setCinr(String cinr) {
	this.cinr = cinr;
}
public String getEinr() {
	return einr;
}
public void setEinr(String einr) {
	this.einr = einr;
}
public String getCpa() {
	return cpa;
}
public void setCpa(String cpa) {
	this.cpa = cpa;
}
public String getEpa() {
	return epa;
}
public void setEpa(String epa) {
	this.epa = epa;
}
public String getMpa() {
	return mpa;
}
public void setMpa(String mpa) {
	this.mpa = mpa;
}
public String getCaddr() {
	return caddr;
}
public void setCaddr(String caddr) {
	this.caddr = caddr;
}
public String getEaddr() {
	return eaddr;
}
public void setEaddr(String eaddr) {
	this.eaddr = eaddr;
}
public String getCpti() {
	return cpti;
}
public void setCpti(String cpti) {
	this.cpti = cpti;
}
public String getTi() {
	return ti;
}
public void setTi(String ti) {
	this.ti = ti;
}
public String getEpti() {
	return epti;
}
public void setEpti(String epti) {
	this.epti = epti;
}
public String getEti() {
	return eti;
}
public void setEti(String eti) {
	this.eti = eti;
}
public String getCpab() {
	return cpab;
}
public void setCpab(String cpab) {
	this.cpab = cpab;
}
public String getAb() {
	return ab;
}
public void setAb(String ab) {
	this.ab = ab;
}
public String getEpab() {
	return epab;
}
public void setEpab(String epab) {
	this.epab = epab;
}
public String getEab() {
	return eab;
}
public void setEab(String eab) {
	this.eab = eab;
}
public String getIc() {
	return ic;
}
public void setIc(String ic) {
	this.ic = ic;
}
public String getIt() {
	return it;
}
public void setIt(String it) {
	this.it = it;
}
public String getEit() {
	return eit;
}
public void setEit(String eit) {
	this.eit = eit;
}
public String getItc() {
	return itc;
}
public void setItc(String itc) {
	this.itc = itc;
}
public String getCeff() {
	return ceff;
}
public void setCeff(String ceff) {
	this.ceff = ceff;
}
public String getEeff() {
	return eeff;
}
public void setEeff(String eeff) {
	this.eeff = eeff;
}
public String getRn() {
	return rn;
}
public void setRn(String rn) {
	this.rn = rn;
}
public String getFormula() {
	return formula;
}
public void setFormula(String formula) {
	this.formula = formula;
}
public String getEformula() {
	return eformula;
}
public void setEformula(String eformula) {
	this.eformula = eformula;
}
public String getNewformula() {
	return newformula;
}
public void setNewformula(String newformula) {
	this.newformula = newformula;
}
public String getNeweformula() {
	return neweformula;
}
public void setNeweformula(String neweformula) {
	this.neweformula = neweformula;
}
public String getCdn() {
	return cdn;
}
public void setCdn(String cdn) {
	this.cdn = cdn;
}
public String getEdn() {
	return edn;
}
public void setEdn(String edn) {
	this.edn = edn;
}
public String getCn() {
	return cn;
}
public void setCn(String cn) {
	this.cn = cn;
}
public String getPrb() {
	return prb;
}
public void setPrb(String prb) {
	this.prb = prb;
}
public String getPac() {
	return pac;
}
public void setPac(String pac) {
	this.pac = pac;
}
public String getUnf() {
	return unf;
}
public void setUnf(String unf) {
	this.unf = unf;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}

}
