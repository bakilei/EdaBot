package com.tufypace.yaedabot.model.restoraunt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EcoPackagingFeature {
    @JsonProperty("show")
    private boolean a;

    public EcoPackagingFeature(boolean a) {
        this.a = a;
    }

    public EcoPackagingFeature() {
        super();
    }
}
