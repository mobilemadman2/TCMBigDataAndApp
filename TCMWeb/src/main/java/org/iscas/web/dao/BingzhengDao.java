package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.iscas.web.entity.BingZheng;
import org.iscas.web.entity.Disease;

/**
 * Created by suemi on 17-7-1.
 */
@Repository
public interface BingzhengDao extends JpaRepository<BingZheng,Long> {
	List<BingZheng> findByDisease(Disease disease);
}
