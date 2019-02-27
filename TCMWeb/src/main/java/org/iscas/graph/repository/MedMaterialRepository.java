package org.iscas.graph.repository;

import org.iscas.graph.nodeentity.MedMaterial;
import org.iscas.graph.nodeentity.Prescription;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
//@RepositoryRestResource(collectionResourceRel = "medMaterials", path = "medMaterials")
@Repository
public interface MedMaterialRepository extends PagingAndSortingRepository<MedMaterial, Long> {
	
	@Query("MATCH (m:MedMaterial)<-[r_c:Consist]-(p:Prescription) where m.name = {0} return m,r_c,p")
	Collection<MedMaterial> getGraphByName(String name);
	
	@Query("MATCH (m:MedMaterial) where m.name = {0} return m")
	Collection<MedMaterial> getEntityByName(String name);
	
	@Query("MATCH (m:MedMaterial) where m.name =~ {0} return m")
	Collection<MedMaterial> findMedMaterialByNameLike(String name);
	
	@Query("MATCH (p:Prescription)-[rc:Consist]->(m:MedMaterial) WHERE m.name={0} RETURN p")
	Collection<Prescription> getPrescriptionByMaterialName(String name);
	
}
