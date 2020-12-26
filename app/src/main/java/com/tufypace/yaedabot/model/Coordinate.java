package com.tufypace.yaedabot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tufypace.yaedabot.model.order.Location;
import com.tufypace.yaedabot.utils.DateUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinate {
    @JsonProperty("location")
    private Location location;
    @JsonProperty("date")
    private String date = DateUtils.ISOCurrentDate();


    public Coordinate(double d2, double d3, float f2, boolean z, String str) {
        this.location = new Location(d2, d3, f2, z, str);
    }

    public String getDate() {
        return this.date;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setLocation(Location location2) {
        this.location = location2;
    }
}
