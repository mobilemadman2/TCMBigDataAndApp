package org.iscas.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.iscas.conf.EntityRelationType;
import org.iscas.conf.GraphEntityRelationType;
import org.iscas.graph.nodeentity.MedMaterial;
import org.iscas.graph.nodeentity.Prescription;
import org.iscas.graph.repository.DiseaseRepository;
import org.iscas.graph.repository.MedMaterialRepository;
import org.iscas.graph.repository.PrescriptionRepository;
import org.iscas.web.dao.DiseaseDao;
import org.iscas.web.dao.MaterialDao;
import org.iscas.web.dao.PrescriptionDao;
import org.iscas.web.entity.Disease;
import org.iscas.web.entity.Expert;
import org.iscas.web.entity.Material;
import org.iscas.web.entity.relationship.RelationShip;
import org.iscas.web.entity.relationship.finalstate.BookDiseaseRelation;
import org.iscas.web.entity.relationship.finalstate.BookExpertRelation;
import org.iscas.web.entity.relationship.finalstate.BookMaterialRelation;
import org.iscas.web.entity.relationship.finalstate.BookPrescriptionRelation;

import org.iscas.web.view.RelationCollection;
import org.iscas.web.view.RelationCollectionView;
import org.iscas.web.view.RelationView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GraphRelationViewService {
	@Autowired 
	DiseaseRepository dr;
	
	@Autowired
	MedMaterialRepository mmr;
		
	@Autowired
	PrescriptionRepository pr;
	
	@Autowired
	DiseaseDao diseaseDao;
	
	@Autowired
	MaterialDao materialDao;
	
	@Autowired
	PrescriptionDao prescriptionDao;
	
	public GraphRelationViewService() {
		// TODO Auto-generated constructor stub
	}
	
	public RelationCollectionView GenerateView(String relation, String name) {
		RelationCollectionView view=new RelationCollectionView();
		Map<String, List<String>> rls = new LinkedHashMap<>(); 
		if(GraphEntityRelationType.MaterialRelation.equals(relation)) {
			//中草药对应关系
			List<String> prescriptions = new ArrayList(); 
			for(Prescription p:mmr.getPrescriptionByMaterialName(name)) {
				prescriptions.add(p.getName());
			}
			rls.put(GraphEntityRelationType.PrescriptionRelation, prescriptions);
		}else if(GraphEntityRelationType.PrescriptionRelation.equals(relation)){
			//相关疾病
			List<String> diseases = new ArrayList<>();
			for(org.iscas.graph.nodeentity.Disease d: pr.getDiseaseByPrescriptionName(name)) {
				diseases.add(d.getName());
			}
			rls.put(GraphEntityRelationType.DiseaseRelation, diseases);
			//相关中草药
			List<String> materials = new ArrayList<>();
			for(MedMaterial m: pr.getMedmaterialByPrescriptionName(name)) {
				materials.add(m.getName());
			}
			rls.put(GraphEntityRelationType.MaterialRelation, materials);
		}else if(GraphEntityRelationType.DiseaseRelation.equals(relation)) {
			//相关方剂
			List<String> prescriptions = new ArrayList(); 
			for(Prescription p: dr.getPrescriptionByDiseaseName(name)) {
				prescriptions.add(p.getName());
			}
			rls.put(GraphEntityRelationType.PrescriptionRelation, prescriptions);
		}
		

		
		//组合
		for(Map.Entry<String, List<String>> entry: rls.entrySet()) {
			List<RelationView> rvList = new ArrayList<>();
			
			List<String> list = new ArrayList<>();
			HashMap<String, String> nameHash = new HashMap<>();
			HashSet<String> distinctNameSet = new HashSet<>(); 
			for(String pname : entry.getValue()) {
				if(distinctNameSet.contains(pname)) continue;
				else {
					distinctNameSet.add(pname);
					list.add(pname);
					nameHash.put(pname, null);
				}
			}
			
			if(GraphEntityRelationType.PrescriptionRelation.equals(entry.getKey())) {
				distinctNameSet.clear();
				for(org.iscas.web.entity.Prescription p : prescriptionDao.findByNameIn(entry.getValue())) {
					if(distinctNameSet.contains(p.getName())) continue;
					else distinctNameSet.add(p.getName());
					rvList.add(new RelationView(p));
					if(nameHash.containsKey(p.getName())) nameHash.remove(p.getName());
				};
				for(String aname : nameHash.keySet()) {
					rvList.add(new RelationView(aname, null));
				}
				if(rvList.size()>0)
					view.put("prescription", "中医方剂", rvList);
			}else if(GraphEntityRelationType.MaterialRelation.equals(entry.getKey())) {
				distinctNameSet.clear();
				for(org.iscas.web.entity.Material m : materialDao.findByNameCnIn(entry.getValue())) {
					if(distinctNameSet.contains(m.getNameCn())) continue;
					else distinctNameSet.add(m.getNameCn());
					rvList.add(new RelationView(m));
					if(nameHash.containsKey(m.getNameCn())) nameHash.remove(m.getNameCn());
				};
				for(String aname : nameHash.keySet()) {
					rvList.add(new RelationView(aname, null));
				}
				if(rvList.size()>0)
					view.put("material", "中草药", rvList);
			} else if(GraphEntityRelationType.DiseaseRelation.equals(entry.getKey())) {
				distinctNameSet.clear();
				for(org.iscas.web.entity.Disease p : diseaseDao.findByNameIn(entry.getValue())) {
					if(distinctNameSet.contains(p.getName())) continue;
					else distinctNameSet.add(p.getName());
					rvList.add(new RelationView(p));
					if(nameHash.containsKey(p.getName())) nameHash.remove(p.getName());
				};
				for(String aname : nameHash.keySet()) {
					rvList.add(new RelationView(aname, null));
				}
				if(rvList.size()>0)
					view.put("disease", "中医疾病", rvList);
			}
		}

		
		return view;
	}

}