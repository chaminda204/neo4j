package com.chaminda.neo4j.example.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@NodeEntity(label = "Practice")
public class Practice extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String practiceName;

    @Relationship(type = "LOCATED_AT")
    private Address practiceAddress;

    @Relationship(type = "CONTACTABLE")
    private ContactInfo contactInfo;

    Practice() {

    }

    private Practice(PracticeBuilder practiceBuilder) {
        this.practiceName = practiceBuilder.practiceName;
        this.practiceAddress = practiceBuilder.practiceAddress;
        this.contactInfo = practiceBuilder.contactInfo;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    public Address getPracticeAddress() {
        return practiceAddress;
    }

    public void setPracticeAddress(Address practiceAddress) {
        this.practiceAddress = practiceAddress;
    }


    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }


    public static class PracticeBuilder implements Builder<Practice> {

        private String practiceName;

        private Address practiceAddress;

        private ContactInfo contactInfo;

        public PracticeBuilder withPracticeName(String practiceName) {
            this.practiceName = practiceName;
            return this;
        }

        public PracticeBuilder withPracticeAddress(Address practiceAddress) {
            this.practiceAddress = practiceAddress;
            return this;
        }

        public PracticeBuilder withContactInfo(ContactInfo contactInfo) {
            this.contactInfo = contactInfo;
            return this;
        }

        @Override
        public Practice build() {
            return new Practice(this);
        }

    }


}
