package com.tufypace.yaedabot.metrica.events;

import com.tufypace.yaedabot.metrica.MetricaParams;
import com.tufypace.yaedabot.model.order.OrderModel;

import java.util.HashMap;

import kotlin.jvm.internal.Intrinsics;

public class OrderEvent implements Event {

    private final HashMap<String, Object> attrs;
    private String title;


    public OrderEvent(String str, OrderModel orderModel) {
        Intrinsics.checkNotNull(str, "title");
        Intrinsics.checkNotNull(orderModel, "order");
        this.title = str;
        HashMap<String, Object> hashMap = new HashMap<>();
        String orderNumber = orderModel.orderNumber;
        Intrinsics.areEqual((Object) orderNumber, "order.orderNumber");
        hashMap.put(MetricaParams.EventAttributes.ATTR_ORDER_ID, orderNumber);
        String status = orderModel.status;
        Intrinsics.areEqual((Object) status, "order.status");
        hashMap.put(MetricaParams.EventAttributes.ATTR_ORDER_STATUS, status);
        this.attrs = hashMap;
    }

    public String getTitle() {
        return this.title;
    }

    public HashMap<String, Object> getAttrs() {
        return this.attrs;
    }
}
