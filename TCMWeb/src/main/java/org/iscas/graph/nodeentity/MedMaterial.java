package org.iscas.graph.nodeentity;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author pin
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class MedMaterial extends Entity{
	
	@Relationship(type = "Consist", direction = Relationship.INCOMING)
	private List<Consist> consists = new ArrayList();
	
	public MedMaterial() {
	}

	public MedMaterial(String name) {
		this.setName(name);
	}


	public List<Consist> getConsists() {
		return consists;
	}

	public void setConsists(List<Consist> consists) {
		this.consists = consists;
	}


	
}
