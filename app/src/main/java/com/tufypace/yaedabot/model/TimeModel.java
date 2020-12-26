package com.tufypace.yaedabot.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironz.binaryprefs.serialization.serializer.persistable.Persistable;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataInput;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataOutput;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeModel implements Comparable<TimeModel>, Persistable {
    @JsonProperty("time")
    public long time;

    public TimeModel(long time) {
        this.time = time;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeModel timeModel = (TimeModel) o;
        return time == timeModel.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TimeModel{" +
                "time=" + time +
                '}';
    }

    public TimeModel() {
        super();
    }

    @Override
    public void writeExternal(DataOutput dataOutput) {

    }

    @Override
    public void readExternal(DataInput dataInput) {

    }

    @Override
    public Persistable deepClone() {
        return null;
    }

    @Override
    public int compareTo(TimeModel o) {
        return this.time > o.time ? -1 : 1;
    }

}
