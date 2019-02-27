package org.iscas.web.dao.relation.finalstate;

import org.iscas.web.entity.relationship.finalstate.BookMaterialRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookMaterialRelationDao extends JpaRepository<BookMaterialRelation,Long> {
	public List<BookMaterialRelation> findByBaseEntityAndPath(String baseEntity, String path);
	public BookMaterialRelation findByBaseEntityAndRelatedEntityAndPath(String baseEntity, String relatedEntity, String path);
	public void deleteByBaseEntityAndPath(String baseEntity, String path);
	public List<BookMaterialRelation> findByBaseEntity(String baseEntity);


}
