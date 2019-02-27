package org.iscas.graph.dto;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphDto {
	List<CategoryDto> categories;
	List<NodeDto> data;
	List<LinkDto> links;
	private void makeCategories() {
		categories = new ArrayList<CategoryDto>();
		categories.add(new CategoryDto("方剂"));
		categories.add(new CategoryDto("中药材"));
		categories.add(new CategoryDto("病症"));
	}
	public GraphDto(List<NodeDto> data,List<LinkDto> links) {
		Collections.sort(data);
		this.data = data;
		this.links = links;
		makeCategories();
	}
	public GraphDto(List<NodeDto> data,List<LinkDto> links,List<CategoryDto> categories) {
		this.data = data;
		this.links = links;
		this.categories = categories;
	}
	public List<CategoryDto> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDto> categories) {
		this.categories = categories;
	}

	public List<NodeDto> getData() {
		return data;
	}

	public void setData(List<NodeDto> data) {
		this.data = data;
	}

	public List<LinkDto> getLinks() {
		return links;
	}

	public void setLinks(List<LinkDto> links) {
		this.links = links;
	}


	
}