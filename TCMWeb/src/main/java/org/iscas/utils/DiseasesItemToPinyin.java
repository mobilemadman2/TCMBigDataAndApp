package org.iscas.utils;


import java.util.ArrayList;
import java.util.List;

import org.iscas.web.dao.DiseaseDao;
import org.iscas.web.dao.DiseaseDao;
import org.iscas.web.entity.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseasesItemToPinyin {

	@Autowired
	DiseaseDao diseasesDao;
	
	public void GenerateNamePinyin() {
		List<Disease> list =  diseasesDao.findAll();
		List<Disease> updateNamePinyin = new ArrayList<>(); 
		for(Disease Disease:list) {
			if(Disease.getNamePinyin()==null||"".equals(Disease.getNamePinyin())) {
				if(Disease.getName()!=null && Disease.getName()!="") {
					Disease.setNamePinyin(ChineseToPinyin.getPinyin(Disease.getName()).toUpperCase());
					System.out.println(Disease.getNamePinyin());
					updateNamePinyin.add(Disease);
				}
				
			}
		}
		diseasesDao.saveAll(updateNamePinyin);
		diseasesDao.flush();

	}
	

}
