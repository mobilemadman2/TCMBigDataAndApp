package org.iscas.graph.dto;

public class CategoryDto {
	String name;
	String symbol;
	
	public CategoryDto(String name) {
		this.name = name;
		this.symbol = "circle";
	}
	public CategoryDto(String name,String symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
}
