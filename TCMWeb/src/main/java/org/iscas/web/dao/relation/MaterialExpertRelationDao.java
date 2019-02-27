package org.iscas.web.dao.relation;

import org.iscas.web.entity.relationship.MaterialExpertRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MaterialExpertRelationDao extends JpaRepository<MaterialExpertRelation,Long> {
	public List<MaterialExpertRelation> findByBaseEntity(String baseEntity);
	public List<MaterialExpertRelation> findByBaseId(Long baseId);
}
