package com.tufypace.yaedabot.model.shift;

import kotlin.jvm.internal.Intrinsics;

public class CourierShiftEventAttributes {
    public final String createdAt;
    public final String eventSource;
    public final String eventType;
    public final double latitude;
    public final double longitude;

    public CourierShiftEventAttributes(String str, String str2, double d2, double d3, String timeModel) {
        Intrinsics.checkFieldIsNotNull(str, "eventType");
        Intrinsics.checkFieldIsNotNull(str2, "eventSource");
        Intrinsics.checkFieldIsNotNull(timeModel, "createdAt");
        this.eventType = str;
        this.eventSource = str2;
        this.latitude = d2;
        this.longitude = d3;
        this.createdAt = timeModel;
    }

    public static CourierShiftEventAttributes copy$default(CourierShiftEventAttributes courierShiftEventAttributes, String str, String str2, double d2, double d3, String timeModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = courierShiftEventAttributes.eventType;
        }
        if ((i & 2) != 0) {
            str2 = courierShiftEventAttributes.eventSource;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            d2 = courierShiftEventAttributes.latitude;
        }
        double d4 = d2;
        if ((i & 8) != 0) {
            d3 = courierShiftEventAttributes.longitude;
        }
        double d5 = d3;
        if ((i & 16) != 0) {
            //      timeModel = courierShiftEventAttributes.createdAt;
        }
        return courierShiftEventAttributes.copy(str, str3, d4, d5, timeModel);
    }

    public final String component1() {
        return this.eventType;
    }

    public final String component2() {
        return this.eventSource;
    }

    public final double component3() {
        return this.latitude;
    }

    public final double component4() {
        return this.longitude;
    }

    public final String component5() {
        return this.createdAt;
    }

    public final CourierShiftEventAttributes copy(String str, String str2, double d2, double d3, String timeModel) {
        Intrinsics.checkFieldIsNotNull(str, "eventType");
        Intrinsics.checkFieldIsNotNull(str2, "eventSource");
        String timeModel2 = timeModel;
        Intrinsics.checkFieldIsNotNull(timeModel2, "createdAt");
        return new CourierShiftEventAttributes(str, str2, d2, d3, timeModel2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourierShiftEventAttributes)) {
            return false;
        }
        CourierShiftEventAttributes courierShiftEventAttributes = (CourierShiftEventAttributes) obj;
        return Intrinsics.areEqual((Object) this.eventType, (Object) courierShiftEventAttributes.eventType) && Intrinsics.areEqual((Object) this.eventSource, (Object) courierShiftEventAttributes.eventSource) && Double.compare(this.latitude, courierShiftEventAttributes.latitude) == 0 && Double.compare(this.longitude, courierShiftEventAttributes.longitude) == 0 && Intrinsics.areEqual((Object) this.createdAt, (Object) courierShiftEventAttributes.createdAt);
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getEventSource() {
        return this.eventSource;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        String str = this.eventType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.eventSource;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        int i2 = (((((hashCode + hashCode2) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        String timeModel = this.createdAt;
        if (timeModel != null) {
            i = timeModel.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "CourierShiftEventAttributes(eventType=" + this.eventType + ", eventSource=" + this.eventSource + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", createdAt=" + this.createdAt + ")";
    }
}
