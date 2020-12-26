package com.tufypace.yaedabot.model.restoraunt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestorauntPromo {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("type")
    private RestorauntPromoType type;


    public RestorauntPromo(long id, String name, String description, RestorauntPromoType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public RestorauntPromo() {
        super();
    }
}
