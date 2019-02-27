package org.iscas.web.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bing_zheng_tab1")
public class Syndrome extends IdEntity {

	//一级分类
	private String level1_name;
	//二级分类
	private String level2_name;
	//二级分类英文名
	private String level2_name_en;
	//术语名称
	@NotNull
	private String name;
	//术语英文名
	private String name_en;
	//术语拼音
	private String namePinyin;
	//同义词
	private String synonym;
	//术语编号
	private String standard_num;
	//疾病名称
	private String disease_names;
	//搜索别名
	private String search_alias;
	
	//概述
	@Column(columnDefinition = "TEXT")
	private String general_description;
	
	//临床表现
	@Column(columnDefinition = "TEXT")
	private String general_clinical;
	
	//本证辨析
	@Column(columnDefinition = "TEXT")
	private String distinguish;
	
	//类证鉴别
	@Column(columnDefinition = "TEXT")
	private String identify;
	
	//文献选录
	@Column(columnDefinition = "TEXT")
	private String reference;
	
	//数据来源
	@Column(columnDefinition = "TEXT")
	private String data_source;
	
	//备注
	@Column(columnDefinition = "TEXT")
	private String comments;

	public String getLevel1_name() {
		return level1_name;
	}

	public void setLevel1_name(String level1_name) {
		this.level1_name = level1_name;
	}

	public String getLevel2_name() {
		return level2_name;
	}

	public void setLevel2_name(String level2_name) {
		this.level2_name = level2_name;
	}

	public String getLevel2_name_en() {
		return level2_name_en;
	}

	public void setLevel2_name_en(String level2_name_en) {
		this.level2_name_en = level2_name_en;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	
	public String getNamePinyin() {
		return namePinyin;
	}

	public void setNamePinyin(String namePinyin) {
		this.namePinyin = namePinyin;
	}

	public String getSynonym() {
		return synonym;
	}

	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}

	public String getStandard_num() {
		return standard_num;
	}

	public void setStandard_num(String standard_num) {
		this.standard_num = standard_num;
	}

	public String getDisease_names() {
		return disease_names;
	}

	public void setDisease_names(String disease_names) {
		this.disease_names = disease_names;
	}

	public String getSearch_alias() {
		return search_alias;
	}

	public void setSearch_alias(String search_alias) {
		this.search_alias = search_alias;
	}

	public String getGeneral_description() {
		return general_description;
	}

	public void setGeneral_description(String general_description) {
		this.general_description = general_description;
	}

	public String getGeneral_clinical() {
		return general_clinical;
	}

	public void setGeneral_clinical(String general_clinical) {
		this.general_clinical = general_clinical;
	}

	public String getDistinguish() {
		return distinguish;
	}

	public void setDistinguish(String distinguish) {
		this.distinguish = distinguish;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getData_source() {
		return data_source;
	}

	public void setData_source(String data_source) {
		this.data_source = data_source;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
