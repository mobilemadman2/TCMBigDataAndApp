package org.iscas.web.service;

import java.util.List;

import org.iscas.web.dao.PaperDao;
import org.iscas.web.entity.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaperService {
	@Autowired
	private PaperDao paperDao;
	
	public List<Paper>  getPaperByNameCn(String keywords) {
		  List<Paper> paper = paperDao.findByNameOrAbstractsContaining(keywords,keywords);
		  
		  return paper;
	  }

}
