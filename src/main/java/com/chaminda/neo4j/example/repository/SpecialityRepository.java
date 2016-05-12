package com.chaminda.neo4j.example.repository;

import com.chaminda.neo4j.example.domain.Speciality;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends GraphRepository<Speciality> {

    @Query("MATCH (speciality:Speciality {specialtyCode:{0}, description :{1} }) RETURN speciality")
    Speciality findBySpecialityCodeAndDescription(String specialityCode, String description);

}
