package com.chaminda.neo4j.example.api;

import com.chaminda.neo4j.example.AbstractIntegrationTest;
import com.chaminda.neo4j.example.domain.Provider;
import com.jayway.restassured.http.ContentType;
import org.junit.Test;

import static com.chaminda.neo4j.example.api.ApiConstants.API_PROVIDERS;
import static com.chaminda.neo4j.example.data.TestDataProvider.getValidProviderWith;
import static com.jayway.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class ProviderControllerIT extends AbstractIntegrationTest {

    @Test
    public void shouldSuccessfullyCreateGivenValidProvider() {
        //given
        String firstName = "First";
        String lastName = "Last";
        String comment = "comment";

        Provider provider = getValidProviderWith(firstName, lastName, comment);
        //and
        given().
                body(provider).
                contentType(ContentType.JSON).
                when().
                post(API_PROVIDERS).
                then().
                statusCode(SC_CREATED).
                body("comments", equalTo(provider.getComments())).
                body("firstName", equalTo(provider.getFirstName())).
                body("lastName", equalTo(provider.getLastName())).
                body("id", notNullValue());
    }


}
