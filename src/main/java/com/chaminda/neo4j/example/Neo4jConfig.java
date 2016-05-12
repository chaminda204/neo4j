package com.chaminda.neo4j.example;

import com.chaminda.neo4j.example.domain.AbstractEntity;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.event.BeforeSaveEvent;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.chaminda.neo4j.example.repository")
@EnableTransactionManagement
public class Neo4jConfig extends Neo4jConfiguration {

    //@Value("${database.url}")
    private String graphDbUrl="http://localhost:7474";

    //@Value("${database.user}")
    private String databaseUsername = "neo4j";

    //@Value("${database.password}")
    private String databasePassword = "password";

    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration() {
        org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
        config.driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                .setURI(graphDbUrl)
                .setCredentials(databaseUsername, databasePassword);
        return config;
    }

    @Bean
    public SessionFactory getSessionFactory() {
        // with domain entity base package(s)
        return new SessionFactory(getConfiguration(), "com.chaminda.neo4j.example.domain");
    }

    // needed for session in view in web-applications
    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session getSession() throws Exception {
        return super.getSession();
    }

    @Bean
    ApplicationListener<BeforeSaveEvent> beforeSaveEventApplicationListener() {
        return new ApplicationListener<BeforeSaveEvent>() {
            @Override
            public void onApplicationEvent(BeforeSaveEvent event) {
                AbstractEntity entity = (AbstractEntity) event.getEntity();
                entity.setLastUpdated(LocalDateTime.now());

                if (entity.getId() == null) {
                    entity.setDateCreated(LocalDateTime.now());
                }
            }
        };
    }

    //@Bean
//	public Neo4jServer neo4jServer() {
//		return new RemoteServer(graphDbUrl, databaseUsername, databasePassword);
//	}
}
