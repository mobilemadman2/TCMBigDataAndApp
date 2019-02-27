package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table
public class Dynasty extends IdEntity{
	public static enum DynastyType {
        UNKOWN,
        MAIN,
		
		DETAIL;
		/*
		private int value;
		private DynastyType(int value) {
			this.value = value;
		}
		
		public DynastyType valueOf(int value) {
			switch (value) {
			case 1:
				return DynastyType.MAIN;
//				break;

			case 2:
				return DynastyType.DETAIL;
//				break;
				
			default:
				break;
			}
			
			return DynastyType.UNKOWN;
		}*/
    }
	
	public Dynasty() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Column(unique=true)
	private String name;
	
	private int startTime;
	private int endTime;
	private String capital;
	private String capitalCurrentAddress;
	private String founder;
	private DynastyType type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getCapitalCurrentAddress() {
		return capitalCurrentAddress;
	}
	public void setCapitalCurrentAddress(String capitalCurrentAddress) {
		this.capitalCurrentAddress = capitalCurrentAddress;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public DynastyType getType() {
		return type;
	}
	public void setType(DynastyType type) {
		this.type = type;
	}

}
