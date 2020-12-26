package com.tufypace.yaedabot.model.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import kotlin.jvm.internal.Intrinsics;

public final class ConfigPayload {
    @JsonProperty("features")
    private final ConfigFeatures features;

    public ConfigPayload(ConfigFeatures configFeatures) {
        Intrinsics.checkNotNull(configFeatures, "features");
        this.features = configFeatures;
    }

    public static ConfigPayload copy$default(ConfigPayload configPayload, ConfigFeatures configFeatures, int i, Object obj) {
        if ((i & 1) != 0) {
            configFeatures = configPayload.features;
        }
        return configPayload.copy(configFeatures);
    }

    public final ConfigFeatures component1() {
        return this.features;
    }

    public final ConfigPayload copy(ConfigFeatures configFeatures) {
        Intrinsics.checkFieldIsNotNull(configFeatures, "features");
        return new ConfigPayload(configFeatures);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ConfigPayload) && Intrinsics.areEqual((Object) this.features, (Object) ((ConfigPayload) obj).features);
        }
        return true;
    }

    public final ConfigFeatures getFeatures() {
        return this.features;
    }

    public int hashCode() {
        ConfigFeatures configFeatures = this.features;
        if (configFeatures != null) {
            return configFeatures.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ConfigPayload(features=" + this.features + ")";
    }
}
