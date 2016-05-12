package com.chaminda.neo4j.example.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Date;

@NodeEntity(label = "Provider")
public class Provider extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String firstName;

    private String lastName;

    private Date startDate;

    private String abn;

    private String comments;

    @Relationship(type = "CONTACTABLE_VIA")
    private ContactInfo contactInfo;

    @Relationship(type = "WITH_TYPE")
    private ProviderType providerType;

    private ProviderStatus providerStatus;

    @Relationship(type = "HAS_A")
    private CareerProfile careerProfile;

    @Relationship(type = "ASSIGNED_TO")
    @JsonManagedReference
    private ProviderAssignment providerAssignment;

    Provider() {

    }

    private Provider(ProviderBuilder providerBuilder) {
        this.firstName = providerBuilder.firstName;
        this.lastName = providerBuilder.lastName;
        this.startDate = providerBuilder.startDate;
        this.abn = providerBuilder.abn;
        this.comments = providerBuilder.comments;
        this.contactInfo = providerBuilder.contactInfo;
        this.providerType = providerBuilder.providerType;
        this.providerStatus = providerBuilder.providerStatus;
        this.careerProfile = providerBuilder.careerProfile;
        this.providerAssignment = providerBuilder.providerAssignment;
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

    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ProviderType getProviderType() {
        return providerType;
    }

    public void setProviderType(ProviderType providerType) {
        this.providerType = providerType;
    }

    public ProviderStatus getProviderStatus() {
        return providerStatus;
    }

    public void setProviderStatus(ProviderStatus providerStatus) {
        this.providerStatus = providerStatus;
    }


    public CareerProfile getCareerProfile() {
        return careerProfile;
    }

    public void setCareerProfile(CareerProfile careerProfile) {
        this.careerProfile = careerProfile;
    }

    public ProviderAssignment getProviderAssignment() {
        return providerAssignment;
    }

    public void setProviderAssignment(ProviderAssignment providerAssignment) {
        this.providerAssignment = providerAssignment;
        providerAssignment.setProvider(this);
    }


    public static class ProviderBuilder implements Builder<Provider> {

        private String firstName;

        private String lastName;

        private Date startDate;

        private String abn;

        private String comments;

        private ContactInfo contactInfo;

        private ProviderType providerType;

        private ProviderStatus providerStatus;

        private CareerProfile careerProfile;

        private ProviderAssignment providerAssignment;


        public ProviderBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ProviderBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ProviderBuilder withStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public ProviderBuilder withAbn(String abn) {
            this.abn = abn;
            return this;
        }

        public ProviderBuilder withComments(String comments) {
            this.comments = comments;
            return this;
        }

        public ProviderBuilder withContactInfo(ContactInfo contactInfo) {
            this.contactInfo = contactInfo;
            return this;
        }

        public ProviderBuilder withProviderType(ProviderType providerType) {
            this.providerType = providerType;
            return this;
        }

        public ProviderBuilder withProviderStatus(ProviderStatus providerStatus) {
            this.providerStatus = providerStatus;
            return this;
        }

        public ProviderBuilder withCareerProfile(CareerProfile careerProfile) {
            this.careerProfile = careerProfile;
            return this;
        }

        public ProviderBuilder withProviderAssignment(ProviderAssignment providerAssignment) {
            this.providerAssignment = providerAssignment;
            return this;
        }


        @Override
        public Provider build() {
            return new Provider(this);
        }


    }


}
