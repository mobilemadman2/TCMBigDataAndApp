package org.iscas.graph.dto;

import java.text.Collator;

public class NodeDto implements Comparable{
	private String id;
	private int category;
	private String name;
	private String symbol;
	private int symbolSize;
	
	public NodeDto(){
		this.id = String.valueOf(0L);
		this.category = 1;
		this.symbol = "circle";
		this.symbolSize = 70;
		this.name = "";
	}
	public NodeDto(Long id, int category, String name) {
		this.id = String.valueOf(id+100);
		this.category = category;
		this.symbol = "circle";
		this.symbolSize = 70;
		this.name = name;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
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
	public int getSymbolSize() {
		return symbolSize;
	}
	public void setSymbolSize(int symbolSize) {
		this.symbolSize = symbolSize;
	}
	public int compareTo(Object o) {
		NodeDto n1 = (NodeDto)o;
		String anotherName = n1.getName();
		return Collator.getInstance(java.util.Locale.CHINA).compare(this.name, anotherName);
		//return this.name.compareTo(anotherName);
	}
	
}
