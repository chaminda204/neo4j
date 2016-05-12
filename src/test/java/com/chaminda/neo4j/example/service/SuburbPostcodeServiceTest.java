package com.chaminda.neo4j.example.service;

import com.chaminda.neo4j.example.domain.Suburb;
import com.chaminda.neo4j.example.domain.Suburb.SuburbBuilder;
import com.chaminda.neo4j.example.exception.ExistingSuburbException;
import com.chaminda.neo4j.example.repository.SuburbPostcodeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class SuburbPostcodeServiceTest {

    @InjectMocks
    private SuburbPostcodeService suburbPostcodeService;

    @Mock
    private SuburbPostcodeRepository repository;

    private Long postcode = 6149L;
    private String suburbName = "Riverton";

    @Before
    public void beforeTest() {
        suburbPostcodeService = new SuburbPostcodeServiceImpl(repository);
        initMocks(this);
    }

    @Test
    public void shouldCreateGivenValidSuburb() {
        //given
        Suburb suburb = new SuburbBuilder().withPostcode(postcode).withSuburbName(suburbName).build();
        when(repository.findSuburbByPostcodeAndSuburb(postcode, suburbName)).thenReturn(null);
        when(repository.save(suburb)).thenReturn(savedSuburb());

        //when
        Suburb saved = suburbPostcodeService.save(suburb);

        //then
        assertThat(saved).isNotNull();
        assertThat(saved.getPostcode()).isEqualTo(postcode);
        assertThat(saved.getName()).isEqualTo(suburbName);
    }


    @Test(expected = ExistingSuburbException.class)
    public void shouldThrowExceptionForGivenExistingSuburbRecord() {
        //given
        Suburb suburb = new SuburbBuilder().withPostcode(postcode).withSuburbName(suburbName).build();
        when(repository.findSuburbByPostcodeAndSuburb(postcode, suburbName)).thenReturn(savedSuburb());
        suburbPostcodeService.save(suburb);

        //when
        suburbPostcodeService.save(suburb);

    }

    private Suburb savedSuburb() {
        return new SuburbBuilder().withPostcode(postcode).withSuburbName(suburbName).build();
    }


}
