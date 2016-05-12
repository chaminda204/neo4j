package com.chaminda.neo4j.example.service;

import com.chaminda.neo4j.example.domain.Speciality;
import com.chaminda.neo4j.example.exception.ExistingSpeciality;
import com.chaminda.neo4j.example.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceImpl extends GenericServiceImpl<Speciality> implements SpecialityService {

    @Autowired
    public SpecialityServiceImpl(SpecialityRepository repository) {
        super(repository);
    }

    @Override
    public Speciality save(final Speciality speciality) {

        final Speciality existing = ((SpecialityRepository) getRepository()).findBySpecialityCodeAndDescription(speciality.getSpecialtyCode(), speciality.getDescription());

        if (existing != null) {
            throw new ExistingSpeciality("Speciality " + speciality.getDescription() + " is already recorded");
        }
        return super.save(speciality);
    }

}
