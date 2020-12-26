package com.tufypace.yaedabot.model.restoraunt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceCategory {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private double value;

    public PriceCategory(long id, String name, double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public PriceCategory() {
        super();
    }
}
