package org.iscas.web.dao.relation.finalstate;

import org.iscas.web.entity.relationship.finalstate.BookDiseaseRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookDiseaseRelationDao extends JpaRepository<BookDiseaseRelation,Long> {
	public List<BookDiseaseRelation> findByBaseEntityAndPath(String baseEntity, String path);
	public BookDiseaseRelation findByBaseEntityAndRelatedEntityAndPath(String baseEntity, String relatedEntity, String path);
	public void deleteByBaseEntityAndPath(String baseEntity, String path);

	public List<BookDiseaseRelation> findByBaseEntity(String baseEntity);
}
