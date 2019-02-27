package org.iscas.web.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.iscas.web.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookEntityDao extends JpaRepository<BookEntity,Long> {
	
	//查找疾病，方剂，草药涉及到的书名
	@Query(value="SELECT distinct base_entity FROM auto_book_disease_relation group by base_entity", nativeQuery=true)
	List<String> findAllDiseaseBookByName();
	@Query(value="SELECT distinct base_entity FROM auto_book_material_relation group by base_entity", nativeQuery=true)
	List<String> findAllMaterialBookByName();
	@Query(value="SELECT distinct base_entity FROM auto_book_prescription_relation group by base_entity", nativeQuery=true)
	List<String> findAllPrescriptionBookByName();
	
//	@Modifying
//	@Transactional
//	@Query(value="INSERT INTO book_proof (id,book_name,book_content,update_at,create_at) VALUES (?4,?1,?2,?3,?3) ON DUPLICATE KEY UPDATE book_content = ?2 ,update_at = ?3,create_at = ?3", nativeQuery = true)
//	int updateDataByContent(String book_name ,String content,java.util.Date date,int id);
	
	//查找自动抽取的实体
	@Query(value="SELECT * FROM auto_book_disease_relation where base_entity=?1", nativeQuery=true)
	List<BookEntity> findAllDiseaseEntityByName(String name);
	@Query(value="SELECT * FROM auto_book_expert_relation where base_entity=?1", nativeQuery=true)
	List<BookEntity> findAllExpertEntityByName(String name);
	@Query(value="SELECT * FROM auto_book_material_relation where base_entity=?1", nativeQuery=true)
	List<BookEntity> findAllMaterialEntityByName(String name);
	@Query(value="SELECT * FROM auto_book_prescription_relation where base_entity=?1", nativeQuery=true)
	List<BookEntity> findAllPrescriptionEntityByName(String name);
	
	//查找校正后的实体
	@Query(value="SELECT * FROM set_book_disease_relation where base_entity=?1", nativeQuery=true)
	List<BookEntity> findDiseaseEntityByName(String name);
	@Query(value="SELECT * FROM set_book_expert_relation where base_entity=?1", nativeQuery=true)
	List<BookEntity> findExpertEntityByName(String name);
	@Query(value="SELECT * FROM set_book_material_relation where base_entity=?1", nativeQuery=true)
	List<BookEntity> findMaterialEntityByName(String name);
	@Query(value="SELECT * FROM set_book_prescription_relation where base_entity=?1", nativeQuery=true)
	List<BookEntity> findPrescriptionEntityByName(String name);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO book_disease_relation (create_at,update_at,base_entity,related_entity,paragraph,path,position) VALUES (?6,?7,?1,?2,?3,?4,?5)", nativeQuery = true)
	int insertDiseaseEntity(String base_entity ,String related_entity,int paragraph,String path,int position,java.util.Date create_date,java.util.Date delete_date);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO book_material_relation (create_at,update_at,base_entity,related_entity,paragraph,path,position) VALUES (?6,?7,?1,?2,?3,?4,?5)", nativeQuery = true)
	int insertMaterialEntity(String base_entity ,String related_entity,int paragraph,String path,int position,java.util.Date create_date,java.util.Date delete_date);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO book_prescription_relation (create_at,update_at,base_entity,related_entity,paragraph,path,position) VALUES (?6,?7,?1,?2,?3,?4,?5)", nativeQuery = true)
	int insertPrescriptionEntity(String base_entity ,String related_entity,int paragraph,String path,int position,java.util.Date create_date,java.util.Date delete_date);
}
