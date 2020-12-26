package com.tufypace.yaedabot.model.courierinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourierRegion {
    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
}
