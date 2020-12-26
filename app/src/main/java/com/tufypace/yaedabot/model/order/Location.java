package com.tufypace.yaedabot.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tufypace.yaedabot.utils.Utils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private static int COORDINATES_MAX_LENGTH = 6;

    public Float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Float accuracy) {
        this.accuracy = accuracy;
    }

    public Boolean getFakeGPS() {
        return fakeGPS;
    }

    public void setFakeGPS(Boolean fakeGPS) {
        this.fakeGPS = fakeGPS;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getLocationProvider() {
        return locationProvider;
    }

    public void setLocationProvider(String locationProvider) {
        this.locationProvider = locationProvider;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("accuracy")
    public Float accuracy;
    @JsonProperty("fakeGPS")
    public Boolean fakeGPS = false;
    @JsonProperty("latitude")
    public Double latitude;
    @JsonProperty("locationProvider")
    public String locationProvider;
    @JsonProperty("longitude")
    public Double longitude;

    public Location() {
        super();
    }

    public Location(double d2, double d3, float f2, String str) {
        this.latitude = Utils.getFormattedDouble(d2, COORDINATES_MAX_LENGTH);
        this.longitude = Utils.getFormattedDouble(d3, COORDINATES_MAX_LENGTH);
        this.accuracy = f2;
        this.locationProvider = str;
        //     realmSet$latitude(Utils.getFormattedDouble(d2, COORDINATES_MAX_LENGTH));
        //     realmSet$longitude(Utils.getFormattedDouble(d3, COORDINATES_MAX_LENGTH));
        //     realmSet$accuracy(f2);
        //     realmSet$locationProvider(str);
    }

    public Location(double d2, double d3, float f2, boolean z, String str) {
        this.latitude = Utils.getFormattedDouble(d2, COORDINATES_MAX_LENGTH);
        this.longitude = Utils.getFormattedDouble(d3, COORDINATES_MAX_LENGTH);
        this.accuracy = f2;
        this.locationProvider = str;
        this.fakeGPS = false;
    }

}
