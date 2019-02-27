package org.iscas.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table

public class Standard extends IdEntity{
	
	//标准编号
	@Column(columnDefinition="TEXT")
	private String standardNumber;
	
	//标准名称
	@Column(columnDefinition="TEXT")
	private String standardName;
		
	//英文名称
	@Column(columnDefinition="TEXT")
	private String englishName;
	
	//标准状态
	@Column(columnDefinition="TEXT")
	private String standardStatus;
	
	//发布日期
	@Column(columnDefinition="Date")
	private Date releaseDate;
	
	//实施日期
	@Column(columnDefinition="Date")
	private Date implementationDate;
	
	//归口单位
	@Column(columnDefinition="TEXT")
	private String technicalCommittees;
	
	//主管单位
	@Column(columnDefinition="TEXT")
	private String competentUnit;
	
	//内容简介
	@Column(columnDefinition="TEXT")
	private String briefIntroduction;
		
	//发布部门
	@Column(columnDefinition="TEXT")
	private String releaseDepartment;
	
	//起草单位
	@Column(columnDefinition="TEXT")
	private String draftingUnit;
	
	//起草人
	@Column(columnDefinition="TEXT")
	private String draftingPeople;
	
	//起草日期
	@Column(columnDefinition="Date")
	private String draftingDate;
	
	//页数
	@Column(columnDefinition="INT")
	private String pageCount;
		
	//替代状态
	@Column(columnDefinition="TEXT")
	private String replaceStatus;
		
	//文件路径
	@Column(columnDefinition="TEXT")
	private String filePath;
	
	//一级索引
	@Column(columnDefinition="TEXT")
	private String firstIndex;
	
	//二级索引
	@Column(columnDefinition="TEXT")
	private String secondIndex;
	
	@Column(length=50)
	private String chinaTypeCcs;
	
	@Column(length=50)
	private String InternationalTypeIcs;
	
	private String comments;

	public String getStandardNumber() {
		return standardNumber;
	}

	public void setStandardNumber(String standardNumber) {
		this.standardNumber = standardNumber;
	}

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getStandardStatus() {
		return standardStatus;
	}

	public void setStandardStatus(String standardStatus) {
		this.standardStatus = standardStatus;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getImplementationDate() {
		return implementationDate;
	}

	public void setImplementationDate(Date implementationDate) {
		this.implementationDate = implementationDate;
	}

	public String getTechnicalCommittees() {
		return technicalCommittees;
	}

	public void setTechnicalCommittees(String technicalCommittees) {
		this.technicalCommittees = technicalCommittees;
	}

	public String getCompetentUnit() {
		return competentUnit;
	}

	public void setCompetentUnit(String competentUnit) {
		this.competentUnit = competentUnit;
	}

	public String getBriefIntroduction() {
		return briefIntroduction;
	}

	public void setBriefIntroduction(String briefIntroduction) {
		this.briefIntroduction = briefIntroduction;
	}

	public String getReleaseDepartment() {
		return releaseDepartment;
	}

	public void setReleaseDepartment(String releaseDepartment) {
		this.releaseDepartment = releaseDepartment;
	}

	public String getDraftingUnit() {
		return draftingUnit;
	}

	public void setDraftingUnit(String draftingUnit) {
		this.draftingUnit = draftingUnit;
	}

	public String getDraftingPeople() {
		return draftingPeople;
	}

	public void setDraftingPeople(String draftingPeople) {
		this.draftingPeople = draftingPeople;
	}

	public String getDraftingDate() {
		return draftingDate;
	}

	public void setDraftingDate(String draftingDate) {
		this.draftingDate = draftingDate;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public String getReplaceStatus() {
		return replaceStatus;
	}

	public void setReplaceStatus(String replaceStatus) {
		this.replaceStatus = replaceStatus;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(String firstIndex) {
		this.firstIndex = firstIndex;
	}

	public String getSecondIndex() {
		return secondIndex;
	}

	public void setSecondIndex(String secondIndex) {
		this.secondIndex = secondIndex;
	}

	public String getChinaTypeCcs() {
		return chinaTypeCcs;
	}

	public void setChinaTypeCcs(String chinaTypeCcs) {
		this.chinaTypeCcs = chinaTypeCcs;
	}

	public String getInternationalTypeIcs() {
		return InternationalTypeIcs;
	}

	public void setInternationalTypeIcs(String internationalTypeIcs) {
		InternationalTypeIcs = internationalTypeIcs;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
