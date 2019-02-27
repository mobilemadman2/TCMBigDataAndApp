package org.iscas.web.dao.relation.finalstate;

import org.iscas.web.entity.Expert;
import org.iscas.web.entity.relationship.finalstate.BookExpertRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookExpertRelationDao extends JpaRepository<BookExpertRelation,Long> {
	public List<BookExpertRelation> findByBaseEntityAndPath(String baseEntity, String path);
	public BookExpertRelation findByBaseEntityAndRelatedEntityAndPath(String baseEntity, String relatedEntity, String path);
	public void deleteByBaseEntityAndPath(String baseEntity, String path);
	public List<BookExpertRelation> findByBaseEntity(String baseEntity);


}
