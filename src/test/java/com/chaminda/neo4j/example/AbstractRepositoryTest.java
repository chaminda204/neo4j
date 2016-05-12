package com.chaminda.neo4j.example;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProviderServiceApplication.class)
@WebAppConfiguration
@ActiveProfiles("ci")
public abstract class AbstractRepositoryTest {

}
