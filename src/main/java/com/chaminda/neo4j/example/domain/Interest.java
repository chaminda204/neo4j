package com.chaminda.neo4j.example.domain;

import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity(label = "Interest")
public class Interest extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String code;

    private String description;

    Interest() {
    }

    private Interest(InterestBuilder interestBuilder) {
        this.code = interestBuilder.code;
        this.description = interestBuilder.description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class InterestBuilder implements Builder<Interest> {

        private String code;

        private String description;

        public InterestBuilder withCode(String code) {
            this.code = code;
            return this;
        }

        public InterestBuilder withDescription(String description) {
            this.description = description;
            return this;
        }


        @Override
        public Interest build() {
            return new Interest(this);
        }

    }

}
