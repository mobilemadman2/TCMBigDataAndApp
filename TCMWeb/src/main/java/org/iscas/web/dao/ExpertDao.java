package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import org.iscas.web.entity.Expert;
import org.iscas.web.entity.Expert;

/**
 * Created by suemi on 17-7-1.
 */
@Repository
public interface ExpertDao extends JpaRepository<Expert,Long> {
	Expert findByName(String name);
	
	List<Expert> findByNameIn(Collection names);
	
	List<Expert> findByNameOrStatusContaining(String nameCn,String nameCnCopy);
		
	@Query(value="SELECT * FROM expert where name_pinyin is not null ORDER BY name_pinyin ASC", nativeQuery = true)
	List<Expert> findAllByNamePinyinAsc();
	
	@Query(value="select * from expert where name_pinyin like ?1%", nativeQuery = true)
	List<Expert> findAllByNamePinyinAlphabet(String alpahbet);


}
