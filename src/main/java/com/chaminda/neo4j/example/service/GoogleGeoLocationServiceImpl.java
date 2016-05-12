package com.chaminda.neo4j.example.service;


import com.chaminda.neo4j.example.domain.GeoLocation;
import com.chaminda.neo4j.example.rest.GeoCoordinateLookupRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoogleGeoLocationServiceImpl implements GoogleGeoLocationService {

    @Autowired
    private GeoCoordinateLookupRestClient geoCoordinateLookupRestClient;

    @Override
    public GeoLocation findLocation(String location) {
        return geoCoordinateLookupRestClient.call(location);

    }
}
