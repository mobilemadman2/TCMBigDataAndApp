package org.iscas.graph.nodeentity;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author 
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Disease extends Entity{

	@Relationship(type = "Treat", direction = Relationship.INCOMING)
	private List<Treat> treates = new ArrayList();
	
	public Disease() {
	}

	public List<Treat> getTreates() {
		return treates;
	}

	public void setTreates(List<Treat> treates) {
		this.treates = treates;
	}

	
}
