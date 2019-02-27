package org.iscas.utils;


import java.util.ArrayList;
import java.util.List;

import org.iscas.web.dao.PrescriptionDao;
import org.iscas.web.dao.PrescriptionDao;
import org.iscas.web.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionItemToPinyin {

	@Autowired
	PrescriptionDao prescriptionDao;
	
	public void GenerateNameCnPinyin() {
		List<Prescription> list =  prescriptionDao.findAll();
		List<Prescription> updateNamePinyin = new ArrayList<>(); 
		for(Prescription Prescription:list) {
			if(Prescription.getNamePinyin()==null||"".equals(Prescription.getNamePinyin())) {
				if(Prescription.getName()!=null && Prescription.getName()!="") {
					Prescription.setNamePinyin(ChineseToPinyin.getPinyin(Prescription.getName()).toUpperCase());
					System.out.println(Prescription.getNamePinyin());
					updateNamePinyin.add(Prescription);
				}
				
			}
		}
		prescriptionDao.saveAll(updateNamePinyin);
		prescriptionDao.flush();

	}
	

}
