package com.chaminda.neo4j.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;


@SpringBootApplication(
        exclude = SessionAutoConfiguration.class,
        scanBasePackages = {"com.chaminda.neo4j.example"}
)
public class ProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderServiceApplication.class, args);
    }
}
