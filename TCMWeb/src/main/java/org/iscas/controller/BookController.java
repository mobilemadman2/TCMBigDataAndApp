package org.iscas.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.iscas.web.dao.BookDao;
import org.iscas.web.dao.BookProofDao;
import org.iscas.web.dao.DynastyDao;
import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Book;
import org.iscas.web.entity.BookProof;
import org.iscas.web.entity.Dynasty;
import org.iscas.web.entity.Dynasty.DynastyType;
import org.iscas.web.view.AlphabetBooks;
import org.iscas.web.view.DynastyBooks;
import org.iscas.web.view.SortBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

@Controller
public class BookController extends BaseController{	
	@Autowired 
	BookDao bookDao;
	
	@Autowired 
	BookProofDao book_proofDao;
	
	@Autowired
	DynastyDao dynastyDao;
	
	private String book_name = "";
	private String bookContent = "";
	

	@RequestMapping(value = "/getbook", method = RequestMethod.GET)
	public String getDynasties(@RequestParam String name,
			ModelMap model
			) {
		
		model.addAttribute("bookname", name);
		
		book_name = name;
		
		
		List<BookProof> bpList = book_proofDao.findByName(name);
		
		if(bpList.size() != 0){
			bookContent = bpList.get(0).getContent();
			
			int start = bookContent.indexOf("</strong></p>");
			int end = bookContent.indexOf("<p><strong>",start+13);
			
			String content = "";
			if(end>0) content = bookContent.substring(start+13, end);
			else content = bookContent.substring(start+13);
			
			//判断是否包含汉字
			Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
	        Matcher m = p.matcher(content);
	        if (!m.find()) {
	        	start = bookContent.indexOf("</strong></p>",end);
	    		end = bookContent.indexOf("<p><strong>",start+13);
	    		content = bookContent.substring(start+13, end);
	        }
		
			model.addAttribute("bookcontent", content);
		}else{
			model.addAttribute("bookcontent", "");
		}
		
		return "classic-books/bookcontent";
	}
	
	@RequestMapping(value = "/book-entities", method = RequestMethod.GET)
	public String getAllEntities(@RequestParam String name,
			ModelMap model
			) {
		model.addAttribute("bookname", name);
		return "classic-books/book-entity-annotation";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/book/book_proof", method = RequestMethod.GET)
	public List<String> getBook_Proof(@RequestParam(value = "title", required = false) String title) throws UnsupportedEncodingException {
		
		List<String> c = new ArrayList<String>();
		String content = "";
		int start = 0, startTitle, end;
		
		if(title.contains("-")){
			String[] titleList = title.split("-");
			startTitle = bookContent.indexOf(titleList[0]);
			start = bookContent.indexOf(titleList[1],startTitle);
			
			while(start != -1){
				//判断是否为标题
				String isTitle = bookContent.substring(start-11, start);
				if(isTitle.equals("<p><strong>")){
					end = bookContent.indexOf("<p><strong>",start+titleList[1].length()+13);
					
					if(start != 0 && end == -1){
						content = bookContent.substring(start+titleList[1].length()+13);
					}else{
						content = bookContent.substring(start+titleList[1].length()+13, end);
					}
					break;
				}else{
					start = bookContent.indexOf(titleList[1],start+1);
				}
			}
		}else{
			start = bookContent.indexOf(title);
			while(start != -1){
				String isTitle = bookContent.substring(start-11, start);
				if(isTitle.equals("<p><strong>")){
					end = bookContent.indexOf("<p><strong>",start+title.length()+13);
					
					if(start != 0 && end == -1){
						content = bookContent.substring(start+title.length()+13);
					}else{
						content = bookContent.substring(start+title.length()+13, end);
					}
					break;
				}else{
					start = bookContent.indexOf(title, start+1);
				}
			}
		}
		
		c.add(content);
//		model.addAttribute("bookcontent", content);
		return c;
	}
	
	@ResponseBody
	@RequestMapping(value = "/book/dynasty-order", method = RequestMethod.GET)
	public List<SortBooks> getDynasties() {
		Sort sort = new Sort(Sort.Direction.ASC, "startTime");
		//		List<Dynasty> list =  dynastyDao.findAll(sort);
		//list = dynastyDao.findByType(DynastyType.MAIN);
		List<Dynasty> list = dynastyDao.findByType(DynastyType.MAIN,sort);
		
		List<SortBooks> dynastyBooks = new ArrayList<>();
		for(Dynasty dynasty: list) {
			SortBooks dBooks = new SortBooks();
			List<String> bookName = new ArrayList<>();
			
			for(Book book:bookDao.findByDynastyId(dynasty.getId())) {
				bookName.add(book.getName());
			}
			dBooks.setName(dynasty.getName());
			dBooks.setBooks(bookName);
			if(bookName.size()>0)
				dynastyBooks.add(dBooks);
		}
		
		return dynastyBooks;
	}
	
	@ResponseBody
	@RequestMapping(value = "/book/alphabet-order")
	public List<SortBooks> getAlphabets() {
		List<SortBooks> alphabetBooks = new ArrayList<>();
		char curr_char = 'A';
		List<Book> booklist = bookDao.findAllOrderByNamePinyinAsc();
		int index = 0;
		while(index<booklist.size()&&curr_char<='Z'){
			if(curr_char==booklist.get(index).getNamePinyin().charAt(0)) {
				SortBooks aBooks = new SortBooks();
				List<String> bookName = new ArrayList<>(); 
				aBooks.setName(curr_char+"");
				
				while(index<booklist.size()&&curr_char==booklist.get(index).getNamePinyin().charAt(0)) {
					bookName.add(booklist.get(index).getName());
					index++;
				}
				aBooks.setBooks(bookName);
				alphabetBooks.add(aBooks);
				
			}
			curr_char++;
		}
		return alphabetBooks;
	}
	
	@RequestMapping(value="/book/search.html")
	public String bookSearch(String keywords, ModelMap map){
		map.addAttribute("keyword", keywords);
		
		return "classic-books/book-search";
	}
	
	@ResponseBody
	@RequestMapping(value="/book/findbook")
	public List<Book> findBook(String bookname){
		return bookDao.findByName(bookname);
	}

}
