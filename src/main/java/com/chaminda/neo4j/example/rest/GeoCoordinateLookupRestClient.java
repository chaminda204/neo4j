package com.chaminda.neo4j.example.rest;


import com.chaminda.neo4j.example.domain.GeoLocation;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class GeoCoordinateLookupRestClient extends AbstractRestClient<String> {

    public static final String PARAM_ADDRESS = "address";

    private static final String GEO_LOCATION_API = "http://maps.googleapis.com/maps/api/geocode/json";

    public GeoLocation call(String address) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add(PARAM_ADDRESS, address);
        String jsonAddress = getJSON(GEO_LOCATION_API, address, params);
        return getLocation(jsonAddress);
    }

    private GeoLocation getLocation(String jsonString) {
        return new GeoCoordinateBuilder(jsonString).build();
    }


}
