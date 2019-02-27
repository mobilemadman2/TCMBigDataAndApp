package org.iscas.web.dao;
import org.iscas.web.entity.Acupoint;
import org.iscas.web.entity.Disease;
import org.iscas.web.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcupointDao extends JpaRepository<Acupoint, Long>{
	//get all classification of acupoint
	@Query(value="select distinct suoshujingluofenleimingcheng from xueweibiao", nativeQuery = true)
	List<String> findDistinctAcupointType();
	
	//get detail informaiton by acupoint name
	List<Acupoint> findByXueweimingcheng(String acupoint_name);
	
	List<Acupoint> findByXueweimingchengContainingOrPeiwuContainingOrZhuzhiContaining(String name,String nameCn,String nameCnCopy);
	
}
