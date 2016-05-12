package com.chaminda.neo4j.example.repository;

import com.chaminda.neo4j.example.domain.Suburb;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuburbPostcodeRepository extends GraphRepository<Suburb> {

    @Query("MATCH (suburb:Suburb {postcode:{0}, name :{1} }) RETURN suburb")
    Suburb findSuburbByPostcodeAndSuburb(Long postcode, String name);

}
