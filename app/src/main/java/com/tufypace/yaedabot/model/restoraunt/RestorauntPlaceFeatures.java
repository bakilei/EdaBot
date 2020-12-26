package com.tufypace.yaedabot.model.restoraunt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestorauntPlaceFeatures {
    @JsonProperty("ecoPackaging")
    private EcoPackagingFeature ecoPackaging;

    public RestorauntPlaceFeatures(EcoPackagingFeature ecoPackaging) {
        this.ecoPackaging = ecoPackaging;
    }

    public RestorauntPlaceFeatures() {
        super();
    }
}
