package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import org.iscas.web.entity.Expert;
import org.iscas.web.entity.Material;
import org.iscas.web.entity.Syndrome;
import org.iscas.web.entity.SyndromeLevel;

@Repository
public interface SyndromeDao extends JpaRepository<Syndrome,Long>{
	
	List<Syndrome> findByNameIn(Collection names);
	
	//根据二级分类名称查找
	@Query(value="SELECT * FROM bing_zheng_tab1 WHERE level2_name=?1",nativeQuery = true)
	List<Syndrome> findBylevel2_name(String level2_name);
	
	//查询二级分类
	@Query(value="SELECT level2_name,count(level2_name) as number FROM bing_zheng_tab1 group by level2_name",nativeQuery = true)
	List<Object[]> findBylevel2();
	
	//根据搜索条件查询
	@Query(value="SELECT * FROM bing_zheng_tab1 WHERE name=?1 OR general_description LIKE %?2%",nativeQuery = true)
	List<Syndrome> findByNameOrGeneral(String nameCn,String nameCnCopy);
	
	//根据拼音升序
	@Query(value="SELECT * FROM bing_zheng_tab1 ORDER BY name_pinyin ASC",nativeQuery = true)
	List<Syndrome> findAllByNamePinyinAsc();
	
	@Query(value="select * from bing_zheng_tab1 where name_pinyin like ?1%", nativeQuery = true)
	List<Syndrome> findAllByNamePinyinAlphabet(char alpahbet);
	
	//查询表1的证候名，概述，数据源
	@Query(value="SELECT * FROM bing_zheng_tab1", nativeQuery = true)
	List<Syndrome> findAllNameDesDataInTab1();
	
	@Query(value="SELECT * FROM bing_zheng_tab1", nativeQuery = true)
	List<Syndrome> findByNameOrStatusContaining();
}
