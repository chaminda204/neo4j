package com.chaminda.neo4j.example.service;

import com.chaminda.neo4j.example.domain.Suburb;
import com.chaminda.neo4j.example.exception.ExistingSuburbException;
import com.chaminda.neo4j.example.repository.SuburbPostcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuburbPostcodeServiceImpl extends GenericServiceImpl<Suburb> implements SuburbPostcodeService {

    @Autowired
    public SuburbPostcodeServiceImpl(SuburbPostcodeRepository repository) {
        super(repository);
    }

    @Override
    public Suburb save(Suburb suburb) {
        final Suburb existing = ((SuburbPostcodeRepository) getRepository()).findSuburbByPostcodeAndSuburb(suburb.getPostcode(), suburb.getName());

        if (existing != null) {
            throw new ExistingSuburbException("This suburb " + suburb.getName() + " already existing in the database");
        }
        return super.save(suburb);

    }


}
