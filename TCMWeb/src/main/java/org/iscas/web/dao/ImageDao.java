package org.iscas.web.dao;

import java.util.List;
import org.iscas.web.entity.Image;
import org.neo4j.register.Register.Int;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageDao extends JpaRepository<Image, Long>{
	@Query(value="select * from image where disease_class=?1 and image_class=?2 Order BY id ASC ", nativeQuery = true)
	List<Image> findByDiseaseClassAndImageClass(String d, String i);
	
	List<Image> findAll();
	
	Long countByDiseaseClass(String d);
	Long countByDiseaseClassAndImageClass(String d, String i);
	
	@Query(value="select distinct disease_class from image", nativeQuery = true)
	List<String> findDistinctDieaseClass();
	
	@Query(value="select distinct image_class from image where disease_class=?1 ", nativeQuery = true)
	List<String> findDistinctImageClasses(String d);
}
