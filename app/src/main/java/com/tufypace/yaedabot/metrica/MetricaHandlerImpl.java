package com.tufypace.yaedabot.metrica;

import android.location.Location;
import android.os.Build;
import android.provider.Settings;

import com.tufypace.yaedabot.Application;
import com.tufypace.yaedabot.metrica.events.Event;
import com.tufypace.yaedabot.model.courierinfo.CourierInfo;
import com.tufypace.yaedabot.net.LocationProvider;
import com.tufypace.yaedabot.utils.DateUtils;
import com.tufypace.yaedabot.utils.NetworkUtils;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.profile.Attribute;
import com.yandex.metrica.profile.UserProfile;

import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

import kotlin.jvm.internal.Intrinsics;

public final class MetricaHandlerImpl implements MetricaHandler {
    public String activityType;
    public Integer courierId;
    public boolean isOnline = true;
    public final LocationProvider locationProvider;
    public boolean profileIsReported;

    public MetricaHandlerImpl(LocationProvider locationProvider2) {
        Intrinsics.checkFieldIsNotNull(locationProvider2, MetricaParams.EventAttributes.ATTR_LOCATION_PROVIDER);
        this.locationProvider = locationProvider2;
    }


    private final boolean isFlightMode() {
        Application instance = Application.getInstance();
        //  Intrinsics.areEqual((Object) instance, "BigfoodCourierApp.getInstance()");
        return Settings.System.getInt(instance.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public void initProfile(String login, CourierInfo courierInfo) {
        // Intrinsics.checkNotNull("", "login");
        Intrinsics.checkNotNull(courierInfo.billingType, "billingType");
        Intrinsics.checkNotNull(courierInfo.getType(), MetricaParams.EventAttributes.ATTR_COURIER_TYPE);
        Intrinsics.checkNotNull(courierInfo.getStatus(), MetricaParams.EventAttributes.ATTR_COURIER_STATUS);
        if (!(login.length() == 0)) {
            String currentDate = DateUtils.getCurrentDate("ZZ");
            UserProfile.Builder b2 = com.yandex.metrica.profile.UserProfile.newBuilder();
            b2.apply(Attribute.customString(MetricaParams.EventAttributes.ATTR_TIME_ZONE).withValue(currentDate));
            b2.apply(Attribute.name().withValue("Олег Куракин"));
            b2.apply(Attribute.customString(MetricaParams.EventAttributes.ATTR_COURIER_TYPE).withValue(courierInfo.getType()));
            b2.apply(Attribute.customString(MetricaParams.EventAttributes.ATTR_COURIER_BILLING_TYPE).withValue(courierInfo.billingType));
            b2.apply(Attribute.customString(MetricaParams.EventAttributes.ATTR_COURIER_STATUS).withValue(courierInfo.getStatus()));
            UserProfile a = b2.build();
            Intrinsics.areEqual((Object) a, "UserProfile.newBuilder()…\n                .build()");
            YandexMetrica.reportUserProfile(a);
            this.profileIsReported = true;
        }
    }

    public void publishAdjustEvent(String str) {
        Intrinsics.checkFieldIsNotNull(str, "eventTitle");
        //    sendAdjust(str, new HashMap());
    }

    public void publishEvent(String str, double latitude, double longitude) {
        Intrinsics.checkFieldIsNotNull(str, "eventTitle");
        publishEvent(str, new HashMap<>(), latitude, longitude);
    }

    public void setCourierActivity(String str) {
        Intrinsics.checkFieldIsNotNull(str, MetricaParams.EventAttributes.ATTR_ACTIVITY_TYPE);
        this.activityType = str;
    }

    public void setCourierId(Integer num) {
        this.courierId = num;
    }

    public void setOnlineStatus(boolean z) {
        this.isOnline = z;
    }

    public void publishEvent(Event event, double latitude, double longitude) {
        Intrinsics.checkFieldIsNotNull(event, "event");
        publishEvent(event.getTitle(), event.getAttrs(), latitude, longitude);
    }


    private final void publishEvent(String str, Map<String, Object> map, double latitude, double longitude) {
        String str2;
        if (!(str.length() == 0)) {
            String a = DateTime.now().toString("kk:mm:ss:SSS dd.MM.YYYY");
            Intrinsics.areEqual((Object) a, "DateTime.now().toString(\"kk:mm:ss:SSS dd.MM.YYYY\")");
            map.put(MetricaParams.EventAttributes.ATTR_EVENT_TIME, a);
            String connectivityStatusString = NetworkUtils.getConnectivityStatusString();
            Intrinsics.areEqual((Object) connectivityStatusString, "NetworkUtils.getConnectivityStatusString()");
            map.put(MetricaParams.EventAttributes.ATTR_CONNECTION_STATE, connectivityStatusString);
            map.put(MetricaParams.EventAttributes.ATTR_TIME_DIFF, DateUtils.getTimeDiff());
            map.put(MetricaParams.EventAttributes.ATTR_ONLINE_STATUS, true);
            Integer num = this.courierId;
            if (num != null) {
                map.put(MetricaParams.EventAttributes.ATTR_COURIER_ID, num);
            }
            if (!map.containsKey(MetricaParams.EventAttributes.ATTR_ACTIVITY_TYPE) && (str2 = this.activityType) != null) {
                map.put(MetricaParams.EventAttributes.ATTR_ACTIVITY_TYPE, str2);
            }
            Location lastKnownLocation = this.locationProvider.getLastKnownLocation();
            if (lastKnownLocation != null) {
                map.put(MetricaParams.EventAttributes.ATTR_USER_COORDINATES, latitude + ", " + longitude);
                String provider = lastKnownLocation.getProvider();
                Intrinsics.areEqual(provider, "location.provider");
                map.put(MetricaParams.EventAttributes.ATTR_LOCATION_PROVIDER, provider);
                if (Build.VERSION.SDK_INT >= 18) {
                    map.put(MetricaParams.EventAttributes.ATTR_FAKE_GEO, false);
                }
            }
            if (Build.VERSION.SDK_INT >= 17) {
                map.put(MetricaParams.EventAttributes.ATTR_FLIGHT_MODE, false);
            }
            YandexMetrica.reportEvent(str, map);
        }
    }
}