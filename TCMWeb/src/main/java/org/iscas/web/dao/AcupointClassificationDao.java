package org.iscas.web.dao;
import org.iscas.web.entity.Acupoint;
import org.iscas.web.entity.AcupointClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcupointClassificationDao extends JpaRepository<AcupointClassification, Long>{
	//get all information
	List<AcupointClassification> findAll();
	
	@Query(value="select distinct jingluomingchengfenlei from jingluomaibiao", nativeQuery = true)
	List<String> findDistinctAcupointClassification();
	
	//get detail informaiton by acupoint name
	@Query(value="select rentishiyitu from jingluomaibiao where jingluomingcheng = ?1", nativeQuery = true)
	String findRentishiyituByJingluomingcheng(String jingluomingcheng);
	
	List<AcupointClassification> findByJingluomingcheng(String jingluomingcheng);
	
	
	//get detail informaiton by acupoint name
	@Query(value="select jingluomingchengfenlei from jingluomaibiao where jingluomingcheng = ?1", nativeQuery = true)
	String findJingluomingchengfenleiByJingluomingcheng(String jingluomingcheng);
}
