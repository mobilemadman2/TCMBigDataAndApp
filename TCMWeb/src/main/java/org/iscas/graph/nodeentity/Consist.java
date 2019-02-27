package org.iscas.graph.nodeentity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.RelationshipEntity;

/**
 * @author 
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "Consist")
public class Consist extends Relation{
	public Consist() {
	}

	public Consist(Prescription prescription, MedMaterial medMaterial) {
		this.setStart_Entity(prescription);
		this.setEnd_Entity(medMaterial);
	}

}
