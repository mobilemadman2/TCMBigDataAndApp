package org.iscas.controller.relation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.elasticsearch.common.xcontent.ToXContent.MapParams;
import org.iscas.conf.EntityRelationType;
import org.iscas.controller.BaseController;
import org.iscas.web.dao.BookDao;
import org.iscas.web.dao.DynastyDao;
import org.iscas.web.dao.relation.finalstate.BookDiseaseRelationDao;
import org.iscas.web.dao.relation.finalstate.BookExpertRelationDao;
import org.iscas.web.dao.relation.finalstate.BookMaterialRelationDao;
import org.iscas.web.dao.relation.finalstate.BookPrescriptionRelationDao;
import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Book;
import org.iscas.web.entity.Dynasty;
import org.iscas.web.entity.Dynasty.DynastyType;
import org.iscas.web.entity.relationship.BookRelation;
import org.iscas.web.entity.relationship.RelationShip;
import org.iscas.web.entity.relationship.finalstate.BookDiseaseRelation;
import org.iscas.web.entity.relationship.finalstate.BookExpertRelation;
import org.iscas.web.entity.relationship.finalstate.BookMaterialRelation;
import org.iscas.web.entity.relationship.finalstate.BookPrescriptionRelation;
import org.iscas.web.service.AutoRelationViewService;
import org.iscas.web.service.RelationViewService;
import org.iscas.web.view.RelationCollection;
import org.iscas.web.view.RelationCollectionView;
import org.iscas.web.view.SortBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
public class RelationController extends BaseController{	
	@Autowired 
	BookDiseaseRelationDao bookDiseaseRelationDao;
	
	@Autowired
	BookMaterialRelationDao bookMaterialRelationDao;
	
	@Autowired
	BookExpertRelationDao bookExpertRelationDao;
	
	@Autowired
	BookPrescriptionRelationDao bookPrescriptionRelationDao;
	
	@Autowired
	RelationViewService relationViewService;
	
	@Autowired
	AutoRelationViewService autoRelationViewService;
	
	@ResponseBody
	@RequestMapping(value = "/book-entity")
	public RelationCollectionView getBookEntities(
			@RequestParam String bookname,
			@RequestParam String path) {
		return relationViewService.GenerateView(bookname, path);
	}
	
	@ResponseBody
	@RequestMapping(value = "/all-book-entities")
	public RelationCollectionView getAllBookEntities(
			@RequestParam String bookname) {
		return relationViewService.GenerateAllBookView(bookname);
	}
	
	@ResponseBody
	@RequestMapping(value = "/book-entity-single")
	public RelationCollectionView getSingleBookEntities(
			@RequestParam String bookname,
			@RequestParam String path,
			@RequestParam String viewtype) {
		return relationViewService.GenerateSingleView(bookname, path, viewtype);
	}
	
	@ResponseBody
	@RequestMapping(value = "/book-entity-update", method=RequestMethod.POST)
	public String updateBookEntity(
			@RequestParam String bookname,
			@RequestParam String path,
			@RequestParam String entitykey,
			@RequestParam String entityvalue,
			@RequestParam String newvalue) {
		System.out.println(bookname+"\t"+path+"\t"+entitykey+"\t"+entityvalue+"\t"+newvalue);
		
		relationViewService.update(bookname, path, entitykey, entityvalue, newvalue);
		return "ok";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/book-entity-delete", method=RequestMethod.POST)
	public String deleteBookEntity(
			@RequestParam String bookname,
			@RequestParam String path,
			@RequestParam String entitykey,
			@RequestParam String entityvalue) {
		System.out.println(bookname+"\t"+path+"\t"+entitykey+"\t"+entityvalue);
		
		relationViewService.delete(bookname, path, entitykey, entityvalue);
		return "ok";
	}
	

	  
	  @RequestMapping(value = "/relation/interactive", method = RequestMethod.GET)
	  public String interactive_modify(
			  @RequestParam String entitykey,
			  @RequestParam String book,
			  @RequestParam String path,
			  ModelMap map) {
		  map.addAttribute("bookname", book);
		  map.addAttribute("viewtype", entitykey);
		  map.addAttribute("path",path);
	    return "classic-books/entity-annotation";
	  }
	  
	  
	  @ResponseBody
		@RequestMapping(value = "/auto-book-entity-single")
		public RelationCollectionView getAutoBookEntities(
				@RequestParam String bookname,
				@RequestParam String path,
				@RequestParam String viewtype) {
		  System.out.println("auto-book-entity-single");
			return autoRelationViewService.GenerateSingleView(bookname, path, viewtype);
		}
	  
	  
	  
		@ResponseBody
		@RequestMapping(value = "/auto-all-book-entities")
		public RelationCollectionView getAutoAllBookEntities(
				@RequestParam String bookname) {
			  System.out.println("auto-all-book-entities");
			return autoRelationViewService.GenerateAllView(bookname);
		}
		
		
		
	  @ResponseBody
	  @Transactional
	@RequestMapping(value = "/book-entity-save")
		public String saveBookEntities(
				@RequestParam String bookname,
				@RequestParam String path,
				@RequestParam String entities) {
		  JSONObject jsonObject = JSONObject.parseObject(entities);
			for (String key : jsonObject.keySet()) {
				JSONArray array = jsonObject.getJSONArray(key);
				
				
				if(EntityRelationType.BookDiseaseRelation.equals(key)) {
					bookDiseaseRelationDao.deleteByBaseEntityAndPath(bookname, path);
					List<BookDiseaseRelation> disList = new ArrayList<>();
					for (int i = 0; i < array.size(); i++) {
						JSONObject obj = array.getJSONObject(i);
						System.out.println(obj.getString("relatedEntity"));
						BookDiseaseRelation rs = new BookDiseaseRelation();
						rs.setRelatedEntity(obj.getString("relatedEntity"));
						rs.setBaseEntity(bookname);
						rs.setPath(path);
						disList.add(rs);
					}
					bookDiseaseRelationDao.saveAll(disList);
				}else if (EntityRelationType.BookExpertRelation.equals(key)) {
					bookExpertRelationDao.deleteByBaseEntityAndPath(bookname, path);
					List<BookExpertRelation> exList = new ArrayList<>();
					for (int i = 0; i < array.size(); i++) {
						JSONObject obj = array.getJSONObject(i);
						System.out.println(obj.getString("relatedEntity"));
						BookExpertRelation rs = new BookExpertRelation();
						rs.setRelatedEntity(obj.getString("relatedEntity"));
						rs.setBaseEntity(bookname);
						rs.setPath(path);
						exList.add(rs);
					}
//					bookExpertRelationDao.saveAll(list);
					bookExpertRelationDao.saveAll(exList);
				}else if (EntityRelationType.BookMaterialRelation.equals(key)) {
					bookMaterialRelationDao.deleteByBaseEntityAndPath(bookname, path);
					List<BookMaterialRelation> disList = new ArrayList<>();
					for (int i = 0; i < array.size(); i++) {
						JSONObject obj = array.getJSONObject(i);
						System.out.println(obj.getString("relatedEntity"));
						BookMaterialRelation rs = new BookMaterialRelation();
						rs.setRelatedEntity(obj.getString("relatedEntity"));
						rs.setBaseEntity(bookname);
						rs.setPath(path);
						disList.add(rs);
					}
					bookMaterialRelationDao.saveAll(disList);
				}else if (EntityRelationType.BookPrescriptionRelation.equals(key)) {
					bookPrescriptionRelationDao.deleteByBaseEntityAndPath(bookname, path);
					List<BookPrescriptionRelation> disList = new ArrayList<>();
					for (int i = 0; i < array.size(); i++) {
						JSONObject obj = array.getJSONObject(i);
						System.out.println(obj.getString("relatedEntity"));
						BookPrescriptionRelation rs = new BookPrescriptionRelation();
						rs.setRelatedEntity(obj.getString("relatedEntity"));
						rs.setBaseEntity(bookname);
						rs.setPath(path);
						disList.add(rs);
					}
					bookPrescriptionRelationDao.saveAll(disList);
				}
			}
		  System.out.println(bookname+"\n"+path+"\n"+entities);
			return "";
		}
	  

}
