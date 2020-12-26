package com.tufypace.yaedabot.model.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironz.binaryprefs.serialization.serializer.persistable.Persistable;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataInput;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataOutput;

import java.util.List;

public class RemovedOrder implements Persistable {
    @JsonProperty("orders")
    public List<OrderModel> orders;

    public Persistable a() {
        return this;
    }

    public void a(List<OrderModel> list) {
        this.orders = list;
    }

    public List<OrderModel> b() {
        return this.orders;
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