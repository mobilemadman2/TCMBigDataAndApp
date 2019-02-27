package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.iscas.web.entity.Mainrecord;
import org.iscas.web.entity.Prescription;

/**
 * Created by suemi on 17-7-1.
 */
@Repository
public interface MainrecordDao extends JpaRepository<Mainrecord,Long> {
	Mainrecord findBySickId(String sickId);
}
