package com.tufypace.yaedabot.metrica;

import com.tufypace.yaedabot.metrica.events.Event;
import com.tufypace.yaedabot.model.courierinfo.CourierInfo;

public interface MetricaHandler {
    void initProfile(String str, CourierInfo courierInfo);

    void publishAdjustEvent(String str);

    void publishEvent(String str, double latitude, double longitude);

    void publishEvent(Event event, double latitude, double longitude);

    void setCourierActivity(String str);

    void setCourierId(Integer num);

    void setOnlineStatus(boolean z);
}