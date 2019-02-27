package org.iscas.web.dao;

import org.iscas.web.entity.AcupointPic;
import org.iscas.web.entity.Material;
import org.iscas.web.entity.MedicalCase;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by suemi on 17-7-1.
 */
@Repository
public interface MedicalCaseDao extends JpaRepository<MedicalCase,Long> {
	//find all data
	List<MedicalCase> findAll();
	
	@Query(value="SELECT * FROM expert_medical_case ORDER BY doctor_name ASC", nativeQuery = true)
	List<MedicalCase> findAllByDoctorNameAsc();
	
	//获取中医生名字
	@Query(value="select distinct doctor_name from expert_medical_case", nativeQuery = true)
	List<String> findDistinctDoctorName();
	
	//根据医生名字获取数据
	@Query(value="select * from expert_medical_case where doctor_name = ?1", nativeQuery = true)
	List<MedicalCase> findByDocterName(String doctor_name);
	
	List<MedicalCase> findById(int id);
}
