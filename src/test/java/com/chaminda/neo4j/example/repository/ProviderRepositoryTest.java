package com.chaminda.neo4j.example.repository;

import com.chaminda.neo4j.example.AbstractRepositoryTest;
import com.chaminda.neo4j.example.domain.Provider;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.chaminda.neo4j.example.data.TestDataProvider.getValidProviderWith;
import static org.assertj.core.api.Assertions.assertThat;


public class ProviderRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private ProviderRepository providerRepository;

    @After
    public void cleanUp() {
/*		ProviderType savedProvider = providerRepository.findByTypeCodeAndDescription(typeCode, description);
        providerTypeRepository.delete(savedProvider.getId());*/
    }

    @Test
    public void shouldSuccessfullyInjectProviderRepository() {
        //then
        assertThat(providerRepository).isNotNull();
    }

    @Test
    public void shouldPersistAGivenValidProvider() {
        //given
        String firstName = "First";
        String lastName = "Last";
        String comment = "some comment";

        Provider provider = getValidProviderWith(firstName, lastName, comment);
        provider.getProviderAssignment().setProvider(provider);

        //when
        Provider saved = providerRepository.save(provider);

        //then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getComments()).isEqualTo(comment);
        assertThat(saved.getFirstName()).isEqualTo(firstName);
        assertThat(saved.getAbn()).isEqualTo(provider.getAbn());
        assertThat(saved.getContactInfo().getId()).isNotNull();
        assertThat(saved.getProviderType().getId()).isNotNull();
        assertThat(saved.getContactInfo().getEmail()).isEqualTo(provider.getContactInfo().getEmail());
        saved.getCareerProfile().getInterests().forEach(interest -> assertThat(interest.getId()).isNotNull());
        saved.getCareerProfile().getSpecialties().forEach(speciality -> assertThat(speciality.getId()).isNotNull());
        saved.getCareerProfile().getCourses().forEach(course -> assertThat(course.getId()).isNotNull());
//		saved.getSpecilists().stream().filter(specilist -> specilist.getDateCreated()!= null)
//			.forEach(spaciality -> assertThat(spaciality.getDateCreated() != null).isTrue());


    }


}
