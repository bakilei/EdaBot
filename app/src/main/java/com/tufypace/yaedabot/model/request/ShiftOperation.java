package com.tufypace.yaedabot.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import kotlin.jvm.internal.Intrinsics;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShiftOperation {
    @JsonProperty("id")
    public final String id;
    @JsonProperty("ignoreWarnings")
    public final boolean ignoreWarnings;
    @JsonProperty("location")
    public final ShiftLocation location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShiftOperation that = (ShiftOperation) o;
        return ignoreWarnings == that.ignoreWarnings &&
                id.equals(that.id) &&
                location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ignoreWarnings, location);
    }


    public ShiftOperation(String id, boolean ignoreWarnings, ShiftLocation location) {
        super();
        this.id = id;
        this.ignoreWarnings = ignoreWarnings;
        this.location = location;
    }

    public ShiftOperation(String str, ShiftLocation shiftLocation, boolean z) {
        Intrinsics.checkNotNull(str, "id");
        Intrinsics.checkNotNull(shiftLocation, "location");
        this.id = str;
        this.location = shiftLocation;
        this.ignoreWarnings = z;
    }
}
