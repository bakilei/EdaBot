package com.tufypace.yaedabot.model.responses;

import com.tufypace.yaedabot.model.shift.StartPoint;

import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public final class DeliveryZonesResponse {
    private final List<StartPoint> data;

    public DeliveryZonesResponse(List<StartPoint> list) {
        Intrinsics.checkNotNull(list, "data");
        this.data = list;
    }

    public static DeliveryZonesResponse copy$default(DeliveryZonesResponse deliveryZonesResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = deliveryZonesResponse.data;
        }
        return deliveryZonesResponse.copy(list);
    }

    public final List<StartPoint> component1() {
        return this.data;
    }

    public final DeliveryZonesResponse copy(List<StartPoint> list) {
        Intrinsics.checkNotNull(list, "data");
        return new DeliveryZonesResponse(list);
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof DeliveryZonesResponse) && Intrinsics.areEqual(this.data, ((DeliveryZonesResponse) obj).data);
        }
        return true;
    }

    public final List<StartPoint> getData() {
        return this.data;
    }

    @Override
    public int hashCode() {
        List<StartPoint> list = this.data;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "DeliveryZonesResponse(data=" + this.data + ")";
    }
}