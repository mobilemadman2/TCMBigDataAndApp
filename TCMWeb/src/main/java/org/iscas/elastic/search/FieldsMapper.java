package org.iscas.elastic.search;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.iscas.elastic.ElasticSearchConfig;
import org.iscas.elastic.admin.RiverRule;
import org.iscas.elastic.admin.RiverRule.IndexedField;
import org.iscas.elastic.query.ESQueryParams;


public class FieldsMapper {
	public static Map<String, List<String> > mapper = null;
	public static Map<String, ESQueryParams > xmlmapper = null;
	
	public static Map<String, ESQueryParams> getFieldsMapperFromXml() throws DocumentException{
		if(xmlmapper!=null) return xmlmapper;
		
		if(xmlmapper==null)	xmlmapper = new HashMap<>();
		SAXReader reader = new SAXReader();
        InputStream is = FieldsMapper.class.getClassLoader().getResourceAsStream("es-search-config.xml");
		Document document = reader.read(is);
		
		Element root = document.getRootElement();
		List<Element> nodes = root.elements("search");
		
		//traverse nodes
		for (Element elm:nodes) {
			ESQueryParams queryParams = new ESQueryParams(elm.attributeValue("index"));
		      System.out.println("Parsing "+elm.getName()+" targetIndex:"+elm.attributeValue("index"));
		      //parse fields
		      List<Element> fields = elm.element("fields").elements("field");
		      for(Element field: fields) {
		    	  Float weight = field.attributeValue("weight")!=null?Float.parseFloat(field.attributeValue("weight")):1.0f;
		    	  queryParams.appendESFiled(new ESQueryParams.ESField(field.getStringValue().trim(), weight));
//		    	  System.out.println(field.getName()+"\t:"+field.getStringValue().trim()+"\t"+field.attributeValue("weight"));
		      }
		      //parse sources
		      List<Element> sources = elm.element("sources").elements("source");
		      for(Element source: sources) {
		    	  queryParams.appendESSource(new ESQueryParams.ESSource(source.getStringValue().trim()));
//		    	  System.out.println(source.getName()+"\t:"+source.getStringValue().trim());
		      }
		      xmlmapper.put(elm.attributeValue("index"), queryParams);
		}
		
		return xmlmapper;
	}
	public static Map<String, List<String> > getFiledsMapper(){
		if(mapper==null) {
			mapper = new LinkedHashMap<>();
			Set< Class<?>> classes = new HashSet<>();
			try {
	            // 添加到集合中去
	            // classes.add(Class.forName(packageName + '.' + className));
	            // 经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
	            classes.add(Thread.currentThread().getContextClassLoader().loadClass("org.iscas.web.entity.Disease"));
	            classes.add(Thread.currentThread().getContextClassLoader().loadClass("org.iscas.web.entity.Material"));
	            
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			for(Class<?> clazz:classes) {
			    RiverRule rule = RiverRule.extractRule(clazz,ElasticSearchConfig.ES_DOC_TYPE);
			    Set<IndexedField> set = rule.fields;
			    List<String> fields = new ArrayList<>(); 
			    for(IndexedField fs:set) {
			    	if("text".equals(fs.type)) {
			    		fields.add(fs.field);
			    	}
//			    	System.out.println(fs.field+"\t"+fs.type);
			    	
			    }
			    mapper.put(rule.targetIndex, fields);
//			    System.out.println("\n");
//			    for(String t:fields) {
//			    	System.out.print(t+"\t");
//			    }
//			    System.out.println("\n");
			    
			}
		}
		return mapper;
	}
	public static void main(String [] args) {
		for(Entry<String, List<String>> entry  : FieldsMapper.getFiledsMapper().entrySet()) {
			System.out.println(entry.getKey());
			for(String s:entry.getValue()) {
				System.out.print(s+"\t");
			}
			System.out.println();
		}
	}
}
