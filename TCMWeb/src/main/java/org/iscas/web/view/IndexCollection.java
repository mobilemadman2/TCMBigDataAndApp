package org.iscas.web.view;

import java.util.List;
/**
 * @author solar
 *
 */
public class IndexCollection {
	public IndexCollection() {
		// TODO Auto-generated constructor stub
	}
	private Long standardCount;
	
	private String firstIndex;
	
	private List<CountStandard> secondIndexCollection;

	public Long getStandardCount() {
		return standardCount;
	}

	public void setStandardCount(Long standardCount) {
		this.standardCount = standardCount;
	}

	public String getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(String firstIndex) {
		this.firstIndex = firstIndex;
	}

	public List<CountStandard> getSecondIndexCollection() {
		return secondIndexCollection;
	}

	public void setSecondIndexCollection(List<CountStandard> secondIndexCollection) {
		this.secondIndexCollection = secondIndexCollection;
	}

	
}
