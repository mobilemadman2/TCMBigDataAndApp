package org.iscas.utils;


import java.util.ArrayList;
import java.util.List;

import org.iscas.web.dao.ExpertDao;
import org.iscas.web.entity.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpertItemToPinyin {

	@Autowired
	ExpertDao expertDao;
	
	public void GenerateNameCnPinyin() {
		List<Expert> list =  expertDao.findAll();
		List<Expert> updateNamePinyin = new ArrayList<>(); 
		for(Expert Expert:list) {
			if(Expert.getNamePinyin()==null||"".equals(Expert.getNamePinyin())) {
				if(Expert.getName()!=null && Expert.getName()!="") {
					Expert.setNamePinyin(ChineseToPinyin.getPinyin(Expert.getName()).toUpperCase());
					System.out.println(Expert.getNamePinyin());
					updateNamePinyin.add(Expert);
				}
				
			}
		}
		expertDao.saveAll(updateNamePinyin);
		expertDao.flush();

	}
	

}
