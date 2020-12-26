package com.tufypace.yaedabot.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironz.binaryprefs.serialization.serializer.persistable.Persistable;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataInput;
import com.ironz.binaryprefs.serialization.serializer.persistable.io.DataOutput;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency implements Persistable {
    @JsonProperty("code")
    public String code;
    @JsonProperty("sign")
    public String sign;

    public Currency(String code, String sign) {
        this.code = code;
        this.sign = sign;
    }


    public Currency() {
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
