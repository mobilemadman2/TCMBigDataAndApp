package org.iscas.utils;

import java.util.ArrayList;
import java.util.List;

import org.iscas.web.dao.PaperDao;
import org.iscas.web.entity.Expert;
import org.iscas.web.entity.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperItemToPinyin {
	
	@Autowired
	PaperDao paperDao;
	public void GenerateNameCnPinyin() {
		List<Paper> list =  paperDao.findAll();
		List<Paper> updateNamePinyin = new ArrayList<>(); 
		for(Paper 	Paper:list) {
			if(Paper.getName_pinyin()==null||"".equals(Paper.getName_pinyin())) {
				if(Paper.getPaper_name()!=null && !Paper.getPaper_name().equals("")) {
					String namePinyinFirst=ChineseToPinyin.getPinyin(Paper.getPaper_name()).toUpperCase();
					String reg = "[^A-Z ]";
					String namePinyinResult=namePinyinFirst.replaceAll(reg,"").trim();

					Paper.setName_pinyin(namePinyinResult);
					System.out.println(Paper.getName_pinyin());
					updateNamePinyin.add(Paper);
				}
				
			}
		}
		paperDao.saveAll(updateNamePinyin);
		paperDao.flush();

	
		
	}
	

}
