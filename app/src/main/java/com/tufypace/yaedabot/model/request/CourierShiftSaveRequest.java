package com.tufypace.yaedabot.model.request;

import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public class CourierShiftSaveRequest {
    private final String id;
    private final List<FlatOpenedCourierShift> items;

    public CourierShiftSaveRequest(String str, List<FlatOpenedCourierShift> list) {
        Intrinsics.checkNotNull(str, "id");
        Intrinsics.checkNotNull(list, "items");
        this.id = str;
        this.items = list;
    }

    public static CourierShiftSaveRequest copy$default(CourierShiftSaveRequest courierShiftSaveRequest, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = courierShiftSaveRequest.id;
        }
        if ((i & 2) != 0) {
            list = courierShiftSaveRequest.items;
        }
        return courierShiftSaveRequest.copy(str, list);
    }

    public final String component1() {
        return this.id;
    }

    public final List<FlatOpenedCourierShift> component2() {
        return this.items;
    }

    public final CourierShiftSaveRequest copy(String str, List<FlatOpenedCourierShift> list) {
        Intrinsics.checkNotNull(str, "id");
        Intrinsics.checkNotNull(list, "items");
        return new CourierShiftSaveRequest(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourierShiftSaveRequest)) {
            return false;
        }
        CourierShiftSaveRequest courierShiftSaveRequest = (CourierShiftSaveRequest) obj;
        return Intrinsics.areEqual(this.id, courierShiftSaveRequest.id) && Intrinsics.areEqual(this.items, courierShiftSaveRequest.items);
    }

    public final String getId() {
        return this.id;
    }

    public final List<FlatOpenedCourierShift> getItems() {
        return this.items;
    }

    @Override
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FlatOpenedCourierShift> list = this.items;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @Override
    public String toString() {
        return "CourierShiftSaveRequest(id=" + this.id + ", items=" + this.items + ")";
    }
}
