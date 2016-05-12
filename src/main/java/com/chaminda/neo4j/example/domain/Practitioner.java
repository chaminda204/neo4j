package com.chaminda.neo4j.example.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Practitioner extends AbstractEntity {

    private static final long serialVersionUID = -1L;

    private String title;

    private String firstName;

    private String lastName;

    private String displayName;

    @Relationship(type = "SPECILISED")
    private List<Speciality> spacilities;

    private Provider provider;

    public Practitioner() {
        spacilities = new ArrayList<Speciality>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Speciality> getSpacilities() {
        return spacilities;
    }

    public void setSpacilities(List<Speciality> spalciities) {
        this.spacilities = spalciities;
    }

    public void addSpecility(Speciality speciality) {
        spacilities.add(speciality);
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }


}
