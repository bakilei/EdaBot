package com.tufypace.yaedabot.metrica.events;

import com.tufypace.yaedabot.metrica.MetricaParams;

import java.util.HashMap;

import kotlin.jvm.internal.Intrinsics;

public class OrderRemovedEvent implements Event {
    private final String orderNumber;
    private final int shiftId;
    private final String type;

    public OrderRemovedEvent(String str, int i, String str2) {
        Intrinsics.checkNotNull(str, "orderNumber");
        Intrinsics.checkNotNull(str2, "type");
        this.orderNumber = str;
        this.shiftId = i;
        this.type = str2;
    }

    public String getTitle() {
        return MetricaParams.EventTitles.EVENT_ORDER_REMOVED;
    }

    public HashMap<String, Object> getAttrs() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(MetricaParams.EventAttributes.ATTR_ORDER_ID, this.orderNumber);
        hashMap.put("shiftId", this.shiftId);
        hashMap.put(MetricaParams.EventAttributes.ATTR_TYPE_REMOVE_ORDER, this.type);
        return hashMap;
    }
}