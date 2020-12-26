package com.tufypace.yaedabot.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class StartUnplannedShiftOperation {
    @JsonProperty("id")
    public final String id;
    @JsonProperty("location")
    public final ShiftLocation location;
    @JsonProperty("duration")
    public final Integer duration;
    @JsonProperty("ignoreWarnings")
    public boolean ignoreWarnings;

    public StartUnplannedShiftOperation(String id, ShiftLocation location, Integer duration, boolean ignoreWarnings) {

        this.id = id;
        this.location = location;
        this.duration = duration;
        this.ignoreWarnings = ignoreWarnings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartUnplannedShiftOperation that = (StartUnplannedShiftOperation) o;
        return ignoreWarnings == that.ignoreWarnings &&
                duration.equals(that.duration) &&
                id.equals(that.id) &&
                location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, id, ignoreWarnings, location);
    }

    @Override
    public String toString() {
        return "StartUnplannedShiftOperation{" +
                "duration=" + duration +
                ", id='" + id + '\'' +
                ", ignoreWarnings=" + ignoreWarnings +
                ", location=" + location +
                '}';
    }
}
