package org.iscas.web.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.iscas.web.entity.relationship.RelationShip;


public class RelationCollectionView {
	Map<String, List<RelationView>> relations;
	Map<String, String> views; 

	public RelationCollectionView() {
		// TODO Auto-generated constructor stub
		relations = new LinkedHashMap<>();
		views = new LinkedHashMap<>();
	}

	public Map<String, List<RelationView> > getRelations() {
		return relations;
	}

	public void setRelations(LinkedHashMap<String, List<RelationView>> relations) {
		this.relations = relations;
	}
	
	public void put(String key, String name, List<RelationView> relationship) {
		relations.put(key, relationship);
		views.put(key, name);
	}

	public Map<String, String> getViews() {
		return views;
	}

	public void setViews(LinkedHashMap<String, String> views) {
		this.views = views;
	}


}
