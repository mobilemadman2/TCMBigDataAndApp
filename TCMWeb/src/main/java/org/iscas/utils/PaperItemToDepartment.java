package org.iscas.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.iscas.web.dao.PaperDao;
import org.iscas.web.entity.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperItemToDepartment {
	@Autowired
	PaperDao paperDao;
	public void GenerateDepartment() {
		List<Paper> list =  paperDao.findAll();
		List<Paper> updateDepartment = new ArrayList<>(); 
		for(Paper 	Paper:list) {
			if(Paper.getDepartment()==null||"".equals(Paper.getDepartment())) {
				if(Paper.getAuthor_info_list()!=null && !Paper.getAuthor_info_list().equals("")) {
					
					String[] authorStrArray = Paper.getAuthor_info_list().split(";");
					HashMap<String,String> departList=new HashMap<String,String>();
					String authorResult="";
					String departmentResult="";
					int indx=1;
					for(int i = 0; i < authorStrArray.length; i++)
					{
						String[] authorInfo=authorStrArray[i].split(" ");
						try{
							String departmentInfo=authorInfo[2];
							if(!departList.containsKey(departmentInfo)){
								departList.put(departmentInfo, " ["+indx+"]");
								indx+=1;	
							}
						}
						catch(Exception E){
							//System.out.println(authorInfo[1]);
							continue;
						}
				
					}
					for (String key : departList.keySet()) {
						departmentResult+=key+" "+departList.get(key)+"&#32;";
			            
			        }
					for(int i = 0; i < authorStrArray.length; i++)
					{
						String[] authorInfo=authorStrArray[i].split(" ");
						try{
							String temp=departList.get(authorInfo[2]);
							authorResult+=authorInfo[1]+" "+temp+" ";
						}catch(Exception E){
							try{
								authorResult+=authorInfo[1]+" ";
							}catch(Exception E1){
								continue;
							}
													
						}
	
					} 
					Paper.setDepartment(departmentResult);
					Paper.setAuthor(authorResult);
					System.out.println(departmentResult+" "+authorResult);
					updateDepartment.add(Paper);
				}
				
			}
		}
		paperDao.saveAll(updateDepartment);
		paperDao.flush();

	
		
	}

}
