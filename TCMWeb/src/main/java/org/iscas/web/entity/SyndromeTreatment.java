package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bing_zheng_tab2")
public class SyndromeTreatment extends IdEntity {

	@NotNull
	private String name;
	
	//标准病症名
	private String name_standard;
	//疾病ID
	private long disease_id;
	//疾病名称
	private String disease_name;
	//例子
	private String example;
	
	//加减
	@Column(columnDefinition = "TEXT")
	private String jiajian;
	
	//证候
	@Column(columnDefinition = "TEXT")
	private String zhenghou;
	
	//治法
	@Column(columnDefinition = "TEXT")
	private String zhifa;
	
	//主方
	@Column(columnDefinition = "TEXT")
	private String zhufang;
	
	//数据来源
	@Column(columnDefinition = "TEXT")
	private String data_source;
	
	
	public String getName_standard() {
		return name_standard;
	}
	public void setName_standard(String name_standard) {
		this.name_standard = name_standard;
	}
	public String getDisease_name() {
		return disease_name;
	}
	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}
	public String getData_source() {
		return data_source;
	}
	public void setData_source(String data_source) {
		this.data_source = data_source;
	}
	public long getDisease_id() {
		return disease_id;
	}
	public void setDisease_id(long disease_id) {
		this.disease_id = disease_id;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public String getJiajian() {
		return jiajian;
	}
	public void setJiajian(String jiajian) {
		this.jiajian = jiajian;
	}
	public String getZhenghou() {
		return zhenghou;
	}
	public void setZhenghou(String zhenghou) {
		this.zhenghou = zhenghou;
	}
	public String getZhifa() {
		return zhifa;
	}
	public void setZhifa(String zhifa) {
		this.zhifa = zhifa;
	}
	public String getZhufang() {
		return zhufang;
	}
	public void setZhufang(String zhufang) {
		this.zhufang = zhufang;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
