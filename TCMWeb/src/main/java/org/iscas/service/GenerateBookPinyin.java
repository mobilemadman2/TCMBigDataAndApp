package org.iscas.service;


import java.util.ArrayList;
import java.util.List;

import org.iscas.utils.ChineseToPinyin;
import org.iscas.web.dao.BookDao;
import org.iscas.web.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenerateBookPinyin {

	@Autowired
	BookDao bookDao;
	
	public void GeneratePinyin() {
		List<Book> list =  bookDao.findAll();
		List<Book> toupdate = new ArrayList<>(); 
		for(Book book:list) {
			if(book.getNamePinyin()==null||"".equals(book.getNamePinyin())) {
				book.setNamePinyin(ChineseToPinyin.getPinyin(book.getName()).toUpperCase());
				toupdate.add(book);
			}
		}
		
//		for(Book book:toupdate) {
//			System.out.println(book.getName());
//			bookDao.save(book);
//		}
		bookDao.saveAll(toupdate);
		bookDao.flush();
//		System.out.println("haljas;flasd");
		// TODO Auto-generated constructor stub
	}

}
