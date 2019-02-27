package org.iscas.graph.nodeentity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.neo4j.ogm.annotation.RelationshipEntity;

/**
 * @author 
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "Treat")
public class Treat extends Relation{

	public Treat() {
	}

	public Treat(Prescription prescription, Disease disease) {
		this.setStart_Entity(prescription);
		this.setEnd_Entity(disease);
	}

	

}
