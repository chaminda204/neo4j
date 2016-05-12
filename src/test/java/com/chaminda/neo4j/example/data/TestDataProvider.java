package com.chaminda.neo4j.example.data;

import com.chaminda.neo4j.example.domain.*;
import com.chaminda.neo4j.example.domain.Address.AddressBuilder;
import com.chaminda.neo4j.example.domain.CareerProfile.CareerProfileBuilder;
import com.chaminda.neo4j.example.domain.ContactInfo.ContactInfoBuilder;
import com.chaminda.neo4j.example.domain.Course.CourseBuilder;
import com.chaminda.neo4j.example.domain.Practice.PracticeBuilder;
import com.chaminda.neo4j.example.domain.Provider.ProviderBuilder;
import com.chaminda.neo4j.example.domain.ProviderAssignment.ProviderAssignmentBuilder;
import com.chaminda.neo4j.example.domain.ProviderType.ProviderTypeBuilder;
import com.chaminda.neo4j.example.domain.Speciality.SpecialityBuilder;
import com.chaminda.neo4j.example.domain.Suburb.SuburbBuilder;

import java.util.Date;

public class TestDataProvider {

    public static Provider getValidProviderWith(String firstName, String lastName, String comment) {
        return new ProviderBuilder()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withComments(comment)
                .withAbn("000 000 000")
                .withProviderStatus(ProviderStatus.PENDING)
                .withStartDate(new Date())
                .withContactInfo(newContactInfo())
                .withProviderType(newProviderType())
                .withCareerProfile(newCareerProfile())
                .withProviderAssignment(newProviderAssignment())
                .build();

    }

    public static CareerProfile newCareerProfile() {
        return new CareerProfileBuilder()
                .withCvSummary("Some CV Summary info")
                .withCourse(newCourse())
                .withInterests(newInterest())
                .withWorkSiteExperience("Some work site Experience")
                .withSpecialties(newSpecialityFor("sp-01", "some speciality"))
                .build();
    }


    private static Interest newInterest() {
        return new Interest.InterestBuilder()
                .withCode("In-01")
                .withDescription("some interest")
                .build();
    }

    private static Course newCourse() {
        return new CourseBuilder()
                .withCourseCode("co-01")
                .withCourseDescription("some course")
                .build();
    }

    public static Suburb newSuburbMountWaverley() {
        return new SuburbBuilder()
                .withPostcode(3149L)
                .withSuburbName("Mount Waverley")
                .build();
    }


    private static ProviderType newProviderType() {
        return new ProviderTypeBuilder()
                .withTypeCode("pr_1")
                .withDescription("provider type description")
                .build();
    }


    private static ContactInfo newContactInfo() {
        return new ContactInfoBuilder()
                .withEmail("someone@someCompany.com")
                .withFax("03 FAX ME")
                .withMobile("0404 555 555")
                .withTelephone("1800 CALL ME")
                .withWebsite("www.somecompany.com")
                .build();
    }


    public static Speciality newSpecialityFor(String specialityCode, String description) {
        return new SpecialityBuilder()
                .withSpecialityCode(specialityCode)
                .withSpecialityDescription(description)
                .build();
    }

    public static ProviderType newProviderTypeWith(String typeCode, String description) {
        return new ProviderTypeBuilder()
                .withTypeCode(typeCode)
                .withDescription(description)
                .build();
    }

    public static Practice newPractice() {
        return new PracticeBuilder().withPracticeAddress(newAddress())
                .withPracticeName("practice name")
                .withContactInfo(newContactInfo())
                .build();
    }

    public static Address newAddress() {
        return new AddressBuilder()
                .withPropertyName("propertyName")
                .withStreetNo("21")
                .withStreetName("some street name")
                .withSuburb(newSuburbMountWaverley())
                .build();
    }

    public static ProviderAssignment newProviderAssignment() {
        return new ProviderAssignmentBuilder()
                .withPrimary(true)
                .withPractice(newPractice())
                .build();
    }
}
