package org.iscas.graph.nodeentity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author pin 
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Prescription extends Entity{

//	@GraphId
//	private Long id;

//	private String name;


	@Relationship(type = "Treat", direction = Relationship.OUTGOING)
	private List<Treat> treates = new ArrayList();

	@Relationship(type = "Consist", direction = Relationship.OUTGOING)
	private List<Consist> consists = new ArrayList();

	public Prescription() {
	}

	public Prescription(String name) {
		this.setName(name);
	}
//
//
//
//	public String getName() {
//		return name;
//	}


	public Collection<Treat> getTreates() {
		return treates;
	}

	public void addTreat(Treat treat) {
		this.treates.add(treat);
	}
	public Collection<Consist> getConsists() {
		return consists;
	}

	public void addConsist(Consist consist) {
		this.consists.add(consist);
	}
	//NodeDto(Long id, int category, String name) {
//	public NodeDto toNodeDto() {
//		NodeDto dto = new NodeDto(this.getId(),1,this.getName());
//		return dto;
//		
//	}
}
