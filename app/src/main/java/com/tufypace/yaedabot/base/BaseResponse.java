package com.tufypace.yaedabot.base;

public abstract class BaseResponse<PAYLOAD, META> {
    //    @SerializedName("isSuccess")
    public boolean isSuccess;
    //    @SerializedName("meta")
    public META meta;
    //   @SerializedName("payload")
    public PAYLOAD payload;

    public META getMeta() {
        return this.meta;
    }

    public PAYLOAD getPayload() {
        return this.payload;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setMeta(META meta2) {
        this.meta = meta2;
    }

    public void setPayload(PAYLOAD payload2) {
        this.payload = payload2;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}