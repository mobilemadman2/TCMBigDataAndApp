package org.iscas.web.dao.relation.intermediatestate;

import org.iscas.web.entity.Expert;
import org.iscas.web.entity.relationship.intermediatestate.AutoBookExpertRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AutoBookExpertRelationDao extends JpaRepository<AutoBookExpertRelation,Long> {
	public List<AutoBookExpertRelation> findByBaseEntityAndPath(String baseEntity, String path);
	public AutoBookExpertRelation findByBaseEntityAndRelatedEntityAndPath(String baseEntity, String relatedEntity, String path);
	public List<AutoBookExpertRelation> findByBaseEntity(String baseEntity);

}
