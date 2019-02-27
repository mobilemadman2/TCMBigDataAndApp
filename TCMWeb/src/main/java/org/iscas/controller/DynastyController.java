package org.iscas.controller;

import java.util.ArrayList;
import java.util.List;

import org.iscas.web.dao.BookDao;
import org.iscas.web.dao.DynastyDao;
import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Book;
import org.iscas.web.entity.Dynasty;
import org.iscas.web.entity.Dynasty.DynastyType;
import org.iscas.web.view.DynastyBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DynastyController extends BaseController{

	@Autowired
	DynastyDao dynastyDao;
	
	@Autowired 
	BookDao bookDao;
	
	@ResponseBody
	@RequestMapping(value = "/dynasty", method = RequestMethod.GET)
	public List<DynastyBooks> getDynasties() {
		Sort sort = new Sort(Sort.Direction.ASC, "startTime");
//		List<Dynasty> list =  dynastyDao.findAll(sort);
		//list = dynastyDao.findByType(DynastyType.MAIN);
		List<Dynasty> list = dynastyDao.findByType(DynastyType.MAIN,sort);
		
		List<DynastyBooks> dynastyBooks = new ArrayList<>();
		for(Dynasty dynasty: list) {
			DynastyBooks dBooks = new DynastyBooks();
			List<String> bookName = new ArrayList<>();
			
			for(Book book:bookDao.findByDynastyId(dynasty.getId())) {
				bookName.add(book.getName());
			}
			dBooks.setDynasty(dynasty);
			dBooks.setBooks(bookName);
			if(bookName.size()>0)
				dynastyBooks.add(dBooks);
		}
		return dynastyBooks;
	}

}
