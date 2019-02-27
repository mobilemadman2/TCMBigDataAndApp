package org.iscas.utils;


import java.util.ArrayList;
import java.util.List;

import org.iscas.web.dao.MaterialDao;
import org.iscas.web.dao.MaterialDao;
import org.iscas.web.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialItemToPinyin {

	@Autowired
	MaterialDao materialDao;
	
	public void GenerateNameCnPinyin() {
		List<Material> list =  materialDao.findAll();
		List<Material> updateNamePinyin = new ArrayList<>(); 
		for(Material Material:list) {
			if(Material.getNamePinyin()==null||"".equals(Material.getNamePinyin())) {
				if(Material.getNameCn()!=null && Material.getNameCn()!="") {
					Material.setNamePinyin(ChineseToPinyin.getPinyin(Material.getNameCn()).toUpperCase());
					System.out.println(Material.getNamePinyin());
					updateNamePinyin.add(Material);
				}
				
			}
		}
		materialDao.saveAll(updateNamePinyin);
		materialDao.flush();

	}
	

}
