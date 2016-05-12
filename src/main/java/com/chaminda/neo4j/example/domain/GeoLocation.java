package com.chaminda.neo4j.example.domain;

public class GeoLocation extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private double latitude;

    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
