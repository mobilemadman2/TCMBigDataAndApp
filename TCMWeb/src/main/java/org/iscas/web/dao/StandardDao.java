package org.iscas.web.dao;

import java.util.List;

import org.iscas.web.entity.Book;
import org.iscas.web.entity.Standard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardDao extends JpaRepository<Standard, Long>{
	@Query(value="select distinct first_index from standard", nativeQuery = true)
	List<String> findDistinctFirstIndex();
	
	@Query(value="select distinct second_index from standard where first_index=?1 ", nativeQuery = true)
	List<String> findDistinctSecondIndex(String s);
	
	List<Standard> findByFirstIndexAndSecondIndex(String first_index, String second_index);
		
	@Query(value="select distinct china_type_ccs from standard where second_index=?1 ", nativeQuery = true)
	List<String> findDistinctCCS(String s);
	
	
	Long countByFirstIndex(String d);
	
	Long countBySecondIndex(String d);
	
	
	@Query(value="SELECT * FROM standard where standard_name like %?1%", nativeQuery=true)
	List<Standard> findByName(String name);
}
