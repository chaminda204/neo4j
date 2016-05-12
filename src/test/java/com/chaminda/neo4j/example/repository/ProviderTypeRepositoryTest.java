package com.chaminda.neo4j.example.repository;

import com.chaminda.neo4j.example.AbstractRepositoryTest;
import com.chaminda.neo4j.example.domain.ProviderType;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.chaminda.neo4j.example.data.TestDataProvider.newProviderTypeWith;
import static org.assertj.core.api.Assertions.assertThat;

public class ProviderTypeRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private ProviderTypeRepository providerTypeRepository;

    private String typeCode = "type_01";

    private String description = "some provider type description";

    @After
    public void cleanUp() {
        ProviderType savedProvider = providerTypeRepository.findByTypeCodeAndDescription(typeCode, description);
        providerTypeRepository.delete(savedProvider.getId());
    }

    @Test
    public void shoulPersistGivenValidProviderType() {
        //given
        ProviderType providerType = newProviderTypeWith(typeCode, description);

        //when
        ProviderType saved = providerTypeRepository.save(providerType);

        //then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getDescription()).isEqualTo(description);
        assertThat(saved.getTypeCode()).isEqualTo(typeCode);
    }

}
