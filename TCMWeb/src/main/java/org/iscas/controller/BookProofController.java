package org.iscas.controller;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.sql.Date;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.servlet.SessionTrackingMode;

import org.apache.commons.io.IOUtils;
import org.elasticsearch.search.aggregations.bucket.significant.SignificantStringTerms;
import org.iscas.web.dao.BookDao;
import org.iscas.web.dao.BookProofDao;
import org.iscas.web.dao.DynastyDao;
import org.iscas.web.dao.RuleDao;
import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Book;
import org.iscas.web.entity.BookProof;
import org.iscas.web.entity.Dynasty;
import org.iscas.web.entity.Dynasty.DynastyType;
import org.iscas.web.entity.rule;
import org.iscas.web.view.AlphabetBooks;
import org.iscas.web.view.DynastyBooks;
import org.iscas.web.view.SortBooks;
import org.neo4j.driver.internal.InternalPath.SelfContainedSegment;
import org.neo4j.graphmatching.filter.CompareExpression;
import org.neo4j.register.Register.Int;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;
import scala.annotation.varargs;
import scala.reflect.internal.Trees.This;

@Controller
public class BookProofController extends BaseController{	
	@Autowired 
	BookDao bookDao;
	
	@Autowired 
	BookProofDao bookProofDao;
	
	@Autowired
	DynastyDao dynastyDao;
	
	@Autowired
	RuleDao ruleDao;
	
	private String htmlcontent = "";

	
	//古籍书原始书籍和校对书籍，差别在于原始书籍old=0,校对书籍old=1
	@RequestMapping(value = "/proof", method = RequestMethod.GET)
	public String origin(@RequestParam(value = "name", required = false)  String name,
			@RequestParam(value = "old", required = false)  int old,
			ModelMap model) {
		//map.addAttribute("keyword", keywords);
		System.out.println("/proof/name,old");
		model.addAttribute("bookname", name);
		model.addAttribute("old",old);
//		int id = bookProofDao.findIdByName("sdfsdfsd");
		return "proof/proof";
	}
	//古籍书校对页面(Home)
	@RequestMapping(value = "/proof-home", method = RequestMethod.GET)
	public String proofHome(ModelMap model) {
		List<Book> book_list = bookDao.findAll();
		model.addAttribute("book_list", book_list);
		System.out.println("proof-name");
		return "proof/proof-home";
	}
	
	//古籍设置界面
	@RequestMapping(value = "/proof/setting", method = RequestMethod.GET)
	public String setting(ModelMap model) {
		model.addAttribute("update", -1);
		return "proof/setting";
	}
	
	
	
	//获取书籍的列表信息
	@ResponseBody
	@RequestMapping(value = "/proof/listinfo-json", method = RequestMethod.POST)
	public PageDto<BookProof> showBookProof(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
		//保持数据库中的数据和json文件一致
		String path = "classpath:static/book-holder/";
		File file = ResourceUtils.getFile(path); 
		File[] array = file.listFiles();   
//		for(int i=0;i<array.length;i++) {
//			if(array[i].isFile()) {
//				System.out.println(array[i].getName());
//			}
//		}
		
		//List<Book> list = bookDao.findAll();
		List<String> file_name = new ArrayList();
		//将书籍的名字按照字母顺序来排
		for(int i=0;i<array.length;i++) {
			String name = array[i].getName().substring(0,array[i].getName().lastIndexOf('.'));
			file_name.add(name);
		}
		Collections.sort(file_name,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Collator.getInstance(Locale.CHINESE).compare(o1, o2);
			}
		});
		
		
		System.out.println("ddddddddddd");
		List<BookProof> result = new ArrayList<BookProof>();
		Long id = (long) 1;
		for(int i= 0;i<array.length;i++) {
			BookProof temp = new BookProof();
			//String name = array[i].getName().substring(0,array[i].getName().lastIndexOf('.'));
			String name = file_name.get(i);
			//System.out.println(name);
			//填写更新时间
			Date upate_time = null;
			String time = " ";
			//List<BookProof> temp1 = bookProofDao.findByName(name);
			if (bookProofDao.findTimeListByName(name).size()!=0) {
				upate_time = new Date(bookProofDao.findTimeListByName(name).get(0).getTime());
				//System.out.println(bookProofDao.findTimeByName(name).toString());
				SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				time = format0.format(upate_time);
			}
			
			//获取json文件大小
			String path_json = "static/book-holder/";	
			path_json = path_json +name+".json";
			System.out.println(path_json);
			Resource resource = new ClassPathResource(path_json);
			int book_size = (int)resource.contentLength();
			System.out.println("书本长度");
			System.out.println(book_size);
			String length_size = changeSize(book_size);
			System.out.println(length_size);
			//temp.setUpdateAt(upate_time);
			temp.setTime_string(time);
			temp.setBookName(name);
			temp.setId(id);
			temp.setOrigin("原始版本"+"("+length_size+")");
			temp.setModify("矫正版本");
			List<Book> find_content = bookDao.findByName(name);
			//System.out.println(find_content);
			if(find_content.size() == 0) {
				temp.setAuthor_name("");
				temp.setDynasty("");
			}
			else {
				temp.setAuthor_name(find_content.get(0).getAuthor()+"("+find_content.get(0).getDynasty().getName()+")");
				//temp.setDynasty(find_content.get(0).getDynasty().getName());
			}
			result.add(temp);
			id = id + 1;
		}
		//System.out.println(result.size());
		return PageDto.ofList(result, result.size(), pageNumber, pageSize);
	}
	
	public int Compare(String name1,String name2) {
		return Collator.getInstance(Locale.CHINESE).compare(name1, name2);
	}
	
	
	
	//获取书籍的列表信息
	@ResponseBody
	@RequestMapping(value = "/proof/listinfo", method = RequestMethod.POST)
	public PageDto<BookProof> showMedicalCase(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Book> list = bookDao.findAll();
		System.out.println("ddddddddddd");
		List<BookProof> result = new ArrayList<BookProof>();
		for(int i= 0;i<list.size();i++) {
			BookProof temp = new BookProof();
			temp.setBookName(list.get(i).getName());
			temp.setId(list.get(i).getId());
			temp.setOrigin("原始版本");
			temp.setModify("矫正版本");
			temp.setAuthor_name(list.get(i).getAuthor());
			temp.setDynasty(list.get(i).getDynasty().getName());
			result.add(temp);
		}
		System.out.println(result.size());
		return PageDto.ofList(result, result.size(), pageNumber, pageSize);
	}
		

	//获取修改之后的书籍的相关信息
	@ResponseBody
	@RequestMapping(value="/proof/bp-findbook",method = RequestMethod.GET)
	public BookProof findBook(String bookname,int old) throws IOException{
		System.out.println(bookname);
		BookProof book_proof = new BookProof();
		List<Book> find_book = bookDao.findByName(bookname); 
		String content_book = bookProofDao.findContentByName(bookname);
		System.out.println(find_book);
		Date upate_time = null;
		String dynasty = "";
		if (find_book.size() == 0) {
			dynasty = "";
			book_proof.setAuthor_name("");
		}
		else {
		dynasty = find_book.get(0).getDynasty().getName();
		book_proof.setAuthor_name(find_book.get(0).getAuthor());
		}
		
		
		String length_size = null;
		int book_size = 0;
		String time = " ";
		//修改之后的文本
		if(old == 1) {
			if (bookProofDao.findTimeListByName(bookname).size()!=0) {
				upate_time = new Date(bookProofDao.findTimeListByName(bookname).get(0).getTime());
				//System.out.println(bookProofDao.findTimeByName(name).toString());
				SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				time = format0.format(upate_time);
			}
//			System.out.println(find_book.get(0).getId());
			System.out.println(dynasty);
			//set proof book
			System.out.println("一开始获取的文件长度");
//			System.out.println(content_book.length());
			//判断是否在修改之后的文件中存在
			if(content_book==null) {
				Resource resource = new ClassPathResource("/static/book-holder/"+bookname+".json");
				content_book =  IOUtils.toString(resource.getInputStream(), Charset.forName("UTF-8"));
				content_book = this.readjson(content_book);
			}
			System.out.println("json 文件长度");
			System.out.println(content_book.length());
			
			System.out.println("json 更新时间");
			System.out.println(upate_time);
			System.out.println("最后的文件长度");
			System.out.println(content_book.length());
			
			//展示到界面的时候，应用rules规则
			List<rule> result_rules = ruleDao.findAll();
			String rules_string = result_rules.get(result_rules.size()-1).getRules();
			System.out.println(rules_string);
			String iterms_rule[]= rules_string.split(";");
//			System.out.println(iterms_rule[0]);
			String ddd = "\\r图\\pt161a3.bmp\\r\\r图\\pt161a4.bmp\\r\\r图\\pt161a5.bmp\\r\\r图\\pt161a6.bmp\\r分隔开\\鲈鱼 \\\\pj490.bmp\\\\鲈鱼 \\\\pj490a.bmp\\";
			for(int i=0;i<iterms_rule.length;i++) {
				if(!iterms_rule[i].contains("=>")) {
					String regex = iterms_rule[i].replace(" ", "");
					if(regex.charAt(0)=='/' && regex.charAt(regex.length()-1)=='/') {
						System.out.println("没有=>符号的");
						regex = regex.substring(1, regex.length()-1);
						System.out.println(regex);
						ddd = ddd.replaceAll(regex, "");
						content_book = content_book.replaceAll(regex,"");
					}
					else {
						content_book = content_book.replace(regex,"");
						ddd = ddd.replace(regex, "");
					}
				}
				else {
					String sub_iterms_rules[] = iterms_rule[i].split("=>");
					System.out.println("有=>的");
					String regex = sub_iterms_rules[0].replace(" ", "");
					System.out.println(regex);
					System.out.println(sub_iterms_rules[1]);
					if(regex.charAt(0)=='/' && regex.charAt(regex.length()-1)=='/') {
						System.out.println("有=>的去除正则表达式两边的符号");
						regex = regex.substring(1,regex.length()-1);
						if(sub_iterms_rules[1].length() == 2) {
							content_book = content_book.replaceAll(regex,"");
							ddd = ddd.replaceAll(regex,"");
						}
						else {
							content_book = content_book.replaceAll(regex,sub_iterms_rules[1].replace("\"", ""));
							ddd = ddd.replaceAll(regex,"");
						}
					}
					else {
						if(sub_iterms_rules[1].length() == 2) {
							content_book = content_book.replace(regex,"");
							ddd = ddd.replaceAll(regex,"");
						}
						else {
							content_book = content_book.replace(regex,sub_iterms_rules[1].replace("\"", ""));
							ddd = ddd.replaceAll(regex,"");
						}
					}
					
				}
			}
			
			System.out.println(ddd);
			//长度只能是字符串的长度哈,只是完整的内容，没有类似json文件的标签啥的。
			book_size = content_book.length();
			
		}
		else {
			//原始文本
			Resource resource = new ClassPathResource("/static/book-holder/"+bookname+".json");
			content_book =  IOUtils.toString(resource.getInputStream(), Charset.forName("UTF-8"));
			System.out.println("原始版本");
			//要从这边修改json文件的大小的哈.
			book_size = (int)resource.contentLength();
			//System.out.println(content_book.length());
			//删除了一些没有必要的字符，保留主要内容。
			content_book = this.readjson(content_book);
			//book_size = content_book.length();
		}
		
		length_size = changeSize(book_size);
		//计算修改之后的文本大小
		
		
		
		
		//System.out.println(content_book);
		book_proof.setDynasty(dynasty);
		book_proof.setContent(content_book);
		book_proof.setBookName(bookname);
		//book_proof.setUpdateAt(upate_time);
		book_proof.setTime_string(time);
		book_proof.setBook_size(length_size);
		return book_proof;
	}
	
	public String changeSize(int book_size) {
		String length_size = null;
		System.out.println(book_size);
		int size = book_size;
		if (size < 1024) {
			length_size =  String.valueOf(size) + "B";
		} else {
			size = size / 1024;
		}
		if (size < 1024 && length_size ==null){
			length_size = String.valueOf(size) + "KB";
		} else {
			size = size / 1024;
		}
		if (size < 1024 && length_size == null) {
			size = size * 100;
			length_size = String.valueOf((size / 100)) + "."+ String.valueOf((size % 100)) + "MB";
		}
		return length_size;
	}
	
	public String readjson(String json_data){
		Object json = new JSONTokener(json_data).nextValue();
		JSONObject jsonObject = null;
		if(json instanceof JSONArray){
			JSONArray arratObject = (JSONArray)json;
			//System.out.println("array");
			//System.out.println(json_data.substring(0, 30));
		    for (int t=0; t<arratObject.size(); t++){
				this.readjson(arratObject.getString(t));
			}
		}else {
			jsonObject = (JSONObject)json;
			//System.out.println("json object");
			//System.out.println(json_data.substring(0,30));
			
			if(jsonObject.containsKey("book_title")){
				//System.out.println("book_title");
				System.out.println("执行了一次");
				this.htmlcontent += "<p style=\"text-align:center;\"><span style=\"font-size:20px\"><strong>" + jsonObject.getString("book_title") +"</strong></span></p>";
				this.readjson(jsonObject.getString("content"));
			}
			else if(jsonObject.containsKey("type") &&  jsonObject.getString("type").equals("section")){
				//System.out.println("section");
				this.htmlcontent += "<br /><p><strong>" + jsonObject.getString("title") + "</strong></p>";
				this.readjson(jsonObject.getString("content"));
			}
			else if(jsonObject.containsKey("type") &&  jsonObject.getString("type").equals("paragraph")){
				//System.out.println("paragraph");
				this.htmlcontent += "<p>" + "       " + jsonObject.getString("detail") + "</p>";
			}
			else {
				System.out.println("没人要");
				//System.out.println(jsonObject.containsKey("type"));
				//System.out.println(jsonObject.getString("type").equals("section"));
			}
			
		}
		//System.out.println(this.htmlcontent);
		
		return this.htmlcontent;
	}
	
	//获取矫正过的书籍的内容
	@ResponseBody
	@RequestMapping(value="/proof/bp-findbookcontent",method = RequestMethod.GET)
	public String findBookContent(String bookname){
		System.out.println(bookname);
		return bookProofDao.findContentByName(bookname);
	}
	
	//保存矫正过的书籍的内容
	@RequestMapping(value="/proof/save_file",method = RequestMethod.POST,produces="text/plain")
	@ResponseBody
	public String saveBook(@RequestBody BookProof book_proof){
		System.out.println("保存开始了");
		System.out.println(book_proof.getBookName());
		String book_name = book_proof.getBookName();
		String modify_data = book_proof.getContent();
//		int id = bookProofDao.findIdByName(book_name);
		BookProof book_search = bookProofDao.findBookContentByName(book_name);
		int id = -1;
		//新添加一本书籍的时候，创建一个id
		if(book_search == null) {
			int max_id = -1;
			List<BookProof> all_book_proof = bookProofDao.findAll();
			for(int i = 0;i<all_book_proof.size();i++) {
				if(max_id < all_book_proof.get(i).getId()) {
					max_id =  Integer.parseInt(String.valueOf(all_book_proof.get(i).getId()));
				}
			}
			
			id = max_id + 1;
		}
		else {
			id = Integer.parseInt(String.valueOf(book_search.getId()));
		}
		//新的一本书籍的情况
//		if(id == null) {
//			
//		}
//		System.out.println(book_name);
//		System.out.println(modify_data);
//		//替换原来的数据,并且更新原来的时间
		java.util.Date now = new java.util.Date(); 
		int temp = bookProofDao.updateDataByContent(book_name, modify_data,now,id);
		System.out.println("temp");
		System.out.println(temp);
		//UPDATE runoob_tbl SET runoob_title='学习 C++' WHERE runoob_id=3;
		return "ddd";
	}
	
	
	//保存古籍规则
	@RequestMapping(value = "/proof/save-rule", method = RequestMethod.GET)
	public String save_rule(ModelMap model,@RequestParam(value = "reg_rules_str", required = false)  String reg_rules_strs,@RequestParam(value = "chk_box", required = false)  String chk_box) {
		System.out.println("规则consoller");
		System.out.println(reg_rules_strs);
		System.out.println(chk_box);
		
		if(chk_box!=null) {
			//将大写转化为小写
			String result = "";
			for(int i=0;i<reg_rules_strs.length();i++) {
				if(reg_rules_strs.charAt(i)<='Z' && reg_rules_strs.charAt(i)>='A') {
					result += (char) (reg_rules_strs.charAt(i)+32);
				}
				else {
					result += reg_rules_strs.charAt(i);
				}
			}
			reg_rules_strs = result;
		}
		
		System.out.println(reg_rules_strs);
		//保存规则
		int is_success = ruleDao.updateRules(reg_rules_strs,1);
		System.out.println("fgfgfg");
		System.out.println(is_success);
		List<rule> result = ruleDao.findAll();
		System.out.println(result.size());
		String rules_string = result.get(result.size()-1).getRules();
		model.addAttribute("update", is_success);
		return "proof/setting";
	}
	
	//获取数据库中规则
	@ResponseBody
	@RequestMapping(value="/proof/get_rules",method = RequestMethod.GET)
	public rule getRules(){
		List<rule> result = ruleDao.findAll();
		System.out.println(result.size());
		String rules_string = result.get(result.size()-1).getRules();
		System.out.println(rules_string);
		System.out.println("dddddddfffffff");
		rule rule_last = new rule();
		rule_last.setRules(rules_string);
		return rule_last;
	}
	
	//获取数据库中规则
	@ResponseBody
	@RequestMapping(value="/proof/json-file-number",method = RequestMethod.GET)
	public int json_file_size() throws FileNotFoundException{
		String path = "classpath:static/book-holder/";
		File file = ResourceUtils.getFile(path); 
		File[] array = file.listFiles();   
		return array.length;
	}
	
	//获取文件大小
	public static long getFileSize(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return -1;
        }
        return file.length();
    }
}
