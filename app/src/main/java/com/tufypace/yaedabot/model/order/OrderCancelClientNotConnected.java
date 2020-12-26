package com.tufypace.yaedabot.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import kotlin.jvm.internal.Intrinsics;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCancelClientNotConnected {
    @JsonProperty("reason")
    public String reason;
    @JsonProperty("transition")
    public String transition;

    public OrderCancelClientNotConnected(String str, String str2) {
        super();
        Intrinsics.checkNotNull(str, "transition");
        Intrinsics.checkNotNull(str2, "reason");
        this.transition = str;
        this.reason = str2;
    }

    public OrderCancelClientNotConnected() {
        super();
    }

}
