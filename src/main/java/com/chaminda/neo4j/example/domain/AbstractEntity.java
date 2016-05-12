package com.chaminda.neo4j.example.domain;

import org.neo4j.ogm.annotation.GraphId;

import java.io.Serializable;
import java.time.LocalDateTime;


public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @GraphId
    private Long id;

    private LocalDateTime dateCreated;


    private LocalDateTime lastUpdated;


    public LocalDateTime getDateCreated() {
        return dateCreated;
    }


    public void setDateCreated(final LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }


    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

}