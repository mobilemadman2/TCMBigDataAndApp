package org.iscas.web.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.iscas.web.entity.BookProof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookProofDao extends JpaRepository<BookProof,Long> {
	@Query(value="SELECT * FROM book_proof where book_name=?1", nativeQuery=true)
	BookProof findBookContentByName(String name);
	
	@Query(value="SELECT book_content FROM book_proof where book_name=?1", nativeQuery=true)
	String findContentByName(String name);
	
	@Query(value="SELECT update_at FROM book_proof where book_name=?1", nativeQuery=true)
	Timestamp findTimeByName(String name);
	
	@Query(value="SELECT update_at FROM book_proof where book_name=?1", nativeQuery=true)
	List<Timestamp> findTimeListByName(String name);
	
	@Query(value="SELECT id FROM book_proof where book_name=?1", nativeQuery=true)
	int findIdByName(String name);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO book_proof (id,book_name,book_content,update_at,create_at) VALUES (?4,?1,?2,?3,?3) ON DUPLICATE KEY UPDATE book_content = ?2 ,update_at = ?3,create_at = ?3", nativeQuery = true)
	int updateDataByContent(String book_name ,String content,java.util.Date date,int id);
	
	@Query(value="SELECT * FROM book_proof where book_name=?1", nativeQuery=true)
	List<BookProof> findByName(String name);
}
