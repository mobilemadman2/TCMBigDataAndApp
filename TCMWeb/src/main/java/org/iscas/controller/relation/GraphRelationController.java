package org.iscas.controller.relation;

import org.iscas.conf.GraphEntityRelationType;
import org.iscas.controller.BaseController;
import org.iscas.web.service.GraphRelationViewService;
import org.iscas.web.view.RelationCollectionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GraphRelationController extends BaseController{	
	@Autowired
	GraphRelationViewService grvService;
	
	@ResponseBody
	@RequestMapping(value = "/material-related")
	public RelationCollectionView getMedicineEntities(
			@RequestParam String name) {
		System.out.println(name);
		return grvService.GenerateView(GraphEntityRelationType.MaterialRelation, name);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/prescription-related")
	public RelationCollectionView getPrescreptionEntities(
			@RequestParam String name) {
		System.out.println(name);
		return grvService.GenerateView(GraphEntityRelationType.PrescriptionRelation, name);
	}
	
	@ResponseBody
	@RequestMapping(value = "/disease-related")
	public RelationCollectionView getDiseaseEntities(
			@RequestParam String name) {
		System.out.println(name);
		return grvService.GenerateView(GraphEntityRelationType.DiseaseRelation, name);
	}

}
