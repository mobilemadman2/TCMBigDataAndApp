package org.iscas.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.iscas.web.dao.BookEntityDao;
import org.iscas.web.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookEntityController extends BaseController {
	
	Date date = new Date();
	Timestamp timeStamp = new Timestamp(date.getTime());
	
	@Autowired 
	BookEntityDao bookEntityDao;

	@RequestMapping(value = "/book/book_entity", method = RequestMethod.GET)
	public void getDynasties() {
		List<String> books = bookEntityDao.findAllMaterialBookByName();
		
		//List<String> books = bookEntityDao.findAllPrescriptionBookByName();
		
		for(int i = 0; i < books.size(); i++){
			
			List<BookEntity> allDiseaseEntity = bookEntityDao.findAllPrescriptionEntityByName(books.get(i));
			List<BookEntity> diseaseEntity = bookEntityDao.findPrescriptionEntityByName(books.get(i));
			
			List<BookEntity> entity = new ArrayList<BookEntity>();
			
			for(int j = 0; j < allDiseaseEntity.size(); j++){
				for(int k = 0; k < diseaseEntity.size(); k++){
					if(diseaseEntity.get(k).getRelatedEntity().equals(allDiseaseEntity.get(j).getRelatedEntity())){
						entity.add(allDiseaseEntity.get(j));
						break;
					}
				}
			}
			int flag = 0;
			for(int m = 0; m < entity.size(); m++){
				flag = bookEntityDao.insertMaterialEntity(entity.get(m).getBaseEntity(), entity.get(m).getRelatedEntity(), entity.get(m).getParagraph(), entity.get(m).getPath(), entity.get(m).getPosition(),timeStamp,timeStamp);
				//flag = bookEntityDao.insertPrescriptionEntity(entity.get(m).getBaseEntity(), entity.get(m).getRelatedEntity(), entity.get(m).getParagraph(), entity.get(m).getPath(), entity.get(m).getPosition(),timeStamp,timeStamp);
			}
//			System.out.println("4444444444    "+flag);
		}
	}
}
