package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

import org.iscas.web.entity.Book;

import java.util.Collection;
import java.util.List;


import org.iscas.web.entity.Material;
import org.iscas.web.entity.Prescription;


@Repository
public interface MaterialDao extends JpaRepository<Material,Long> {
	
	
	List<Material> findByNameCn(String nameCn);
	//problem to be fixed,use following findAllByNameCnAttri1&2 instead 
	//@Query(value="SELECT * FROM material where name_cn=?1 or attribution like %?1%", nativeQuery = true)
	List<Material> findByNameCnOrAttributionContaining(String nameCn,String nameCnCopy);
		
	//temporary solution
	@Query(value="SELECT * FROM material where name_cn= ?1", nativeQuery = true)
	List<Material> findAllByNameCnAttri1(String nameCn);
	//temporary solution
	@Query(value="SELECT * FROM material where attribution like %?1%", nativeQuery = true)
	List<Material> findAllByNameCnAttri2(String nameCn,List<String> nameCnId);


	
	@Query(value="SELECT * FROM material ORDER BY name_pinyin ASC", nativeQuery = true)
	List<Material> findAllByNamePinyinAsc();
	
	@Query(value="select * from material where name_pinyin like ?1%", nativeQuery = true)
	List<Material> findAllByNamePinyinAlphabet(String alpahbet);

	List<Material> findByNameCnIn(Collection names);


}
