package com.tufypace.yaedabot.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tufypace.yaedabot.model.Coordinate;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class LocationPushRequest {
    @JsonProperty("coordinates")
    public List<Coordinate> coordinates;

    public LocationPushRequest() {
        //     this((List) null, 1, (d) null);
    }

    public LocationPushRequest(ArrayList<Coordinate> list) {
        //      f.b(list, "coordinates");
        this.coordinates = list;
    }


}
