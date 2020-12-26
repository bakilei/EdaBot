package com.tufypace.yaedabot.model.restoraunt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ByLocation {
    @JsonProperty("deliveryTime")
    public DeliveryTimeInterval deliveryTime;
    @JsonProperty("available")
    public boolean available;
    @JsonProperty("distance")
    public Double distance;
    @JsonProperty("availableFrom")
    public String availableFrom;
    @JsonProperty("availableTo")
    public String availableTo;

    public ByLocation(DeliveryTimeInterval deliveryTime, boolean available, Double distance, String availableFrom, String availableTo) {
        this.deliveryTime = deliveryTime;
        this.available = available;
        this.distance = distance;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }

    public ByLocation() {
        super();
    }

    @Override
    public String toString() {
        return "ByLocation{" +
                "deliveryTime=" + deliveryTime +
                ", available=" + available +
                ", distance=" + distance +
                ", availableFrom='" + availableFrom + '\'' +
                ", availableTo='" + availableTo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ByLocation that = (ByLocation) o;
        return available == that.available &&
                Objects.equals(deliveryTime, that.deliveryTime) &&
                Objects.equals(distance, that.distance) &&
                Objects.equals(availableFrom, that.availableFrom) &&
                Objects.equals(availableTo, that.availableTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryTime, available, distance, availableFrom, availableTo);
    }
}

