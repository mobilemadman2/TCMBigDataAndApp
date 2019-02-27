package org.iscas.web.dao.relation.intermediatestate;

import org.iscas.web.entity.relationship.intermediatestate.AutoBookMaterialRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AutoBookMaterialRelationDao extends JpaRepository<AutoBookMaterialRelation,Long> {
	public List<AutoBookMaterialRelation> findByBaseEntityAndPath(String baseEntity, String path);
	public AutoBookMaterialRelation findByBaseEntityAndRelatedEntityAndPath(String baseEntity, String relatedEntity, String path);
	public List<AutoBookMaterialRelation> findByBaseEntity(String baseEntity);

}
