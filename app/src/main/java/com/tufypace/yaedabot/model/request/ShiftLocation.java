package com.tufypace.yaedabot.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShiftLocation {
    @JsonProperty("latitude")
    public final double latitude;
    @JsonProperty("longitude")
    public final double longitude;

    public ShiftLocation(double d2, double d3) {
        this.latitude = d2;
        this.longitude = d3;
    }

    private final double component1() {
        return this.latitude;
    }

    private final double component2() {
        return this.longitude;
    }

    public static ShiftLocation copy$default(ShiftLocation shiftLocation, double d2, double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            d2 = shiftLocation.latitude;
        }
        if ((i & 2) != 0) {
            d3 = shiftLocation.longitude;
        }
        return shiftLocation.copy(d2, d3);
    }

    public final ShiftLocation copy(double d2, double d3) {
        return new ShiftLocation(d2, d3);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShiftLocation)) {
            return false;
        }
        ShiftLocation shiftLocation = (ShiftLocation) obj;
        return Double.compare(this.latitude, shiftLocation.latitude) == 0 && Double.compare(this.longitude, shiftLocation.longitude) == 0;
    }

    @Override
    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    @Override
    public String toString() {
        return "ShiftLocation(latitude=" + this.latitude + ", longitude=" + this.longitude + ")";
    }
}
