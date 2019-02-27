package org.iscas.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import org.iscas.conf.EntityRelationType;
import org.iscas.web.dao.BookDao;
import org.iscas.web.dao.DiseaseDao;
import org.iscas.web.dao.ExpertDao;
import org.iscas.web.dao.MaterialDao;
import org.iscas.web.dao.PrescriptionDao;
import org.iscas.web.dao.relation.MaterialBookRelationDao;
import org.iscas.web.dao.relation.MaterialDiseaseRelationDao;
import org.iscas.web.dao.relation.MaterialExpertRelationDao;
import org.iscas.web.dao.relation.MaterialPrescriptionRelationDao;
import org.iscas.web.dao.relation.finalstate.BookDiseaseRelationDao;
import org.iscas.web.dao.relation.finalstate.BookExpertRelationDao;
import org.iscas.web.dao.relation.finalstate.BookMaterialRelationDao;
import org.iscas.web.dao.relation.finalstate.BookPrescriptionRelationDao;
import org.iscas.web.entity.Disease;
import org.iscas.web.entity.Expert;
import org.iscas.web.entity.Material;
import org.iscas.web.entity.Prescription;
import org.iscas.web.entity.relationship.BookRelation;
import org.iscas.web.entity.relationship.RelationShip;
import org.iscas.web.entity.relationship.finalstate.BookDiseaseRelation;
import org.iscas.web.entity.relationship.finalstate.BookExpertRelation;
import org.iscas.web.entity.relationship.finalstate.BookMaterialRelation;
import org.iscas.web.entity.relationship.finalstate.BookPrescriptionRelation;
import org.iscas.web.view.RelationCollection;
import org.iscas.web.view.RelationCollectionView;
import org.iscas.web.view.RelationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaterialRelationViewService {
	@Autowired 
	MaterialDiseaseRelationDao mdDao;
	
	@Autowired
	MaterialBookRelationDao mbDao;
	
	@Autowired
	MaterialExpertRelationDao meDao;
	
	@Autowired
	MaterialPrescriptionRelationDao mpDao;
	
	@Autowired
	BookDao bookDao;
	
	@Autowired
	DiseaseDao diseaseDao;
	
	@Autowired
	MaterialDao materialDao;
	
	@Autowired
	PrescriptionDao prescriptionDao;
	
	@Autowired
	ExpertDao expertDao;
	
	public MaterialRelationViewService() {
		// TODO Auto-generated constructor stub
	}
	
	
	public RelationCollectionView GenerateView(Long baseId) {
		RelationCollection rc = new RelationCollection();
		rc.put(EntityRelationType.BookDiseaseRelation, "中医疾病", mdDao.findByBaseId(baseId));
		rc.put(EntityRelationType.BookMaterialRelation, "中医古籍", mbDao.findByBaseId(baseId));
		rc.put(EntityRelationType.BookPrescriptionRelation, "中医处方", mpDao.findByBaseId(baseId));
		rc.put(EntityRelationType.BookExpertRelation, "中医名家", meDao.findByBaseId(baseId));
		
		RelationCollectionView view=new RelationCollectionView();
		for(Map.Entry<String, String> entry: rc.getViews().entrySet()) {
			List<RelationView> rvList = new ArrayList<>();
//			System.out.println(entry.getKey());
			List<? extends RelationShip> relationList = rc.getRelations().get(entry.getKey());
//			if(relationList.size()<=0) continue;
			
			List<String> list = new ArrayList<>();
//			List<Integer> poslist = new ArrayList<>();
			HashMap<String, String> nameHash = new HashMap<>();
			HashSet<String> distinctNameSet = new HashSet<>(); 
			for(RelationShip rs : relationList) {
				if(distinctNameSet.contains(rs.getRelatedEntity())) continue;
				else {
					distinctNameSet.add(rs.getRelatedEntity());
					list.add(rs.getRelatedEntity());
					nameHash.put(rs.getRelatedEntity(), null);
				}
			}

			//组装不同类型数据
			if(entry.getKey().equals(EntityRelationType.MaterialDiseaseRelation)) {
				distinctNameSet.clear();
				for(Disease d : diseaseDao.findByNameIn(list)) {
					if(distinctNameSet.contains(d.getName())) continue;
					else distinctNameSet.add(d.getName());
					rvList.add(new RelationView(d));
					if(nameHash.containsKey(d.getName())) nameHash.remove(d.getName());
				}
				for(String name : nameHash.keySet()) {
					rvList.add(new RelationView(name, null));
				}
				view.put(EntityRelationType.MaterialDiseaseRelation, "中医疾病", rvList);	
			}else if(entry.getKey().equals(EntityRelationType.MaterialPrescriptionRelation)) {
				distinctNameSet.clear();
				for(Prescription p : prescriptionDao.findByNameIn(list)) {
					if(distinctNameSet.contains(p.getName())) continue;
					else distinctNameSet.add(p.getName());
					rvList.add(new RelationView(p));
					if(nameHash.containsKey(p.getName())) nameHash.remove(p.getName());
				};
				for(String name : nameHash.keySet()) {
					rvList.add(new RelationView(name, null));
				}
				view.put(EntityRelationType.MaterialPrescriptionRelation, "中医处方", rvList);
			}else if(entry.getKey().equals(EntityRelationType.MaterialBookRelation)) {
				distinctNameSet.clear();
				for(Material m :materialDao.findByNameCnIn(list)){
					if(distinctNameSet.contains(m.getNameCn())) continue;
					else distinctNameSet.add(m.getNameCn());
					rvList.add(new RelationView(m));
					if(nameHash.containsKey(m.getNameCn())) nameHash.remove(m.getNameCn());
				}
				for(String name : nameHash.keySet()) {
					rvList.add(new RelationView(name, null));
				}		
				view.put(EntityRelationType.MaterialBookRelation, "中草药", rvList);
			}else if(entry.getKey().equals(EntityRelationType.MaterialExpertRelation)) {
				distinctNameSet.clear();
				for(Expert e:expertDao.findByNameIn(list)) {
					if(distinctNameSet.contains(e.getName())) continue;
					else distinctNameSet.add(e.getName());
					rvList.add(new RelationView(e));
					if(nameHash.containsKey(e.getName())) nameHash.remove(e.getName());
				}
				for(String name : nameHash.keySet()) {
					rvList.add(new RelationView(name, null));
				}
				view.put(EntityRelationType.MaterialExpertRelation, "中医名家", rvList);
			}
			
//			for(String s: list) {
//				System.out.println(s);
//			}
//			
//			System.out.println(diseaseDao.findByNameIn(list).size());
		}
		return view;
	}
//	public RelationCollectionView GenerateSingleView(String bookname, String path, String viewtype) {
//		RelationCollectionView view=new RelationCollectionView();
//			List<RelationView> rvList = new ArrayList<>();
//			List<? extends RelationShip> relationList = null;
//			//组装不同类型数据
//			if("book-disease".equals(viewtype)) {
//				relationList = bookDiseaseRelationDao.findByBaseEntityAndPath(bookname, path);
//			}else if("book-prescription".equals(viewtype)) {
//				relationList = bookPrescriptionRelationDao.findByBaseEntityAndPath(bookname, path);
//			}else if("book-material".equals(viewtype)) {
//				relationList = bookMaterialRelationDao.findByBaseEntityAndPath(bookname, path);
//			}else if("book-expert".equals(viewtype)) {
//				relationList = bookExpertRelationDao.findByBaseEntityAndPath(bookname, path);
//			}
//			if(relationList==null) return null;
//			
//			List<String> list = new ArrayList<>();
//			HashMap<String, String> nameHash = new HashMap<>();
//			HashSet<String> distinctNameSet = new HashSet<>(); 
//			for(RelationShip rs : relationList) {
//				if(distinctNameSet.contains(rs.getRelatedEntity())) continue;
//				else {
//					distinctNameSet.add(rs.getRelatedEntity());
//					list.add(rs.getRelatedEntity());
//					nameHash.put(rs.getRelatedEntity(), null);
//				}
//			}
//			
//			//组装不同类型数据
//			
//			if("book-disease".equals(viewtype)) {
//				distinctNameSet.clear();				
//				for(Disease d : diseaseDao.findByNameIn(list)) {
//					if(distinctNameSet.contains(d.getName())) continue;
//					else distinctNameSet.add(d.getName());
//					rvList.add(new RelationView(d));
//					if(nameHash.containsKey(d.getName())) nameHash.remove(d.getName());
//				}
//				for(String name : nameHash.keySet()) {
//					rvList.add(new RelationView(name, null));
//				}
//				view.put("book-disease", "中医疾病", rvList);				
//			}else if("book-prescription".equals(viewtype)) {
//				distinctNameSet.clear();
//				for(Prescription p : prescriptionDao.findByNameIn(list)) {
//					if(distinctNameSet.contains(p.getName())) continue;
//					else distinctNameSet.add(p.getName());
//					rvList.add(new RelationView(p));
//					if(nameHash.containsKey(p.getName())) nameHash.remove(p.getName());
//				};
//				for(String name : nameHash.keySet()) {
//					rvList.add(new RelationView(name, null));
//				}
//				view.put("book-prescription", "中医处方", rvList);
//			}else if("book-material".equals(viewtype)) {
//				distinctNameSet.clear();
//				for(Material m :materialDao.findByNameCnIn(list)){
//					if(distinctNameSet.contains(m.getNameCn())) continue;
//					else distinctNameSet.add(m.getNameCn());
//					rvList.add(new RelationView(m));
//					if(nameHash.containsKey(m.getNameCn())) nameHash.remove(m.getNameCn());
//				}
//				for(String name : nameHash.keySet()) {
//					rvList.add(new RelationView(name, null));
//				}		
//				view.put("book-material", "中草药", rvList);
//			}else if("book-expert".equals(viewtype)) {
//				distinctNameSet.clear();
//				for(Expert e:expertDao.findByNameIn(list)) {
//					if(distinctNameSet.contains(e.getName())) continue;
//					else distinctNameSet.add(e.getName());
//					rvList.add(new RelationView(e));
//					if(nameHash.containsKey(e.getName())) nameHash.remove(e.getName());
//				}
//				for(String name : nameHash.keySet()) {
//					rvList.add(new RelationView(name, null));
//				}
//				view.put("book-expert", "中医名家", rvList);
//			}
	
//		return view;
//	}

}

