package com.chaminda.neo4j.example.domain;

import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity(label = "Speciality")
public class Speciality extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String specialtyCode;

    private String description;

    public Speciality() {

    }

    private Speciality(SpecialityBuilder specialityBuilder) {
        this.specialtyCode = specialityBuilder.specialtyCode;
        this.description = specialityBuilder.description;
    }

    public String getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialtyCode(String specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class SpecialityBuilder implements Builder<Speciality> {

        private String specialtyCode;

        private String description;

        public SpecialityBuilder withSpecialityCode(String specialityCode) {
            this.specialtyCode = specialityCode;
            return this;
        }

        public SpecialityBuilder withSpecialityDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public Speciality build() {
            return new Speciality(this);
        }

    }

}
