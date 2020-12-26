package com.tufypace.yaedabot.model.restoraunt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryTimeInterval {
    @JsonProperty("min")
    private Integer min;
    @JsonProperty("max")
    private Integer max;

    public DeliveryTimeInterval(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    public DeliveryTimeInterval() {
        super();
    }
}

