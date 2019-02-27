package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import org.iscas.web.entity.Expert;
import org.iscas.web.entity.Syndrome;
import org.iscas.web.entity.SyndromeTreatment;

@Repository
public interface SyndromeTreatmentDao extends JpaRepository<SyndromeTreatment,Long>{
	
	List<SyndromeTreatment> findByName(String name_standard);
	
	//根据搜索条件查询
	@Query(value="SELECT * FROM bing_zheng_tab2 WHERE name=?1",nativeQuery = true)
	List<SyndromeTreatment> findByNameCn(String nameCn);
	
	//根据病症名提取数据，去重
	@Query(value="SELECT * FROM bing_zheng_tab2 where id in (select max(id) from bing_zheng_tab2 group by ?1)", nativeQuery = true)
	List<SyndromeTreatment> findByData(String name_standard);
	
	//根据病症名提取数据
	@Query(value="SELECT * FROM bing_zheng_tab2 where name_standard = ?1", nativeQuery = true)
	List<SyndromeTreatment> findByAllData(String name_standard);
	
	//根据病症ID提取数据
	@Query(value="SELECT * FROM bing_zheng_tab2 where id = ?1", nativeQuery = true)
	List<SyndromeTreatment> findAllDataById(String id);
	
	//查询表2的数据源
	@Query(value="SELECT * FROM bing_zheng_tab2", nativeQuery = true)
	List<SyndromeTreatment> findAllSourceInTab2();
	
	@Query(value="SELECT * FROM bing_zheng_tab2 where name_standard='' and name!='None'", nativeQuery = true)
	List<SyndromeTreatment> findRemainingInTab2();
}
