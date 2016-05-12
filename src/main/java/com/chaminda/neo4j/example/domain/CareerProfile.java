package com.chaminda.neo4j.example.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "CareerProfile")
public class CareerProfile extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String cvSummary;

    private String spacialityDescription;

    private String workSiteExperience;

    @Relationship(type = "SPECILISED_IN")
    private List<Speciality> specialties;

    @Relationship(type = "INTERESTED_IN")
    private List<Interest> interests;

    @Relationship(type = "HAS_COMPLETED")
    private List<Course> courses;

    CareerProfile() {

    }

    private CareerProfile(CareerProfileBuilder careerProfileBuilder) {
        this.cvSummary = careerProfileBuilder.cvSummary;
        this.spacialityDescription = careerProfileBuilder.spacialityDescription;
        this.workSiteExperience = careerProfileBuilder.workSiteExperience;
        this.specialties = careerProfileBuilder.specialties;
        this.interests = careerProfileBuilder.interests;
        this.courses = careerProfileBuilder.courses;
    }

    public String getCvSummary() {
        return cvSummary;
    }

    public void setCvSummary(String cvSummary) {
        this.cvSummary = cvSummary;
    }

    public String getSpacialityDescription() {
        return spacialityDescription;
    }

    public void setSpacialityDescription(String spacialityDescription) {
        this.spacialityDescription = spacialityDescription;
    }


    public String getWorkSiteExperience() {
        return workSiteExperience;
    }

    public void setWorkSiteExperience(String workSiteExperience) {
        this.workSiteExperience = workSiteExperience;
    }

    public List<Speciality> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Speciality> specialties) {
        this.specialties = specialties;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public static class CareerProfileBuilder implements Builder<CareerProfile> {

        private String cvSummary;

        private String spacialityDescription;

        private String workSiteExperience;

        private List<Speciality> specialties;

        private List<Interest> interests;

        private List<Course> courses;

        public CareerProfileBuilder() {
            specialties = new ArrayList<Speciality>();
            interests = new ArrayList<Interest>();
            courses = new ArrayList<Course>();
        }

        public CareerProfileBuilder withCvSummary(String cvSummary) {
            this.cvSummary = cvSummary;
            return this;
        }

        public CareerProfileBuilder withSpacialityDescription(String spacialityDescription) {
            this.spacialityDescription = spacialityDescription;
            return this;
        }


        public CareerProfileBuilder withWorkSiteExperience(String workSiteExperience) {
            this.workSiteExperience = workSiteExperience;
            return this;
        }

        public CareerProfileBuilder withSpecialties(Speciality specialtie) {
            this.specialties.add(specialtie);
            return this;
        }

        public CareerProfileBuilder withInterests(Interest interest) {
            this.interests.add(interest);
            return this;
        }

        public CareerProfileBuilder withCourse(Course course) {
            this.courses.add(course);
            return this;
        }


        @Override
        public CareerProfile build() {
            return new CareerProfile(this);
        }

    }

}
