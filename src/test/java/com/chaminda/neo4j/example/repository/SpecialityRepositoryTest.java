package com.chaminda.neo4j.example.repository;

import com.chaminda.neo4j.example.AbstractRepositoryTest;
import com.chaminda.neo4j.example.domain.Speciality;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.chaminda.neo4j.example.data.TestDataProvider.newSpecialityFor;
import static org.assertj.core.api.Assertions.assertThat;

public class SpecialityRepositoryTest extends AbstractRepositoryTest {

    final String specialityCode = "sp_01";
    final String description = "some_speciality";
    @Autowired
    private SpecialityRepository specialityRepository;

    @After
    public void cleanUp() {
        Speciality saved = specialityRepository.findBySpecialityCodeAndDescription(specialityCode, description);

        if (saved != null) {
            specialityRepository.delete(saved.getId());
        }
    }


    @Test
    public void shouldPersistGivenValidSpecilaity() {
        //given

        Speciality speciality = newSpecialityFor(specialityCode, description);

        //when
        Speciality specialitySaved = specialityRepository.save(speciality);

        //then
        assertThat(specialitySaved).isNotNull();
        assertThat(specialitySaved.getId()).isNotNull();
        assertThat(specialitySaved.getDescription()).isEqualTo(description);
        assertThat(specialitySaved.getSpecialtyCode()).isEqualTo(specialityCode);

    }

    @Test
    public void shouldReturnExistingSpecialityForGivenSpecialityCodeAndDescription() {
        //given
        Speciality speciality = newSpecialityFor(specialityCode, description);
        specialityRepository.save(speciality);

        //when
        Speciality specialityRetrieved = specialityRepository.findBySpecialityCodeAndDescription(specialityCode, description);

        //then
        assertThat(specialityRetrieved).isNotNull();
        assertThat(specialityRetrieved.getId()).isNotNull();
        assertThat(specialityRetrieved.getDescription()).isEqualTo(description);
        assertThat(specialityRetrieved.getSpecialtyCode()).isEqualTo(specialityCode);

    }


}
