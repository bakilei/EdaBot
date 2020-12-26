package com.tufypace.yaedabot.model.courierinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class EmployerPayload {
    public final String address;
    public final int id;
    public final String name;

    public EmployerPayload(String address, int id, String name) {
        this.address = address;
        this.id = id;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "EmployerPayload{" +
                "address='" + address + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployerPayload that = (EmployerPayload) o;
        return id == that.id &&
                address.equals(that.address) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
