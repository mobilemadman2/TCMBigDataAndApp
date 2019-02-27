package org.iscas.graph.repository;

import java.util.Collection;

import org.iscas.graph.nodeentity.Disease;
import org.iscas.graph.nodeentity.MedMaterial;
import org.iscas.graph.nodeentity.Prescription;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 */
@RepositoryRestResource(collectionResourceRel = "prescriptions", path = "prescriptions")
public interface PrescriptionRepository extends PagingAndSortingRepository<Prescription, Long> {

	Prescription findByName(@Param("name") String name);

	Collection<Prescription> findByNameLike(@Param("name") String name);
	
	@Query("MATCH (m:MedMaterial)<-[r_c:Consist]-(p:Prescription)-[r_t:Treat]->(d:Disease) where p.name = {0} return m,r_c,p,r_t,d")
	Collection<Prescription> getGraphByName(String name);

	@Query("MATCH (m:MedMaterial)<-[r_c:Consist]-(p:Prescription) where p.name = {0} return m,r_c,p")
	Collection<Prescription> getGraphConsistByName(String name);

	@Query("MATCH (p:Prescription)-[r_t:Treat]->(d:Disease) where p.name = {0} return p,r_t,d")
	Collection<Prescription> getGraphTreatByName(String name);
	
	@Query("MATCH (p:Prescription) where p.name = {0} return p")
	Collection<Prescription> getEntityByName(String name);
	
	@Query("MATCH (e:Prescription) where e.name =~ {0} return e")
	Collection<Prescription> findPrescriptionByNameLike(String name);
	
	@Query("MATCH (m:MedMaterial)<-[r_c:Consist]-(p:Prescription) WHERE p.name = {0} return m")
	Collection<MedMaterial> getMedmaterialByPrescriptionName(String name);	
	
	@Query("MATCH (d:Disease)<-[r_t:Treat]-(p:Prescription) WHERE p.name= {0} return d")
	Collection<Disease> getDiseaseByPrescriptionName(String name);
}

