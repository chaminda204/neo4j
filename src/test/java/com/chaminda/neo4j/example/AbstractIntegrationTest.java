package com.chaminda.neo4j.example;

import com.jayway.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProviderServiceApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@ActiveProfiles("ci")
public abstract class AbstractIntegrationTest {


    @Value("${local.server.port}")
    private int serverPort;

    @Before
    public void beforeEachTest() {
        RestAssured.port = serverPort;
        doBeforeEachTest();
    }

    @After
    public void afterEachTest() {
        doAfterEachTest();

    }

    protected void doBeforeEachTest() {

    }

    protected void doAfterEachTest() {

    }

}
