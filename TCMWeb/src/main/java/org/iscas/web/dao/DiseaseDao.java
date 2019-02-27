package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

import org.iscas.web.entity.Disease;
import org.iscas.web.entity.Material;

/**
 * Created by suemi on 17-7-1.
 */
@Repository
public interface DiseaseDao extends JpaRepository<Disease,Long> {
	Disease findByName(String name);
	
	//problem to be fixed,use following findAllByNameCnAttri1&2 instead 
	//@Query(value="SELECT * FROM disease where name= ?1 or overview like %?1%", nativeQuery = true)
	//List<Disease> findAllByNameCnAttri(String nameCn);
	List<Disease> findByNameOrOverviewContaining(String nameCn,String nameCnCopy);
	
	//temporary solution
	@Query(value="SELECT * FROM disease where name= ?1", nativeQuery = true)
	List<Disease> findAllByNameCnAttri1(String nameCn);
	//temporary solution
	@Query(value="SELECT * FROM disease where overview like %?1%", nativeQuery = true)
	List<Disease> findAllByNameCnAttri2(String nameCn);
	
	@Query(value="SELECT * FROM disease ORDER BY name_pinyin ASC", nativeQuery = true)
	List<Disease> findAllByNamePinyinAsc();
	
	@Query(value="select * from disease where name_pinyin like ?1%", nativeQuery = true)
	List<Disease> findAllByNamePinyinAlphabet(String alpahbet);

	List<Disease> findByNameIn(Collection names);
}
