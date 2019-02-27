package org.iscas.elastic.admin;

import java.io.IOException;
import java.util.Set;

import org.iscas.elastic.ESClientFactory;
import org.iscas.elastic.ElasticSearchConfig;

public class ElasticSearchManagement {

	public ElasticSearchManagement() {
		// TODO Auto-generated constructor stub
	}
	public static void createElasticSearchIndex(String packageName) throws ClassNotFoundException, IOException{
		Set<String> tables= ParseMysqlTableUtil.findTableName(packageName);
		for(String className:tables) {
			System.out.println(className);
			IndexAdmin admin = new IndexAdmin(ESClientFactory.getClient());
		    
			Class<?> clazz = Class.forName(className);
		    RiverRule rule = RiverRule.extractRule(clazz,ElasticSearchConfig.ES_DOC_TYPE);
		    System.out.println(rule.targetIndex);
		    try {
		    	admin.createIndex(rule);
		    }catch (Exception e) {
				// TODO: handle exception
		    	e.printStackTrace();
		    	
			}
		}
	}
	
	public static void createSingleElasticSearchIndex(String className) throws ClassNotFoundException{
		System.out.println(className);
		IndexAdmin admin = new IndexAdmin(ESClientFactory.getClient());
	    
		Class<?> clazz = Class.forName(className);
	    RiverRule rule = RiverRule.extractRule(clazz,ElasticSearchConfig.ES_DOC_TYPE);
	    try {
	    	admin.createIndex(rule);
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
	    	
		}
	}
	
	public static void deleteElasticSearchIndex(String packageName) throws ClassNotFoundException, IOException{
		Set<String> tables = ParseMysqlTableUtil.findTableName(packageName);
		IndexAdmin admin = new IndexAdmin(ESClientFactory.getClient());

		for(String className:tables) {
			Class<?> clazz = Class.forName(className);
		    RiverRule rule = RiverRule.extractRule(clazz,ElasticSearchConfig.ES_DOC_TYPE);

			admin.deleteIndex(rule.targetIndex);
		}
	}
	
	public static void main(String [] args) throws ClassNotFoundException, IOException{
		ElasticSearchManagement.createElasticSearchIndex("org.iscas.web.entity");
//		ElasticSearchManagement.createSingleElasticSearchIndex("org.iscas.web.entity.Material");
//		ElasticSearchManagement.deleteElasticSearchIndex("org.iscas.web.entity");
	}

}
