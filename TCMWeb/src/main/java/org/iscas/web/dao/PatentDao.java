package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.iscas.web.entity.Disease;
import org.iscas.web.entity.Patent;
import org.iscas.web.entity.Prescription;
import org.iscas.web.entity.Standard;

/**
 * Created by suemi on 17-7-1.
 */
@Repository
public interface PatentDao extends JpaRepository<Patent,Long> {
	Patent findByPn(String pn);
	
	@Query(value="SELECT * FROM patent where it like %?1%", nativeQuery=true)
	List<Patent> findByIt(String name);
	
	@Query(value="SELECT * FROM patent where cpti like %?1%", nativeQuery=true)
	List<Patent> findByCpti(String name);
	
	@Query(value="SELECT * FROM patent ORDER BY ti_pinyin ASC", nativeQuery = true)
	List<Patent> findAllByTiPinyinAsc();
	
	@Query(value="select * from patent where ti_pinyin like ?1%", nativeQuery = true)
	List<Patent> findAllByTiPinyinAlphabet(String alpahbet);
}