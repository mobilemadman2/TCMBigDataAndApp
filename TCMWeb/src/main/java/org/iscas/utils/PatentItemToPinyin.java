package org.iscas.utils;


import java.util.ArrayList;
import java.util.List;

import org.iscas.web.dao.PatentDao;
import org.iscas.web.entity.Patent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatentItemToPinyin {

	@Autowired
	PatentDao patentDao;
	
	public void GenerateNamePinyin() {
		List<Patent> list =  patentDao.findAll();
		List<Patent> updateNamePinyin = new ArrayList<>(); 
		for(Patent patent:list) {
			if(patent.getTiPinyin()==null||"".equals(patent.getTiPinyin())) {
				if(patent.getTi()!=null && patent.getTi()!="") {
					patent.setTiPinyin(ChineseToPinyin.getPinyin(patent.getTi()).toUpperCase());
					System.out.println(patent.getTiPinyin());
					updateNamePinyin.add(patent);
				}
				
			}
		}
		patentDao.saveAll(updateNamePinyin);
		patentDao.flush();

	}
	

}
