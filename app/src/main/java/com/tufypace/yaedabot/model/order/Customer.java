package com.tufypace.yaedabot.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironz.binaryprefs.serialization.serializer.persistable.Persistable;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataInput;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataOutput;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer implements Persistable {
    @JsonProperty("address")
    public Address address;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("phoneNumber")
    public String phoneNumber;

    public Customer(Address address, String firstName, String lastName, String phoneNumber) {
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


    public Customer() {
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
}
