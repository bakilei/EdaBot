package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public final class CourierShiftsActive {
    @SerializedName("data")
    public final List<CourierShift> data;

    public CourierShiftsActive(List<CourierShift> list) {
        Intrinsics.checkFieldIsNotNull(list, "data");
        this.data = list;
    }

    public static CourierShiftsActive copy$default(CourierShiftsActive courierShiftsActive, List<CourierShift> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = courierShiftsActive.data;
        }
        return courierShiftsActive.copy(list);
    }

    public final List<CourierShift> component1() {
        return this.data;
    }

    public final CourierShiftsActive copy(List<CourierShift> list) {
        Intrinsics.checkFieldIsNotNull(list, "data");
        return new CourierShiftsActive(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CourierShiftsActive) && Intrinsics.areEqual((Object) this.data, (Object) ((CourierShiftsActive) obj).data);
        }
        return true;
    }

    public final List<CourierShift> getData() {
        return this.data;
    }

    public int hashCode() {
        List<CourierShift> list = this.data;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CourierShiftsActive(data=" + this.data + ")";
    }
}
