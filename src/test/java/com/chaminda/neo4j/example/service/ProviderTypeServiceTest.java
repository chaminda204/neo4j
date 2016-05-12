package com.chaminda.neo4j.example.service;

import com.chaminda.neo4j.example.domain.ProviderType;
import com.chaminda.neo4j.example.exception.ExistingProviderType;
import com.chaminda.neo4j.example.repository.ProviderTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.chaminda.neo4j.example.data.TestDataProvider.newProviderTypeWith;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProviderTypeServiceTest {

    @InjectMocks
    private ProviderTypeService providerTypeService;

    @Mock
    private ProviderTypeRepository repository;

    private String typeCode = "type_01";

    private String description = "some provider type description";

    @Before
    public void beforeTest() {
        providerTypeService = new ProviderTypeServiceImpl(repository);
        initMocks(this);
    }

    @Test
    public void shoulPersistGivenValidProviderType() {
        //given
        ProviderType providerType = savedProvider();
        when(repository.findByTypeCodeAndDescription(anyString(), anyString())).thenReturn(null);
        when(repository.save(providerType)).thenReturn(savedProvider());

        //when
        ProviderType saved = providerTypeService.save(providerType);

        //then
        assertThat(saved).isNotNull();
        assertThat(saved.getDescription()).isEqualTo(description);
        assertThat(saved.getTypeCode()).isEqualTo(typeCode);
    }

    @Test(expected = ExistingProviderType.class)
    public void shouldThrowExceptionWhenDuplicateProviderTypeIsSaved() {
        // given
        ProviderType providerType = savedProvider();
        when(repository.findByTypeCodeAndDescription(anyString(), anyString())).thenReturn(savedProvider());

        //when
        providerTypeService.save(providerType);

    }

    private ProviderType savedProvider() {
        return newProviderTypeWith(typeCode, description);
    }

}
