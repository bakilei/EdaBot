package com.tufypace.yaedabot.model.restoraunt;

public abstract class RestorauntBaseResponse<PAYLOAD, META> {

    public META meta;
    public PAYLOAD payload;

    public META getMeta() {
        return this.meta;
    }

    public PAYLOAD getPayload() {
        return this.payload;
    }


    public void setMeta(META meta2) {
        this.meta = meta2;
    }

    public void setPayload(PAYLOAD payload2) {
        this.payload = payload2;
    }


}
