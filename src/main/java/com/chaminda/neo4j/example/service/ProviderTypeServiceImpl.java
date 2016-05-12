package com.chaminda.neo4j.example.service;

import com.chaminda.neo4j.example.domain.ProviderType;
import com.chaminda.neo4j.example.exception.ExistingProviderType;
import com.chaminda.neo4j.example.repository.ProviderTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderTypeServiceImpl extends GenericServiceImpl<ProviderType> implements ProviderTypeService {

    @Autowired
    public ProviderTypeServiceImpl(ProviderTypeRepository repository) {
        super(repository);
    }

    @Override
    public ProviderType save(ProviderType providerType) {
        final ProviderType existing = ((ProviderTypeRepository) getRepository())
                .findByTypeCodeAndDescription(providerType.getTypeCode(), providerType.getDescription());

        if (existing != null) {
            throw new ExistingProviderType("Provider type " + providerType.getDescription() + " is an already existing record");
        }
        return super.save(providerType);
    }

}
