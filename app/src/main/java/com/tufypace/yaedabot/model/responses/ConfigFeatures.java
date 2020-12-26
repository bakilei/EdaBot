package com.tufypace.yaedabot.model.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import kotlin.jvm.internal.Intrinsics;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class ConfigFeatures {
    @JsonProperty("activity-tracking")
    private final String activityTracking;
    @JsonProperty("anomaly-teleport-detector")
    private final String anomalyTeleportDetector;
    @JsonProperty("new-year-mode")
    private final String newYearMode;
    @JsonProperty("order-taken-notification-radius")
    private final String orderTakenNotificationRadius;
    @JsonProperty("order-taken-notification-time")
    private final String orderTakenNotificationTime;
    @JsonProperty("unplanned-shifts")
    private final String unplannedShifts;

    public ConfigFeatures(String str, String str2, String str3, String str4, String str5, String str6) {
        this.unplannedShifts = str;
        this.orderTakenNotificationRadius = str2;
        this.orderTakenNotificationTime = str3;
        this.activityTracking = str4;
        this.anomalyTeleportDetector = str5;
        this.newYearMode = str6;
    }

    public static ConfigFeatures copy$default(ConfigFeatures configFeatures, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = configFeatures.unplannedShifts;
        }
        if ((i & 2) != 0) {
            str2 = configFeatures.orderTakenNotificationRadius;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = configFeatures.orderTakenNotificationTime;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = configFeatures.activityTracking;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = configFeatures.anomalyTeleportDetector;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = configFeatures.newYearMode;
        }
        return configFeatures.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.unplannedShifts;
    }

    public final String component2() {
        return this.orderTakenNotificationRadius;
    }

    public final String component3() {
        return this.orderTakenNotificationTime;
    }

    public final String component4() {
        return this.activityTracking;
    }

    public final String component5() {
        return this.anomalyTeleportDetector;
    }

    public final String component6() {
        return this.newYearMode;
    }

    public final ConfigFeatures copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new ConfigFeatures(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigFeatures)) {
            return false;
        }
        ConfigFeatures configFeatures = (ConfigFeatures) obj;
        return Intrinsics.areEqual((Object) this.unplannedShifts, (Object) configFeatures.unplannedShifts) && Intrinsics.areEqual((Object) this.orderTakenNotificationRadius, (Object) configFeatures.orderTakenNotificationRadius) && Intrinsics.areEqual((Object) this.orderTakenNotificationTime, (Object) configFeatures.orderTakenNotificationTime) && Intrinsics.areEqual((Object) this.activityTracking, (Object) configFeatures.activityTracking) && Intrinsics.areEqual((Object) this.anomalyTeleportDetector, (Object) configFeatures.anomalyTeleportDetector) && Intrinsics.areEqual((Object) this.newYearMode, (Object) configFeatures.newYearMode);
    }

    public final String getActivityTracking() {
        return this.activityTracking;
    }

    public final String getAnomalyTeleportDetector() {
        return this.anomalyTeleportDetector;
    }

    public final String getNewYearMode() {
        return this.newYearMode;
    }

    public final String getOrderTakenNotificationRadius() {
        return this.orderTakenNotificationRadius;
    }

    public final String getOrderTakenNotificationTime() {
        return this.orderTakenNotificationTime;
    }

    public final String getUnplannedShifts() {
        return this.unplannedShifts;
    }

    public int hashCode() {
        String str = this.unplannedShifts;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.orderTakenNotificationRadius;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.orderTakenNotificationTime;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.activityTracking;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.anomalyTeleportDetector;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.newYearMode;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "ConfigFeatures(unplannedShifts=" + this.unplannedShifts + ", orderTakenNotificationRadius=" + this.orderTakenNotificationRadius + ", orderTakenNotificationTime=" + this.orderTakenNotificationTime + ", activityTracking=" + this.activityTracking + ", anomalyTeleportDetector=" + this.anomalyTeleportDetector + ", newYearMode=" + this.newYearMode + ")";
    }
}
