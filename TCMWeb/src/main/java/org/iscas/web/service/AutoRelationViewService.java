package org.iscas.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.iscas.web.dao.BookDao;
import org.iscas.web.dao.DiseaseDao;
import org.iscas.web.dao.ExpertDao;
import org.iscas.web.dao.MaterialDao;
import org.iscas.web.dao.PrescriptionDao;
import org.iscas.web.dao.relation.intermediatestate.*;
import org.iscas.web.entity.Disease;
import org.iscas.web.entity.Expert;
import org.iscas.web.entity.Material;
import org.iscas.web.entity.Prescription;
import org.iscas.web.entity.relationship.RelationShip;
import org.iscas.web.entity.relationship.intermediatestate.*;
import org.iscas.web.view.RelationCollection;
import org.iscas.web.view.RelationCollectionView;
import org.iscas.web.view.RelationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AutoRelationViewService {
	@Autowired 
	AutoBookDiseaseRelationDao bookDiseaseRelationDao;
	
	@Autowired
	AutoBookMaterialRelationDao bookMaterialRelationDao;
	
	@Autowired
	AutoBookExpertRelationDao bookExpertRelationDao;
	
	@Autowired
	AutoBookPrescriptionRelationDao bookPrescriptionRelationDao;
	
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
	
	public AutoRelationViewService() {
		// TODO Auto-generated constructor stub
	}
	
	public void delete(String bookname, String path, String entitykey, String entityvalue) {
		System.out.println(bookname+"\t"+path+"\t"+entitykey+"\t"+entityvalue+"\t");

		String [] ar = entitykey.split("_");
		String target = ar[0];
		RelationShip rs = new RelationShip();
//		Repository<? extends RelationShip, Long> repository = null;
		if(target.equals("book-disease")) {
//			repository = bookDiseaseRelationDao;
			AutoBookDiseaseRelation relation = bookDiseaseRelationDao.findByBaseEntityAndRelatedEntityAndPath(bookname, entityvalue, path);
			if(relation!=null||!"".equals(entityvalue)) {
				bookDiseaseRelationDao.delete(relation);
			}else {
				relation = new AutoBookDiseaseRelation();
				relation.setBaseEntity(bookname);
				relation.setPath(path);
				relation.setPosition(0);
				bookDiseaseRelationDao.delete(relation);
			}
//			System.out.println(relation.getId());
		}
		else if ("book-material".equals(target)) {
//			repository = bookDiseaseRelationDao;
			AutoBookMaterialRelation relation = bookMaterialRelationDao.findByBaseEntityAndRelatedEntityAndPath(bookname, entityvalue, path);
			if(relation!=null||!"".equals(entityvalue)) {
				bookMaterialRelationDao.delete(relation);
			}else {
				relation = new AutoBookMaterialRelation();
				relation.setBaseEntity(bookname);
				relation.setPath(path);
				relation.setPosition(0);
				bookMaterialRelationDao.delete(relation);
			}
//			System.out.println(relation.getId());
//			repository = bookMaterialRelationDao;
		}
		else if ("book-prescription".equals(target)) {
			AutoBookPrescriptionRelation relation = bookPrescriptionRelationDao.findByBaseEntityAndRelatedEntityAndPath(bookname, entityvalue, path);
			if(relation!=null||!"".equals(entityvalue)) {
				bookPrescriptionRelationDao.delete(relation);
			}else {
				relation = new AutoBookPrescriptionRelation();
				relation.setBaseEntity(bookname);
				relation.setPath(path);
				relation.setPosition(0);
				bookPrescriptionRelationDao.delete(relation);
			}
//			System.out.println(relation.getId());
//			repository = bookPrescriptionRelationDao;
		}
		else if ("book-expert".equals(target)) {
//			repository = bookExpertRelationDao;
			AutoBookExpertRelation relation = bookExpertRelationDao.findByBaseEntityAndRelatedEntityAndPath(bookname, entityvalue, path);
			if(relation!=null||!"".equals(entityvalue)) {
				bookExpertRelationDao.delete(relation);
			}else {
				relation = new AutoBookExpertRelation();
				relation.setBaseEntity(bookname);
				relation.setPath(path);
				relation.setPosition(0);
				bookExpertRelationDao.delete(relation);
			}
		}
		
	}
	
	public void update(String bookname, String path, String entitykey, String entityvalue, String newvalue) {
		System.out.println(bookname+"\t"+path+"\t"+entitykey+"\t"+entityvalue+"\t"+newvalue);

		String [] ar = entitykey.split("_");
		String target = ar[0];
		RelationShip rs = new RelationShip();
//		Repository<? extends RelationShip, Long> repository = null;
		if(target.equals("book-disease")) {
//			repository = bookDiseaseRelationDao;
			AutoBookDiseaseRelation relation = bookDiseaseRelationDao.findByBaseEntityAndRelatedEntityAndPath(bookname, entityvalue, path);
			if(relation!=null||!"".equals(entityvalue)) {
				relation.setRelatedEntity(newvalue);
				bookDiseaseRelationDao.save(relation);
			}else {
				relation = new AutoBookDiseaseRelation();
				relation.setBaseEntity(bookname);
				relation.setRelatedEntity(newvalue);
				relation.setPath(path);
				relation.setPosition(0);
				bookDiseaseRelationDao.save(relation);
			}
//			System.out.println(relation.getId());
		}
		else if ("book-material".equals(target)) {
//			repository = bookDiseaseRelationDao;
			AutoBookMaterialRelation relation = bookMaterialRelationDao.findByBaseEntityAndRelatedEntityAndPath(bookname, entityvalue, path);
			if(relation!=null||!"".equals(entityvalue)) {
				relation.setRelatedEntity(newvalue);
				bookMaterialRelationDao.save(relation);
			}else {
				relation = new AutoBookMaterialRelation();
				relation.setBaseEntity(bookname);
				relation.setRelatedEntity(newvalue);
				relation.setPath(path);
				relation.setPosition(0);
				bookMaterialRelationDao.save(relation);
			}
//			System.out.println(relation.getId());
//			repository = bookMaterialRelationDao;
		}
		else if ("book-prescription".equals(target)) {
			AutoBookPrescriptionRelation relation = bookPrescriptionRelationDao.findByBaseEntityAndRelatedEntityAndPath(bookname, entityvalue, path);
			if(relation!=null||!"".equals(entityvalue)) {
				relation.setRelatedEntity(newvalue);
				bookPrescriptionRelationDao.save(relation);
			}else {
				relation = new AutoBookPrescriptionRelation();
				relation.setBaseEntity(bookname);
				relation.setRelatedEntity(newvalue);
				relation.setPath(path);
				relation.setPosition(0);
				bookPrescriptionRelationDao.save(relation);
			}
//			System.out.println(relation.getId());
//			repository = bookPrescriptionRelationDao;
		}
		else if ("book-expert".equals(target)) {
//			repository = bookExpertRelationDao;
			AutoBookExpertRelation relation = bookExpertRelationDao.findByBaseEntityAndRelatedEntityAndPath(bookname, entityvalue, path);
			if(relation!=null||!"".equals(entityvalue)) {
				relation.setRelatedEntity(newvalue);
				bookExpertRelationDao.save(relation);
			}else {
				relation = new AutoBookExpertRelation();
				relation.setBaseEntity(bookname);
				relation.setRelatedEntity(newvalue);
				relation.setPath(path);
				relation.setPosition(0);
				bookExpertRelationDao.save(relation);
			}
		}

	}
	public RelationCollectionView GenerateView(String bookname, String path) {
		RelationCollection rc = new RelationCollection();
		rc.put("book-disease", "中医疾病", bookDiseaseRelationDao.findByBaseEntityAndPath(bookname, path));
		rc.put("book-material", "中医草药", bookMaterialRelationDao.findByBaseEntityAndPath(bookname, path));
		rc.put("book-prescription", "中医处方", bookPrescriptionRelationDao.findByBaseEntityAndPath(bookname, path));
		rc.put("book-expert", "中医名家", bookExpertRelationDao.findByBaseEntityAndPath(bookname, path));
		
		RelationCollectionView view=new RelationCollectionView();
		for(Map.Entry<String, String> entry: rc.getViews().entrySet()) {
			List<RelationView> rvList = new ArrayList<>();
//			System.out.println(entry.getKey());
			List<? extends RelationShip> relationList = rc.getRelations().get(entry.getKey());
//			if(relationList.size()<=0) continue;
			
			List<String> list = new ArrayList<>();
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

			distinctNameSet.clear();
			if(entry.getKey().equals("book-disease")) {
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
				view.put("book-disease", "中医疾病", rvList);				
			}else if(entry.getKey().equals("book-prescription")) {
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
				view.put("book-prescription", "中医处方", rvList);
			}else if(entry.getKey().equals("book-material")) {
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
				view.put("book-material", "中草药", rvList);
			}else if(entry.getKey().equals("book-expert")) {
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
				view.put("book-expert", "中医名家", rvList);
			}
			
//			for(String s: list) {
//				System.out.println(s);
//			}
//			
//			System.out.println(diseaseDao.findByNameIn(list).size());
		}
		
		
		return view;
	}
	public RelationCollectionView GenerateSingleView(String bookname, String path, String viewtype) {
		RelationCollectionView view=new RelationCollectionView();
			List<RelationView> rvList = new ArrayList<>();
			List<? extends RelationShip> relationList = null;
			//组装不同类型数据
			if("book-disease".equals(viewtype)) {
				relationList = bookDiseaseRelationDao.findByBaseEntityAndPath(bookname, path);
			}else if("book-prescription".equals(viewtype)) {
				relationList = bookPrescriptionRelationDao.findByBaseEntityAndPath(bookname, path);
			}else if("book-material".equals(viewtype)) {
				relationList = bookMaterialRelationDao.findByBaseEntityAndPath(bookname, path);
			}else if("book-expert".equals(viewtype)) {
				relationList = bookExpertRelationDao.findByBaseEntityAndPath(bookname, path);
			}
			if(relationList==null) return null;
			List<String> list = new ArrayList<>();
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
			distinctNameSet.clear();
			if("book-disease".equals(viewtype)) {
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
				view.put("book-disease", "中医疾病", rvList);				
			}else if("book-prescription".equals(viewtype)) {
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
				view.put("book-prescription", "中医处方", rvList);
			}else if("book-material".equals(viewtype)) {
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
				view.put("book-material", "中草药", rvList);
			}else if("book-expert".equals(viewtype)) {
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
				view.put("book-expert", "中医名家", rvList);
			}

		
		
		return view;
	}
	
	public RelationCollectionView GenerateAllView(String bookname) {
		RelationCollection rc = new RelationCollection();
		rc.put("book-disease", "中医疾病", bookDiseaseRelationDao.findByBaseEntity(bookname));
		rc.put("book-material", "中医草药", bookMaterialRelationDao.findByBaseEntity(bookname));
		rc.put("book-prescription", "中医处方", bookPrescriptionRelationDao.findByBaseEntity(bookname));
		rc.put("book-expert", "中医名家", bookExpertRelationDao.findByBaseEntity(bookname));
		
		RelationCollectionView view=new RelationCollectionView();
		for(Map.Entry<String, String> entry: rc.getViews().entrySet()) {
			List<RelationView> rvList = new ArrayList<>();
//			System.out.println(entry.getKey());
			List<? extends RelationShip> relationList = rc.getRelations().get(entry.getKey());
//			if(relationList.size()<=0) continue;
			
			List<String> list = new ArrayList<>();
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
			if(entry.getKey().equals("book-disease")) {
				for(Disease d : diseaseDao.findByNameIn(list)) {
					rvList.add(new RelationView(d));
					if(nameHash.containsKey(d.getName())) nameHash.remove(d.getName());
				}
				for(String name : nameHash.keySet()) {
					rvList.add(new RelationView(name, null));
				}
				view.put("book-disease", "中医疾病", rvList);				
			}else if(entry.getKey().equals("book-prescription")) {
				for(Prescription p : prescriptionDao.findByNameIn(list)) {
					rvList.add(new RelationView(p));
					if(nameHash.containsKey(p.getName())) nameHash.remove(p.getName());
				};
				for(String name : nameHash.keySet()) {
					rvList.add(new RelationView(name, null));
				}
				view.put("book-prescription", "中医处方", rvList);
			}else if(entry.getKey().equals("book-material")) {
				for(Material m :materialDao.findByNameCnIn(list)){
					rvList.add(new RelationView(m));
					if(nameHash.containsKey(m.getNameCn())) nameHash.remove(m.getNameCn());
				}
				for(String name : nameHash.keySet()) {
					rvList.add(new RelationView(name, null));
				}		
				view.put("book-material", "中草药", rvList);
			}else if(entry.getKey().equals("book-expert")) {
				for(Expert e:expertDao.findByNameIn(list)) {
					rvList.add(new RelationView(e));
					if(nameHash.containsKey(e.getName())) nameHash.remove(e.getName());
				}
				for(String name : nameHash.keySet()) {
					rvList.add(new RelationView(name, null));
				}
				view.put("book-expert", "中医名家", rvList);
			}
			
//			for(String s: list) {
//				System.out.println(s);
//			}
//			
//			System.out.println(diseaseDao.findByNameIn(list).size());
		}
		return view;
	}

}
