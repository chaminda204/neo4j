package com.chaminda.neo4j.example.rest;

import com.chaminda.neo4j.example.domain.Builder;
import com.chaminda.neo4j.example.domain.GeoLocation;
import com.jayway.jsonpath.JsonPath;

public class GeoCoordinateBuilder implements Builder<GeoLocation> {

    public static final String JSON_PATH_LONGITUDE = "$.results[0].geometry.location.lng";
    public static final String JSON_PATH_LATITUDE = "$.results[0].geometry.location.lat";
    private String jsonString;

    public GeoCoordinateBuilder(String jsonString) {
        this.jsonString = jsonString;
    }


    @Override
    public GeoLocation build() {
        GeoLocation geoLocation = new GeoLocation();
        geoLocation.setLongitude(JsonPath.read(jsonString, JSON_PATH_LONGITUDE));
        geoLocation.setLatitude(JsonPath.read(jsonString, JSON_PATH_LATITUDE));
        return geoLocation;
    }
}
