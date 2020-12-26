package com.tufypace.yaedabot.model.restoraunt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Carousel {

    @JsonProperty("place")
    public PlaceRestoraunt place;
    @JsonProperty("locationParams")
    public ByLocation locationParams;

    public Carousel(PlaceRestoraunt place, ByLocation locationParams) {

        this.place = place;
        this.locationParams = locationParams;
    }

    public Carousel() {
        super();
    }
}
