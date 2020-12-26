package com.tufypace.yaedabot.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import kotlin.jvm.internal.Intrinsics;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTransition {
    @JsonProperty("transition")
    public final String transition;

    public OrderTransition(String transition) {
        Intrinsics.checkFieldIsNotNull(transition, "transition");
        this.transition = transition;

    }

    @Override
    public String toString() {
        return "OrderTransition{" +
                "transition='" + transition + '\'' +
                '}';
    }
}
