package org.iscas.web.dao.relation;

import org.iscas.web.entity.relationship.MaterialDiseaseRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MaterialDiseaseRelationDao extends JpaRepository<MaterialDiseaseRelation,Long> {
	public List<MaterialDiseaseRelation> findByBaseEntity(String baseEntity);
	public List<MaterialDiseaseRelation> findByBaseId(Long baseId);
}
