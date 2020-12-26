package com.tufypace.yaedabot.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironz.binaryprefs.serialization.serializer.persistable.Persistable;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataInput;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataOutput;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartItem implements Persistable {
    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    //    @Expose
    @JsonProperty("optionsGroups")
    public List<OptionsGroup> optionsGroups;
    @JsonProperty("price")
    public Integer price;
    @JsonProperty("quantity")
    public Integer quantity;

    public CartItem(String id, String name, List<OptionsGroup> optionsGroups, Integer price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.optionsGroups = optionsGroups;
        this.price = price;
        this.quantity = quantity;
    }

    public CartItem() {
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
