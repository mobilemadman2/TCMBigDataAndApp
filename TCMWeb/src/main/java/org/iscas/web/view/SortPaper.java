package org.iscas.web.view;

import java.util.List;

public class SortPaper {
	private String name;
	List<String> papers; 
	List<String> papersId;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPapers() {
		return papers;
	}
	public void setPapers(List<String> papers) {
		this.papers = papers;
	}
	public List<String> getPapersId() {
		return papersId;
	}
	public void setPapersId(List<String> papersId) {
		this.papersId = papersId;
	}
	
}
