package org.iscas.web.dao.relation;

import org.iscas.web.entity.relationship.MaterialBookRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MaterialBookRelationDao extends JpaRepository<MaterialBookRelation,Long> {
	public List<MaterialBookRelation> findByBaseEntity(String baseEntity);
	public List<MaterialBookRelation> findByBaseId(Long baseId);
}
