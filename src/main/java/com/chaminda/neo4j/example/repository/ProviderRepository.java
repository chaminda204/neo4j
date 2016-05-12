package com.chaminda.neo4j.example.repository;


import com.chaminda.neo4j.example.domain.Provider;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends GraphRepository<Provider> {

}
