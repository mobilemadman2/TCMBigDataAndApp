package org.iscas.graph.nodeentity;

import org.neo4j.ogm.annotation.Id;

import org.iscas.graph.dto.LinkDto;
import org.iscas.graph.dto.NodeDto;



public class Entity {
	@Id
	private Long id;
	
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public NodeDto toNodeDto() {
		NodeDto dto = new NodeDto(this.getId(),1,this.getName());
		return dto;
	}
	public NodeDto toNodeDto(int category) {
		NodeDto dto = new NodeDto(this.getId(),category,this.getName());
		return dto;
	}
}
