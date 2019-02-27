package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.iscas.web.entity.Inspectionresult;
import org.iscas.web.entity.Prescription;

/**
 * Created by suemi on 17-7-1.
 */
@Repository
public interface InspectionresultDao extends JpaRepository<Inspectionresult,Long> {
	Inspectionresult findBySickId(String sickId);
}
