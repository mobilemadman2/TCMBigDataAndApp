package org.iscas.web.dao.relation.intermediatestate;

import org.iscas.web.entity.relationship.intermediatestate.AutoBookExpertRelation;
import org.iscas.web.entity.relationship.intermediatestate.AutoBookPrescriptionRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AutoBookPrescriptionRelationDao extends JpaRepository<AutoBookPrescriptionRelation,Long> {
	public List<AutoBookPrescriptionRelation> findByBaseEntityAndPath(String baseEntity, String path);
	public AutoBookPrescriptionRelation findByBaseEntityAndRelatedEntityAndPath(String baseEntity, String relatedEntity, String path);
	public List<AutoBookExpertRelation> findByBaseEntity(String baseEntity);

}
