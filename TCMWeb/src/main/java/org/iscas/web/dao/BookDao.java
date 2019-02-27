package org.iscas.web.dao;

import org.apache.ibatis.annotations.Param;
import org.iscas.web.entity.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface BookDao extends JpaRepository<Book,Long> {
	List<Book> findByDynastyId(Long dynastyId);
	
	@Query(value="SELECT * FROM book ORDER BY name_pinyin ASC", nativeQuery = true)
	List<Book> findAllOrderByNamePinyinAsc();
	
	@Query(value="SELECT * FROM book where name like %?1%", nativeQuery=true)
	List<Book> findByName(String name);
	
}
