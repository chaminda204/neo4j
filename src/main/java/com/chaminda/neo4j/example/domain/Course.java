package com.chaminda.neo4j.example.domain;

import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Date;

@NodeEntity(label = "Course")
public class Course extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String courseCode;

    private String courseDescription;

    private Date dateCompleted;

    Course() {

    }

    private Course(CourseBuilder courseBuilder) {
        this.courseCode = courseBuilder.courseCode;
        this.courseDescription = courseBuilder.courseDescription;
        this.dateCompleted = courseBuilder.dateCompleted;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public static class CourseBuilder implements Builder<Course> {

        private String courseCode;

        private String courseDescription;

        private Date dateCompleted;

        public CourseBuilder withCourseCode(String courseCode) {
            this.courseCode = courseCode;
            return this;
        }

        public CourseBuilder withCourseDescription(String courseDescription) {
            this.courseDescription = courseDescription;
            return this;
        }

        public CourseBuilder withDateComplated(Date dateCompleted) {
            this.dateCompleted = dateCompleted;
            return this;
        }

        @Override
        public Course build() {
            return new Course(this);
        }

    }

}
