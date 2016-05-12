package com.chaminda.neo4j.example.service;

import com.chaminda.neo4j.example.domain.GeoLocation;


public interface GoogleGeoLocationService {

    GeoLocation findLocation(String location);
}
