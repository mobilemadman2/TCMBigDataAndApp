package org.iscas.web.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.iscas.web.entity.Dynasty;
import org.iscas.web.entity.Dynasty.DynastyType;

/**
 * Created by suemi on 17-7-1.
 */
@Repository
public interface DynastyDao extends JpaRepository<Dynasty,Long> {
	List<Dynasty> findByType(DynastyType type);
	List<Dynasty> findByType(DynastyType type, Sort sort);
	
	
	@Query(value="SELECT name FROM dynasty where id = ?1", nativeQuery=true)
	String findNameById(Long id);
}
