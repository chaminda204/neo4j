package com.chaminda.neo4j.example.api;

import com.chaminda.neo4j.example.domain.Provider;
import com.chaminda.neo4j.example.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.chaminda.neo4j.example.api.ApiConstants.API_PROVIDERS;

@RestController
@RequestMapping(API_PROVIDERS)
public class ProviderController {

    @Autowired
    private ProviderRepository providerRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Provider saveProvider(@RequestBody Provider provider) {
        Provider persisted = providerRepository.save(provider);
        return persisted;

    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

}
