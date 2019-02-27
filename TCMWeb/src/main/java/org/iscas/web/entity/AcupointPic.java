package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wbc
 *
 */
@Entity
@Table(name = "acupoint_picture_pos")
public class AcupointPic extends IdEntity{
	
	private String picName;
	private String acupointName;
	private String position;
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public String getAcupointName() {
		return acupointName;
	}
	public void setAcupointName(String acupointName) {
		this.acupointName = acupointName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
