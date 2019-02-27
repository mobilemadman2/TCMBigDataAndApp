package org.iscas.controller.relation;

import org.iscas.controller.BaseController;
import org.iscas.graph.nodeentity.Disease;
import org.iscas.graph.nodeentity.MedMaterial;
import org.iscas.graph.repository.DiseaseRepository;
import org.iscas.graph.repository.MedMaterialRepository;
import org.iscas.web.service.MaterialRelationViewService;
import org.iscas.web.view.RelationCollectionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MaterialRelationController extends BaseController{	
	
	
	@Autowired
	MaterialRelationViewService relationViewService;
	
	@Autowired
	DiseaseRepository dr;
	
	@Autowired
	MedMaterialRepository mmr;
	
	@ResponseBody
	@RequestMapping(value = "/material-entity")
	public RelationCollectionView getBookEntities(
			@RequestParam Long baseId) {
		return relationViewService.GenerateView(baseId);
	}
	
	@ResponseBody
	@RequestMapping(value="/neo")
	public String getNeo() {
		for(Disease d:dr.findAll()) {
			System.out.println(d.getName());
		}
		
		
		for(MedMaterial mm:mmr.findAll()) {
			System.out.println(mm.getName());
		}
		return "yes";
	}
	


}
