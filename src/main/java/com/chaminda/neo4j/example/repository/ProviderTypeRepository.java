package com.chaminda.neo4j.example.repository;

import com.chaminda.neo4j.example.domain.ProviderType;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderTypeRepository extends GraphRepository<ProviderType> {

    @Query("MATCH (providerType:ProviderType {typeCode:{0}, description :{1} }) RETURN providerType")
    ProviderType findByTypeCodeAndDescription(String typeCode, String description);

}
