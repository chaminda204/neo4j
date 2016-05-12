package com.chaminda.neo4j.example.repository;

import com.chaminda.neo4j.example.AbstractRepositoryTest;
import com.chaminda.neo4j.example.domain.Suburb;
import com.chaminda.neo4j.example.domain.Suburb.SuburbBuilder;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class SuburbRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private SuburbPostcodeRepository suburbPostcodeRepository;

    private Long postcode = 3150L;

    private String suburbName = "Glen Waverley";

    @After
    public void cleanUp() {
        Suburb suburbSaved = suburbPostcodeRepository.findSuburbByPostcodeAndSuburb(postcode, suburbName);
        suburbPostcodeRepository.delete(suburbSaved.getId());
    }

    @Test
    public void shouldPersistGivenValidSuburb() {
        // given
        Suburb gelnWaverley = new SuburbBuilder().withPostcode(postcode).withSuburbName(suburbName).build();

        // when
        Suburb saved = suburbPostcodeRepository.save(gelnWaverley);

        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
/*		assertThat(saved.getDateCreated()).isNotNull();
        assertThat(saved.getLastUpdated()).isNotNull();*/
        assertThat(saved.getPostcode()).isEqualTo(postcode);
        assertThat(saved.getName()).isEqualTo(suburbName);
    }

    @Test
    public void shouldReturnExistingSuburbWhenSearchedWithValidPostcodeAndSuburb() {
        // given
        Suburb gelnWaverley = new SuburbBuilder().withPostcode(postcode).withSuburbName(suburbName).build();
        suburbPostcodeRepository.save(gelnWaverley);

        // when
        Suburb saved = suburbPostcodeRepository.findSuburbByPostcodeAndSuburb(postcode, suburbName);

        //then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
//		assertThat(saved.getDateCreated()).isNotNull();
//		assertThat(saved.getLastUpdated()).isNotNull();
        assertThat(saved.getPostcode()).isEqualTo(postcode);
        assertThat(saved.getName()).isEqualTo(suburbName);

    }

}
