package com.tufypace.yaedabot.model.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import kotlin.jvm.internal.Intrinsics;

public class ConfigResponse {
    @JsonProperty("payload")
    private final ConfigPayload payload;

    public ConfigResponse(ConfigPayload configPayload) {
        Intrinsics.checkFieldIsNotNull(configPayload, "payload");
        this.payload = configPayload;
    }

    public final ConfigPayload getPayload() {
        return this.payload;
    }
}
