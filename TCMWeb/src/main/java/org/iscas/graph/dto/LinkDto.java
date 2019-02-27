package org.iscas.graph.dto;

import org.iscas.graph.nodeentity.Entity;

public class LinkDto {
	private String source;
	private String target;
	
	
	public LinkDto(Long source,Long target){
		this.source = String.valueOf(source+100);
		this.target = String.valueOf(target+100);
	}
	public LinkDto(Entity source,Entity target){
		this.source = String.valueOf(source.getId()+100);
		this.target = String.valueOf(target.getId()+100);
	}

	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}
	
	
}
