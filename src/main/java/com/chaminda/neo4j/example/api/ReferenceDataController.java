package com.chaminda.neo4j.example.api;

import static com.chaminda.neo4j.example.api.ApiConstants.API_REF_DATA;
import static com.chaminda.neo4j.example.api.ApiConstants.PROVIDER_TYPE;
import static com.chaminda.neo4j.example.api.ApiConstants.SPECIALITY;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chaminda.neo4j.example.api.response.JsonResponse;
import com.chaminda.neo4j.example.api.response.JsonResponse.JsonResponseBuilder;
import com.chaminda.neo4j.example.domain.ProviderType;
import com.chaminda.neo4j.example.domain.Speciality;
import com.chaminda.neo4j.example.repository.SuburbPostcodeRepository;
import com.chaminda.neo4j.example.service.ProviderTypeService;
import com.chaminda.neo4j.example.service.SpecialityService;

@RestController
@RequestMapping(API_REF_DATA)
public class ReferenceDataController {

    @Autowired
    private ProviderTypeService providerTypeService;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private SuburbPostcodeRepository postcodeRepository;

    @RequestMapping(path = PROVIDER_TYPE, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProviderType saveProviderType(@RequestBody ProviderType providerType) {
        return providerTypeService.save(providerType);
    }


    @RequestMapping(path = PROVIDER_TYPE, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public JsonResponse<ProviderType> getAllProviderTypes() {

        Iterable<ProviderType> providerTypes = providerTypeService.findAll();
        return new JsonResponseBuilder<ProviderType>().withData(providerTypes).build();
    }

    @RequestMapping(path = SPECIALITY, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Speciality saveSpecialty(@RequestBody Speciality speciality) {
        return specialityService.save(speciality);
    }

    @RequestMapping(path = SPECIALITY, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public JsonResponse<Speciality> getAllSpecialities() {

        Iterable<Speciality> specialities = specialityService.findAll();
        return new JsonResponseBuilder<Speciality>().withData(specialities).build();
    }


}
