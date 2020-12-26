package com.tufypace.yaedabot.model.responses;

import com.google.gson.annotations.SerializedName;
import com.tufypace.yaedabot.model.shift.CourierShift;
import com.tufypace.yaedabot.model.shift.OpenedCourierShift;

import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public final class ListShiftResponse {
    @SerializedName("closed")
    private final List<CourierShift> closed;
    @SerializedName("opened")
    private final List<OpenedCourierShift> opened;

    public ListShiftResponse(List<OpenedCourierShift> list, List<CourierShift> list2) {
        Intrinsics.checkNotNull(list, "opened");
        Intrinsics.checkNotNull(list2, "closed");
        this.opened = list;
        this.closed = list2;
    }

    public static ListShiftResponse copy$default(ListShiftResponse listShiftResponse, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listShiftResponse.opened;
        }
        if ((i & 2) != 0) {
            list2 = listShiftResponse.closed;
        }
        return listShiftResponse.copy(list, list2);
    }

    public final List<OpenedCourierShift> component1() {
        return this.opened;
    }

    public final List<CourierShift> component2() {
        return this.closed;
    }

    public final ListShiftResponse copy(List<OpenedCourierShift> list, List<CourierShift> list2) {
        Intrinsics.checkNotNull(list, "opened");
        Intrinsics.checkNotNull(list2, "closed");
        return new ListShiftResponse(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListShiftResponse)) {
            return false;
        }
        ListShiftResponse listShiftResponse = (ListShiftResponse) obj;
        return Intrinsics.areEqual(this.opened, listShiftResponse.opened) && Intrinsics.areEqual(this.closed, listShiftResponse.closed);
    }

    public final List<CourierShift> getClosed() {
        return this.closed;
    }

    public final List<OpenedCourierShift> getOpened() {
        return this.opened;
    }

    @Override
    public int hashCode() {
        List<OpenedCourierShift> list = this.opened;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<CourierShift> list2 = this.closed;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    @Override
    public String toString() {
        return "ListShiftResponse(opened=" + this.opened + ", closed=" + this.closed + ")";
    }
}
