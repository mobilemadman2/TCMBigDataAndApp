package org.iscas.graph.repository;

import org.iscas.graph.nodeentity.Disease;
import org.iscas.graph.nodeentity.Prescription;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


//@RepositoryRestResource(collectionResourceRel = "diseases", path = "diseases")
@Repository
public interface DiseaseRepository extends PagingAndSortingRepository<Disease, Long> {
	@Query("MATCH (p:Prescription)-[r_t:Treat]->(d:Disease) where d.name = {0} return p,r_t,d")
	Collection<Prescription> getGraphByName(String name);
	
	@Query("MATCH (d:Disease) where d.name = {0} return d")
	Collection<Disease> getEntityByName(String name);
	
	@Query("MATCH (d:Disease) where d.name =~ {0} return d")
	Collection<Disease> findDiseaseByNameLike(String name);
	
	@Query("MATCH (d:Disease)<-[r_t:Treat]-(p:Prescription) WHERE d.name= {0} return p")
	Collection<Prescription> getPrescriptionByDiseaseName(String name);
}
