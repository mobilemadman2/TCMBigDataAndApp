package org.iscas.web.view;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.iscas.web.entity.relationship.RelationShip;

//class RelationShipWithAddress{
//	RelationShip relationShip;
//	String address;
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
// }
public class RelationCollection {
	LinkedHashMap<String, List<? extends RelationShip>> relations;
	LinkedHashMap<String, String> views; 

	public RelationCollection() {
		// TODO Auto-generated constructor stub
		relations = new LinkedHashMap<>();
		views = new LinkedHashMap<>();
	}

	public LinkedHashMap<String, List<? extends RelationShip>> getRelations() {
		return relations;
	}

	public void setRelations(LinkedHashMap<String, List<? extends RelationShip>> relations) {
		this.relations = relations;
	}
	
	public void put(String key, String name, List<? extends RelationShip> relationship) {
		relations.put(key, relationship);
		views.put(key, name);
	}

	public LinkedHashMap<String, String> getViews() {
		return views;
	}

	public void setViews(LinkedHashMap<String, String> views) {
		this.views = views;
	}


}
