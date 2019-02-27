package org.iscas.web.dao;
import org.iscas.web.entity.Acupoint;
import org.iscas.web.entity.Disease;
import org.iscas.web.entity.Image;
import org.iscas.web.entity.rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RuleDao extends JpaRepository<rule, Long>{
	//get all classification of acupoint
	@Modifying
	@Transactional
	@Query(value="INSERT INTO setting_rule (rules) VALUES (?1)", nativeQuery = true)
	int insertRules(String rules);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE setting_rule SET rules = ?1 where id = ?2", nativeQuery = true)
	int updateRules(String rules,int id);
	
	List<rule> findAll();
	
}
