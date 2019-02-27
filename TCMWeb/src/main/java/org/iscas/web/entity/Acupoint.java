package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wbc
 *
 */
@Entity
@Table(name = "xueweibiao")
public class Acupoint extends IdEntity{
	//穴位名称
	private String xueweimingcheng;
	//国标编号
	private String guobiaobianhao;
	//拼音
	@Column(columnDefinition = "TEXT")
	private String pinyin;
	//英文名称
	private String yingwenmingcheng;	
	//suoshujingluofenleimingcheng
	private String suoshujingluofenleimingcheng;	
	
	//主治
	@Column(columnDefinition = "TEXT")
	private String zhuzhi;
	//人体定位
	@Column(columnDefinition = "TEXT")
	private String rentidingwei;	
	
	//解剖
		@Column(columnDefinition = "TEXT")
		private String jiepou;	
		//配伍
		@Column(columnDefinition = "TEXT")
		private String peiwu;	
		//针灸法
		@Column(columnDefinition = "TEXT")
		private String cijiufa;	
		//辅助
		@Column(columnDefinition = "TEXT")
		private String fuzhu;
		//国标定义
		private String guobiaodingyi;
		//备注
		@Column(columnDefinition = "TEXT")
		private String beizhu;
		
		
	public String getXueweimingcheng() {
		return xueweimingcheng;
	}
	public void setXueweimingcheng(String xueweimingcheng) {
		this.xueweimingcheng = xueweimingcheng;
	}
	public String getGuobiaobianhao() {
		return guobiaobianhao;
	}
	public void setGuobiaobianhao(String guobiaobianhao) {
		this.guobiaobianhao = guobiaobianhao;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getYingwenmingcheng() {
		return yingwenmingcheng;
	}
	public void setYingwenmingcheng(String yingwenmingcheng) {
		this.yingwenmingcheng = yingwenmingcheng;
	}
	public String getSuoshujingluofenleimingcheng() {
		return suoshujingluofenleimingcheng;
	}
	public void setSuoshujingluofenleimingcheng(String suoshujingluofenleimingcheng) {
		this.suoshujingluofenleimingcheng = suoshujingluofenleimingcheng;
	}
	public String getZhuzhi() {
		return zhuzhi;
	}
	public void setZhuzhi(String zhuzhi) {
		this.zhuzhi = zhuzhi;
	}
	public String getRentidingwei() {
		return rentidingwei;
	}
	public void setRentidingwei(String rentidingwei) {
		this.rentidingwei = rentidingwei;
	}
	public String getJiepou() {
		return jiepou;
	}
	public void setJiepou(String jiepou) {
		this.jiepou = jiepou;
	}
	public String getPeiwu() {
		return peiwu;
	}
	public void setPeiwu(String peiwu) {
		this.peiwu = peiwu;
	}
	public String getCijiufa() {
		return cijiufa;
	}
	public void setCijiufa(String cijiufa) {
		this.cijiufa = cijiufa;
	}
	public String getFuzhu() {
		return fuzhu;
	}
	public void setFuzhu(String fuzhu) {
		this.fuzhu = fuzhu;
	}
	public String getGuobiaodingyi() {
		return guobiaodingyi;
	}
	public void setGuobiaodingyi(String guobiaodingyi) {
		this.guobiaodingyi = guobiaodingyi;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	
}
