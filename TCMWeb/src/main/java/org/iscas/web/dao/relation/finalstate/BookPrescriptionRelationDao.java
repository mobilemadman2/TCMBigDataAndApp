package org.iscas.web.dao.relation.finalstate;

import org.iscas.web.entity.relationship.finalstate.BookPrescriptionRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookPrescriptionRelationDao extends JpaRepository<BookPrescriptionRelation,Long> {
	public List<BookPrescriptionRelation> findByBaseEntityAndPath(String baseEntity, String path);
	public BookPrescriptionRelation findByBaseEntityAndRelatedEntityAndPath(String baseEntity, String relatedEntity, String path);
	public void deleteByBaseEntityAndPath(String baseEntity, String path);
	public List<BookPrescriptionRelation> findByBaseEntity(String baseEntity);


}
