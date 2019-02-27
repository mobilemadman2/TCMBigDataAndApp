package org.iscas.graph.nodeentity;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.StartNode;
import org.iscas.graph.dto.LinkDto;
//import ucas.pin.web.dto.LinkDto;
//import ucas.pin.web.dto.NodeDto;

public class Relation {

	@Id
	private Long id;
	
	
	@StartNode
	private Entity start_Entity;
	
	@EndNode
	private Entity end_Entity;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

	public Entity getStart_Entity() {
		return start_Entity;
	}


	public void setStart_Entity(Entity start_Entity) {
		this.start_Entity = start_Entity;
	}


	public Entity getEnd_Entity() {
		return end_Entity;
	}


	public void setEnd_Entity(Entity end_Entity) {
		this.end_Entity = end_Entity;
	}

	public LinkDto toLinkDto() {
		System.out.println(this.getStart_Entity().getName()+"---->"+this.getEnd_Entity().getName());
		System.out.println(this.getStart_Entity().getId()+"---->"+this.getEnd_Entity().getId());
		
		LinkDto dto = new LinkDto(this.getStart_Entity(),this.getEnd_Entity());
		return dto;
	}
	
	
	
}
