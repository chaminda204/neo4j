package com.chaminda.neo4j.example.domain;

import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity(label = "Suburb")
public class Suburb extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private Long postcode;

    private String name;

    Suburb() {

    }

    private Suburb(SuburbBuilder suburbBuilder) {
        this.name = suburbBuilder.name;
        this.postcode = suburbBuilder.postcode;
    }

    public Long getPostcode() {
        return postcode;
    }

    public void setPostcode(Long postcode) {
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class SuburbBuilder implements Builder<Suburb> {

        private Long postcode;

        private String name;

        public SuburbBuilder withPostcode(Long postcode) {
            this.postcode = postcode;
            return this;
        }

        public SuburbBuilder withSuburbName(String suburbName) {
            this.name = suburbName;
            return this;
        }

        public Suburb build() {
            return new Suburb(this);
        }

    }


}
