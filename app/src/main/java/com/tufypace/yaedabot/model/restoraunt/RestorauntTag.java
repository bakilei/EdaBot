package com.tufypace.yaedabot.model.restoraunt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestorauntTag {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

    public RestorauntTag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public RestorauntTag() {
        super();
    }
}
