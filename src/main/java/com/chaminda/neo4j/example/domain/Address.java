package com.chaminda.neo4j.example.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@NodeEntity(label = "Address")
public class Address extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String streetNo;

    private String streetName;

    private String propertyName;

    @Relationship(type = "WITHIN")
    private Suburb suburb;

    Address() {

    }

    private Address(AddressBuilder addressBuilder) {
        this.streetNo = addressBuilder.streetNo;
        this.streetName = addressBuilder.streetName;
        this.propertyName = addressBuilder.propertyName;
        this.suburb = addressBuilder.suburb;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Suburb getSuburb() {
        return suburb;
    }

    public void setSuburb(Suburb suburb) {
        this.suburb = suburb;
    }

    public static class AddressBuilder implements Builder<Address> {

        private String streetNo;

        private String streetName;

        private String propertyName;

        private Suburb suburb;

        public AddressBuilder withStreetNo(String streetNo) {
            this.streetNo = streetNo;
            return this;
        }

        public AddressBuilder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public AddressBuilder withPropertyName(String propertyName) {
            this.propertyName = propertyName;
            return this;
        }

        public AddressBuilder withSuburb(Suburb suburb) {
            this.suburb = suburb;
            return this;
        }

        @Override
        public Address build() {
            return new Address(this);
        }

    }

}
