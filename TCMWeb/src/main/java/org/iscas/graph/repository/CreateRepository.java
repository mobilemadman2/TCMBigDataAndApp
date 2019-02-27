package org.iscas.graph.repository;

import org.iscas.graph.nodeentity.Disease;
import org.iscas.graph.nodeentity.MedMaterial;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
@Repository
public interface CreateRepository extends PagingAndSortingRepository<Disease, Long> {
	
	@Query("Merge(p:Prescription{name:{0}}) Merge(m:MedMaterial{name:{1}}) Create(p) - [:Consist]->(m)")
	void createConsist(String pName,String mName);
	
	@Query("Merge(p:Prescription{name:{0}}) Merge(d:Disease{name:{1}}) Create(p) - [:Treat]->(d)")
	void createTreat(String pName,String mName);
	
	@Query("Match (n)-[r]-(m) With n,m,type(r) as typ,tail(collect(r)) as coll Foreach (x in coll | delete x)")
	void delete_same_relation();
	
}
