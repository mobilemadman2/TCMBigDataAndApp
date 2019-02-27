package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wbc
 *
 */
@Entity
@Table(name = "jingluomaibiao")
public class AcupointClassification extends IdEntity{
	private String jingluomingcheng;
	private String jingluomingchengfenlei;
	private String duiyingshichen;
	
	@Column(columnDefinition = "TEXT")
	private String jingmaixunxing;
	
	@Column(columnDefinition = "TEXT")
	private String zhuyaobinghou;
	
	@Column(columnDefinition = "TEXT")
	private String zhuzhigaiyao;
	
	private String xueweishuliang;
	
	@Column(columnDefinition = "TEXT")
	private String xueweimingchengliebiao;
	
	
	@Column(columnDefinition = "TEXT")
	private String zhuzhi;
	
	
	@Column(columnDefinition = "TEXT")
	private String jiaohuishuxue;
	
	private String rentishiyitu;
	
	@Column(columnDefinition = "TEXT")
	private String miaoshu;
	
	private String shifouguobiao;
	
	public String getJingluomingcheng() {
		return jingluomingcheng;
	}

	public void setJingluomingcheng(String jingluomingcheng) {
		this.jingluomingcheng = jingluomingcheng;
	}

	public String getJingluomingchengfenlei() {
		return jingluomingchengfenlei;
	}

	public void setJingluomingchengfenlei(String jingluomingchengfenlei) {
		this.jingluomingchengfenlei = jingluomingchengfenlei;
	}

	public String getDuiyingshichen() {
		return duiyingshichen;
	}

	public void setDuiyingshichen(String duiyingshichen) {
		this.duiyingshichen = duiyingshichen;
	}

	public String getJingmaixunxing() {
		return jingmaixunxing;
	}

	public void setJingmaixunxing(String jingmaixunxing) {
		this.jingmaixunxing = jingmaixunxing;
	}

	public String getZhuyaobinghou() {
		return zhuyaobinghou;
	}

	public void setZhuyaobinghou(String zhuyaobinghou) {
		this.zhuyaobinghou = zhuyaobinghou;
	}

	public String getZhuzhigaiyao() {
		return zhuzhigaiyao;
	}

	public void setZhuzhigaiyao(String zhuzhigaiyao) {
		this.zhuzhigaiyao = zhuzhigaiyao;
	}

	public String getXueweishuliang() {
		return xueweishuliang;
	}

	public void setXueweishuliang(String xueweishuliang) {
		this.xueweishuliang = xueweishuliang;
	}

	public String getXueweimingchengliebiao() {
		return xueweimingchengliebiao;
	}

	public void setXueweimingchengliebiao(String xueweimingchengliebiao) {
		this.xueweimingchengliebiao = xueweimingchengliebiao;
	}

	public String getZhuzhi() {
		return zhuzhi;
	}

	public void setZhuzhi(String zhuzhi) {
		this.zhuzhi = zhuzhi;
	}

	public String getJiaohuishuxue() {
		return jiaohuishuxue;
	}

	public void setJiaohuishuxue(String jiaohuishuxue) {
		this.jiaohuishuxue = jiaohuishuxue;
	}

	public String getRentishiyitu() {
		return rentishiyitu;
	}

	public void setRentishiyitu(String rentishiyitu) {
		this.rentishiyitu = rentishiyitu;
	}

	public String getMiaoshu() {
		return miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}

	public String getShifouguobiao() {
		return shifouguobiao;
	}

	public void setShifouguobiao(String shifouguobiao) {
		this.shifouguobiao = shifouguobiao;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	@Column(columnDefinition = "TEXT")
	private String beizhu;

	
	
}
