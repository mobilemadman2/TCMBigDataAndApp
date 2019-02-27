package org.iscas.web.dao;

import java.util.Collection;
import java.util.List;

import org.iscas.web.entity.ExpertPaper;
import org.iscas.web.entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaperDao extends JpaRepository<Paper,Long>{
	@Query(value="select * from expert_paper where paper_name like %?1% and id in(select max(id) from expert_paper group by paper_url)", nativeQuery = true)
	List<Paper> findByPaper_name(String name);
	
	@Query(value="select * from expert_paper where paper_name like %?1% and id in(select max(id) from expert_paper group by paper_url)", nativeQuery = true)
	List<Paper> findByNameIn(Collection names);
	
	@Query(value="select * from expert_paper where (paper_name like %?1% or paper_abstract like %?2%)and id in(select max(id) from expert_paper group by paper_url)", nativeQuery = true)
	List<Paper> findByNameOrAbstractsContaining(String nameCn,String nameCnCopy);
	
	@Query(value="select * from expert_paper where name_pinyin is not null and id in(select max(id) from expert_paper group by paper_url) ORDER BY name_pinyin ASC", nativeQuery = true)
	List<Paper> findAllByNamePinyinAsc();
	
	@Query(value="select * from expert_paper where (name_pinyin like %?1%) and id in(select max(id) from expert_paper group by paper_url)", nativeQuery = true)
	List<Paper> findAllByNamePinyinAlphabet(String alpahbet);
	
	@Query(value="select * from expert_paper where doctor_name=?1", nativeQuery = true)
	List<Paper> findBydoctorName(String names);

}
