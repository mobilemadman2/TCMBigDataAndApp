package org.iscas.web.dao;

import java.util.List;

import org.iscas.web.entity.AcupointPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AcupointPicDao extends JpaRepository<AcupointPic, Long>{
	//get all classification of acupoint
	@Query(value="select * from acupoint_picture_pos where pic_name = ?1", nativeQuery = true)
	List<AcupointPic> findAllByPicName(String pic_name);
	
	@Query(value="select count(*) from acupoint_picture_pos where pic_name = ?1", nativeQuery = true)
	int findCountByPicName(String pic_name);
}