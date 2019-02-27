package org.iscas.web.view;

import java.util.List;

public class SortPatent {
	private String name;
	private List<String> patents; 
	private List<String> patentesId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPatents() {
		return patents;
	}
	public void setPatents(List<String> patents) {
		this.patents = patents;
	}
	public List<String> getPatentesId() {
		return patentesId;
	}
	public void setPatentesId(List<String> patentesId) {
		this.patentesId = patentesId;
	} 
}
