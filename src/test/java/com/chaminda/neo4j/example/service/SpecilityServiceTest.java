package com.chaminda.neo4j.example.service;

import com.chaminda.neo4j.example.domain.Speciality;
import com.chaminda.neo4j.example.domain.Speciality.SpecialityBuilder;
import com.chaminda.neo4j.example.exception.ExistingSpeciality;
import com.chaminda.neo4j.example.repository.SpecialityRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.chaminda.neo4j.example.data.TestDataProvider.newSpecialityFor;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class SpecilityServiceTest {

    final String specialityCode = "sp_01";
    final String description = "some_speciality";
    @InjectMocks
    private SpecialityService specialityService;
    @Mock
    private SpecialityRepository repository;

    @Before
    public void beforeTest() {
        specialityService = new SpecialityServiceImpl(repository);
        initMocks(this);
    }


    @Test(expected = ExistingSpeciality.class)
    public void shouldThrowExceptionWhenExistingSpecialityWithTheSameCodeAndDescriptionExixts() {
        //given
        Speciality speciality = newSpecialityFor(specialityCode, description);
        when(repository.findBySpecialityCodeAndDescription(anyString(), anyString())).thenReturn(savedSpecility());

        //when
        specialityService.save(speciality);
    }

    @Test
    public void shouldSaveGivenValidSpaciality() {
        //given
        Speciality speciality = newSpecialityFor(specialityCode, description);
        when(repository.findBySpecialityCodeAndDescription(anyString(), anyString())).thenReturn(null);
        when(repository.save(speciality)).thenReturn(savedSpecility());

        //when
        Speciality saved = specialityService.save(speciality);

        //then
        assertThat(saved).isNotNull();
    }


    private Speciality savedSpecility() {
        return new SpecialityBuilder().withSpecialityCode(specialityCode).withSpecialityDescription(description).build();
    }


}
