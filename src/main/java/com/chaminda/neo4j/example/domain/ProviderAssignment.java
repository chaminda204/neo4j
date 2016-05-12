package com.chaminda.neo4j.example.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.util.Date;

@RelationshipEntity(type = "ASSIGNED_TO")
public class ProviderAssignment extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Property
    private boolean isPrimary;

    @StartNode
    @JsonBackReference
    private Provider provider;

    @EndNode
    private Practice practice;

    @Property
    private Date startDate;

    ProviderAssignment() {

    }

    private ProviderAssignment(ProviderAssignmentBuilder providerAssignmentBuilder) {
        this.isPrimary = providerAssignmentBuilder.isPrimary;
        this.provider = providerAssignmentBuilder.provider;
        this.practice = providerAssignmentBuilder.practice;
        this.startDate = providerAssignmentBuilder.startDate;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public static class ProviderAssignmentBuilder implements Builder<ProviderAssignment> {

        private boolean isPrimary;

        private Provider provider;

        private Practice practice;

        private Date startDate;

        public ProviderAssignmentBuilder withPrimary(boolean isPrimary) {
            this.isPrimary = isPrimary;
            return this;
        }

        public ProviderAssignmentBuilder withProvider(Provider provider) {
            this.provider = provider;
            return this;
        }

        public ProviderAssignmentBuilder withPractice(Practice practice) {
            this.practice = practice;
            return this;
        }

        public ProviderAssignmentBuilder withStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        @Override
        public ProviderAssignment build() {

            return new ProviderAssignment(this);
        }

    }

}
