package com.tufypace.yaedabot.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironz.binaryprefs.serialization.serializer.persistable.Persistable;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataInput;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataOutput;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Place implements Persistable {
    @JsonProperty("address")
    public Address address;
    @JsonProperty("name")
    public String name;
    @JsonProperty("phoneNumbers")
    public List<String> phoneNumbers;
    @JsonProperty("supportsStatusFlow")
    public boolean supportsStatusFlow;


    public Place() {
        super();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return supportsStatusFlow == place.supportsStatusFlow &&
                address.equals(place.address) &&
                name.equals(place.name) &&
                phoneNumbers.equals(place.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, name, phoneNumbers, supportsStatusFlow);
    }

    @Override
    public String toString() {
        return "Place{" +
                "address=" + address +
                ", name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", supportsStatusFlow=" + supportsStatusFlow +
                '}';
    }

    public Place(Address address, String name, List<String> phoneNumbers, boolean supportsStatusFlow) {
        this.address = address;
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.supportsStatusFlow = supportsStatusFlow;
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
}
