package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import org.iscas.web.entity.Prescription;
import org.iscas.web.entity.Prescription;


@Repository
public interface PrescriptionDao extends JpaRepository<Prescription,Long> {
	Prescription findByName(String name);
	
	List<Prescription> findByNameIn(Collection names);
	
	//problem to be fixed,use following findAllByNameCnAttri1&2 instead 
		//@Query(value="SELECT * FROM prescription where name_cn=?1 or attribution like %?1%", nativeQuery = true)
		List<Prescription> findByNameOrSourceContaining(String nameCn,String nameCnCopy);
			
		@Query(value="SELECT * FROM prescription ORDER BY name_pinyin ASC", nativeQuery = true)
		List<Prescription> findAllByNamePinyinAsc();
		
		@Query(value="select * from prescription where name_pinyin like ?1%", nativeQuery = true)
		List<Prescription> findAllByNamePinyinAlphabet(String alpahbet);

/*	@Transactional
	@Query(value="UPDATE prescription as p SET p.name= :name p.alias= :alias p.composition= :composition"
			+ "p.processed= :processed p.process= :process p.pharmacologicaleffects= :pharmacologicaleffects"
			+ "p.function= :function p.dosage= :dosage p.remarks= :remarks"
			+ "p.variousDescription= :variousDescription p.application= :application p.attention= :attention p.source= :source"
			+ "WHERE p.id=:id")
	void updateById(@Param("id")Long id,@Param("name")String name,@Param("alias")String alias,@Param("composition")String composition,@Param("processed")String processed,
			@Param("process")String process,@Param("pharmacologicaleffects")String pharmacologicaleffects,
			@Param("function")String function,@Param("dosage")String dosage,@Param("remarks")String remarks,
			@Param("variousDescription")String variousDescription,@Param("application")String application,
			@Param("attention")String attention,@Param("source")String source);*/
}
