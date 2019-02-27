package org.iscas.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="expert_paper")
public class Paper extends IdEntity{
	
	private String doctor_institution;
	private String doctor_name;
	private String doctor_url;
	private String paper_name;
	private String paper_name_en;
	private String paper_url;
	private String periodical_time;
	private String periodical_employ_list;
	private String periodical_name;
	private String class_num_list;
	private String key_words_chinese_list;
	private String periodical_pages;
	private String periodical_url;
	private String key_words_english_list;
	private String paper_abstract;
	private String author_info_list;
	private String column_name;
	private String doi;
	private String author;
	private String department;
	private String name_pinyin;
	public String getDoctor_institution() {
		return doctor_institution;
	}
	public void setDoctor_institution(String doctor_institution) {
		this.doctor_institution = doctor_institution;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDoctor_url() {
		return doctor_url;
	}
	public void setDoctor_url(String doctor_url) {
		this.doctor_url = doctor_url;
	}
	public String getPaper_name() {
		return paper_name;
	}
	public void setPaper_name(String paper_name) {
		this.paper_name = paper_name;
	}
	public String getPaper_name_en() {
		return paper_name_en;
	}
	public void setPaper_name_en(String paper_name_en) {
		this.paper_name_en = paper_name_en;
	}
	public String getPaper_url() {
		return paper_url;
	}
	public void setPaper_url(String paper_url) {
		this.paper_url = paper_url;
	}
	public String getPeriodical_time() {
		return periodical_time;
	}
	public void setPeriodical_time(String periodical_time) {
		this.periodical_time = periodical_time;
	}
	public String getPeriodical_employ_list() {
		return periodical_employ_list;
	}
	public void setPeriodical_employ_list(String periodical_employ_list) {
		this.periodical_employ_list = periodical_employ_list;
	}
	public String getPeriodical_name() {
		return periodical_name;
	}
	public void setPeriodical_name(String periodical_name) {
		this.periodical_name = periodical_name;
	}
	public String getClass_num_list() {
		return class_num_list;
	}
	public void setClass_num_list(String class_num_list) {
		this.class_num_list = class_num_list;
	}
	public String getKey_words_chinese_list() {
		return key_words_chinese_list;
	}
	public void setKey_words_chinese_list(String key_words_chinese_list) {
		this.key_words_chinese_list = key_words_chinese_list;
	}
	public String getPeriodical_pages() {
		return periodical_pages;
	}
	public void setPeriodical_pages(String periodical_pages) {
		this.periodical_pages = periodical_pages;
	}
	public String getPeriodical_url() {
		return periodical_url;
	}
	public void setPeriodical_url(String periodical_url) {
		this.periodical_url = periodical_url;
	}
	public String getKey_words_english_list() {
		return key_words_english_list;
	}
	public void setKey_words_english_list(String key_words_english_list) {
		this.key_words_english_list = key_words_english_list;
	}
	public String getPaper_abstract() {
		return paper_abstract;
	}
	public void setPaper_abstract(String paper_abstract) {
		this.paper_abstract = paper_abstract;
	}
	public String getAuthor_info_list() {
		return author_info_list;
	}
	public void setAuthor_info_list(String author_info_list) {
		this.author_info_list = author_info_list;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getName_pinyin() {
		return name_pinyin;
	}
	public void setName_pinyin(String name_pinyin) {
		this.name_pinyin = name_pinyin;
	}
}
	
	
	
	
	
	
