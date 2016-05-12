package com.chaminda.neo4j.example.domain;

import org.neo4j.ogm.annotation.NodeEntity;



@NodeEntity(label = "ProviderType")
public class ProviderType extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String typeCode;

    private String description;

    ProviderType() {

    }

    private ProviderType(ProviderTypeBuilder ptoviderTypeBuilder) {
        this.typeCode = ptoviderTypeBuilder.typeCode;
        this.description = ptoviderTypeBuilder.description;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class ProviderTypeBuilder implements Builder<ProviderType> {

        private String typeCode;

        private String description;

        public ProviderTypeBuilder withTypeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public ProviderTypeBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public ProviderType build() {
            return new ProviderType(this);
        }

    }


}
