package com.chaminda.neo4j.example.api;


import com.chaminda.neo4j.example.AbstractIntegrationTest;
import com.chaminda.neo4j.example.data.TestDataProvider;
import com.chaminda.neo4j.example.domain.ProviderType;
import com.chaminda.neo4j.example.domain.Speciality;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.chaminda.neo4j.example.api.ApiConstants.*;
import static com.chaminda.neo4j.example.data.TestDataProvider.*;
import static com.jayway.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class ReferenceDataControllerIT extends AbstractIntegrationTest {

    @Test
    public void shouldSuccessfullyCreateGivenValidProviderType() {
        //given
        String description = "some description";
        String providerTypeCode = "pr_01";
        ProviderType providerType = newProviderTypeWith(providerTypeCode, description);

        //and
        given().
                body(providerType).
                contentType(ContentType.JSON).

        when().
                post(API_REF_DATA + PROVIDER_TYPE).

        then().
                statusCode(HttpStatus.SC_CREATED).
                body("description", equalTo(description)).
                body("typeCode", equalTo(providerTypeCode)).
                body("id", notNullValue());
    }

    @Test
    public void shouldReturnAllProviderTypes() {

        given().
                contentType(ContentType.JSON).

        when().
                get(API_REF_DATA + PROVIDER_TYPE).

        then().
                statusCode(HttpStatus.SC_OK).
                body("data", notNullValue());
    }

    @Test
    public void shouldSuccessfullyCreateGivenValidSpeciality() {
        //given
        String description = "some speciality";
        String specialityCode = "sp_01";
        Speciality speciality = newSpecialityFor(specialityCode, description);

        //and
        given().
                body(speciality).
                contentType(ContentType.JSON).

        when().
                post(API_REF_DATA + SPECIALITY).

        then().
                statusCode(SC_CREATED).
                body("description", equalTo(description)).
                body("specialtyCode", equalTo(specialityCode)).
                body("id", notNullValue());
    }

    @Test
    public void shouldReturnAllSpecialities() {

        given().
                contentType(ContentType.JSON).

                when().
                get(API_REF_DATA + SPECIALITY).

                then().
                statusCode(HttpStatus.SC_OK).
                body("data", notNullValue());
    }

}
