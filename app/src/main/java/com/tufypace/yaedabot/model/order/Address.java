package com.tufypace.yaedabot.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironz.binaryprefs.serialization.serializer.persistable.Persistable;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataInput;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataOutput;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address implements Persistable {
    @JsonProperty("comment")
    public String comment = "";
    @JsonProperty("doorcode")
    public String doorcode = "";
    @JsonProperty("entrance")
    public String entrance = "";
    @JsonProperty("floor")
    public String floor = "";
    @JsonProperty("location")
    public Location location;
    @JsonProperty("office")
    public String office = "";
    @JsonProperty("title")
    public String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(comment, address.comment) &&
                Objects.equals(doorcode, address.doorcode) &&
                Objects.equals(entrance, address.entrance) &&
                Objects.equals(floor, address.floor) &&
                Objects.equals(location, address.location) &&
                Objects.equals(office, address.office) &&
                Objects.equals(title, address.title);
    }

    public Address() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, doorcode, entrance, floor, location, office, title);
    }

    @Override
    public void writeExternal(DataOutput dataOutput) {

    }

    @Override
    public void readExternal(DataInput dataInput) {

    }

    public Address(String comment, String doorcode, String entrance, String floor, Location location, String office, String title) {
        this.comment = comment;
        this.doorcode = doorcode;
        this.entrance = entrance;
        this.floor = floor;
        this.location = location;
        this.office = office;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Address{" +
                "comment='" + comment + '\'' +
                ", doorcode='" + doorcode + '\'' +
                ", entrance='" + entrance + '\'' +
                ", floor='" + floor + '\'' +
                ", location=" + location +
                ", office='" + office + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public Persistable deepClone() {
        return null;
    }
}
