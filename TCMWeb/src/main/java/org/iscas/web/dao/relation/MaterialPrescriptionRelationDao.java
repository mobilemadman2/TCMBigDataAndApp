package org.iscas.web.dao.relation;

import org.iscas.web.entity.relationship.MaterialPrescriptionRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MaterialPrescriptionRelationDao extends JpaRepository<MaterialPrescriptionRelation,Long> {
	public List<MaterialPrescriptionRelation> findByBaseEntity(String baseEntity);
	public List<MaterialPrescriptionRelation> findByBaseId(Long baseId);
}
