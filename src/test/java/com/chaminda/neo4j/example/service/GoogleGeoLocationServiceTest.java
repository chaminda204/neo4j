package com.chaminda.neo4j.example.service;

import com.chaminda.neo4j.example.AbstractRepositoryTest;
import com.chaminda.neo4j.example.domain.GeoLocation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleGeoLocationServiceTest extends AbstractRepositoryTest {

    @Autowired
    private GoogleGeoLocationService googleGeoLocationService;

    @Test
    public void shouldCallGoogleAPI() {
        //given
        String address = "222 Exhibition Street, Melbourne, 3000";
        //when
        GeoLocation location = googleGeoLocationService.findLocation(address);
        //then
        assertThat(location).isNotNull();
    }
}
