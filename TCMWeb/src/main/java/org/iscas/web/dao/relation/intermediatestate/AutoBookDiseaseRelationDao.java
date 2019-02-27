package org.iscas.web.dao.relation.intermediatestate;

import org.iscas.web.entity.relationship.intermediatestate.AutoBookDiseaseRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AutoBookDiseaseRelationDao extends JpaRepository<AutoBookDiseaseRelation,Long> {
	public List<AutoBookDiseaseRelation> findByBaseEntityAndPath(String baseEntity, String path);
	public AutoBookDiseaseRelation findByBaseEntityAndRelatedEntityAndPath(String baseEntity, String relatedEntity, String path);
	public List<AutoBookDiseaseRelation> findByBaseEntity(String baseEntity);

}
