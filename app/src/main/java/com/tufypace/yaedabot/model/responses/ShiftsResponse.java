package com.tufypace.yaedabot.model.responses;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.Intrinsics;

public final class ShiftsResponse {
    @SerializedName("data")
    private final ListShiftResponse data;

    public ShiftsResponse(ListShiftResponse listShiftResponse) {
        Intrinsics.checkNotNull(listShiftResponse, "data");
        this.data = listShiftResponse;
    }

    public static ShiftsResponse copy$default(ShiftsResponse shiftsResponse, ListShiftResponse listShiftResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            listShiftResponse = shiftsResponse.data;
        }
        return shiftsResponse.copy(listShiftResponse);
    }

    public final ListShiftResponse component1() {
        return this.data;
    }

    public final ShiftsResponse copy(ListShiftResponse listShiftResponse) {
        Intrinsics.checkNotNull(listShiftResponse, "data");
        return new ShiftsResponse(listShiftResponse);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ShiftsResponse) && Intrinsics.areEqual(this.data, ((ShiftsResponse) obj).data);
        }
        return true;
    }

    public final ListShiftResponse getData() {
        return this.data;
    }

    @Override
    public int hashCode() {
        ListShiftResponse listShiftResponse = this.data;
        if (listShiftResponse != null) {
            return listShiftResponse.hashCode();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ShiftsResponse(data=" + this.data + ")";
    }
}
