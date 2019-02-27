package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import org.iscas.web.entity.ExpertPaper;
import org.iscas.web.entity.ExpertPaper;

/**
 * Created by sumei on 18-9-1.
 */
@Repository
public interface ExpertPaperDao extends JpaRepository<ExpertPaper,Long> {
	//ExpertPaper findByDoctorName(String name);
	
	List<ExpertPaper> findByDoctorName(String names);
	


}
