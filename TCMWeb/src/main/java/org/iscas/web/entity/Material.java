package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table
public class Material extends IdEntity{

  //private long id;
  private String namePinyin;
	

@Column(columnDefinition = "TEXT")
  private String link;
  @Column(columnDefinition = "TEXT")
  private String nameCn;
  @Column(columnDefinition = "TEXT")
  private String pinyin;
  @Column(columnDefinition = "TEXT")
  private String nameLatin;
  @Column(columnDefinition = "TEXT")
  private String nameEn;
  @Column(columnDefinition = "TEXT")
  private String alias;
  @Column(columnDefinition = "TEXT")
  private String picture;
  @Column(columnDefinition = "TEXT")
  private String classification;
  @Column(columnDefinition = "TEXT")
  private String sourceCn;
  @Column(columnDefinition = "TEXT")
  private String sourceEn;
  @Column(columnDefinition = "TEXT")
  private String sourceLatin;
  @Column(columnDefinition = "TEXT")
  private String sourceSubfamily;
  @Column(columnDefinition = "TEXT")
  private String description;
  @Column(columnDefinition = "TEXT")
  private String attribution;
  @Column(columnDefinition = "TEXT")
  private String composition;
  @Column(columnDefinition = "TEXT")
  private String pharmacologic;
  @Column(columnDefinition = "TEXT")
  private String taste;
  @Column(columnDefinition = "TEXT")
  private String channel;
  @Column(columnDefinition = "TEXT")
  private String effect;
  @Column(columnDefinition = "TEXT")
  private String action;
  @Column(columnDefinition = "TEXT")
  private String method;
  @Column(columnDefinition = "TEXT")
  private String taboo;
  @Column(columnDefinition = "TEXT")
  private String virulence;
  @Column(columnDefinition = "TEXT")
  private String cultivation;
  @Column(columnDefinition = "TEXT")
  private String origin;
  @Column(columnDefinition = "TEXT")
  private String recovery;
  @Column(columnDefinition = "TEXT")
  private String process;
  @Column(columnDefinition = "TEXT")
  private String research;
  @Column(columnDefinition = "TEXT")
  private String discuss;
  @Column(columnDefinition = "TEXT")
  private String excerpt;


  public String getNamePinyin() {
	return namePinyin;
}

public void setNamePinyin(String namePinyin) {
	this.namePinyin = namePinyin;
}
  
  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }


  public String getNameCn() {
    return nameCn;
  }

  public void setNameCn(String nameCn) {
    this.nameCn = nameCn;
  }


  public String getPinyin() {
    return pinyin;
  }

  public void setPinyin(String pinyin) {
    this.pinyin = pinyin;
  }


  public String getNameLatin() {
    return nameLatin;
  }

  public void setNameLatin(String nameLatin) {
    this.nameLatin = nameLatin;
  }


  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }


  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }


  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }


  public String getClassification() {
    return classification;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }


  public String getSourceCn() {
    return sourceCn;
  }

  public void setSourceCn(String sourceCn) {
    this.sourceCn = sourceCn;
  }


  public String getSourceEn() {
    return sourceEn;
  }

  public void setSourceEn(String sourceEn) {
    this.sourceEn = sourceEn;
  }


  public String getSourceLatin() {
    return sourceLatin;
  }

  public void setSourceLatin(String sourceLatin) {
    this.sourceLatin = sourceLatin;
  }


  public String getSourceSubfamily() {
    return sourceSubfamily;
  }

  public void setSourceSubfamily(String sourceSubfamily) {
    this.sourceSubfamily = sourceSubfamily;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getAttribution() {
    return attribution;
  }

  public void setAttribution(String attribution) {
    this.attribution = attribution;
  }


  public String getComposition() {
    return composition;
  }

  public void setComposition(String composition) {
    this.composition = composition;
  }


  public String getPharmacologic() {
    return pharmacologic;
  }

  public void setPharmacologic(String pharmacologic) {
    this.pharmacologic = pharmacologic;
  }


  public String getTaste() {
    return taste;
  }

  public void setTaste(String taste) {
    this.taste = taste;
  }


  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }


  public String getEffect() {
    return effect;
  }

  public void setEffect(String effect) {
    this.effect = effect;
  }


  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }


  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }


  public String getTaboo() {
    return taboo;
  }

  public void setTaboo(String taboo) {
    this.taboo = taboo;
  }


  public String getVirulence() {
    return virulence;
  }

  public void setVirulence(String virulence) {
    this.virulence = virulence;
  }


  public String getCultivation() {
    return cultivation;
  }

  public void setCultivation(String cultivation) {
    this.cultivation = cultivation;
  }


  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }


  public String getRecovery() {
    return recovery;
  }

  public void setRecovery(String recovery) {
    this.recovery = recovery;
  }


  public String getProcess() {
    return process;
  }

  public void setProcess(String process) {
    this.process = process;
  }


  public String getResearch() {
    return research;
  }

  public void setResearch(String research) {
    this.research = research;
  }


  public String getDiscuss() {
    return discuss;
  }

  public void setDiscuss(String discuss) {
    this.discuss = discuss;
  }


  public String getExcerpt() {
    return excerpt;
  }

  public void setExcerpt(String excerpt) {
    this.excerpt = excerpt;
  }

}

