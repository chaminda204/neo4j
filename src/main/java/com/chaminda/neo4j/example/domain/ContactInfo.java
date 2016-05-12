package com.chaminda.neo4j.example.domain;

import org.neo4j.ogm.annotation.NodeEntity;



@NodeEntity(label = "ContactInfo")
public class ContactInfo extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String telephone;

    private String mobile;

    private String fax;

    private String email;

    private String website;

    ContactInfo() {

    }

    private ContactInfo(ContactInfoBuilder contactInfoBuilder) {
        this.telephone = contactInfoBuilder.telephone;
        this.mobile = contactInfoBuilder.mobile;
        this.fax = contactInfoBuilder.fax;
        this.email = contactInfoBuilder.email;
        this.website = contactInfoBuilder.website;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public static class ContactInfoBuilder implements Builder<ContactInfo> {

        private String telephone;

        private String mobile;

        private String fax;

        private String email;

        private String website;

        public ContactInfoBuilder withTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public ContactInfoBuilder withMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public ContactInfoBuilder withFax(String fax) {
            this.fax = fax;
            return this;
        }

        public ContactInfoBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ContactInfoBuilder withWebsite(String website) {
            this.website = website;
            return this;
        }

        @Override
        public ContactInfo build() {
            return new ContactInfo(this);
        }

    }

}
