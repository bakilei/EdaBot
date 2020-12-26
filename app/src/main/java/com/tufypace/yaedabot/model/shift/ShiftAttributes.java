package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public class ShiftAttributes {
    @SerializedName("courierId")
    public final int courierId;
    @SerializedName("courierType")
    public final String courierType;
    @SerializedName("createdAt")
    public final String createdAt;
    @SerializedName("endsAt")
    public final String endsAt;
    @SerializedName("eventList")
    public final List<CourierShiftEvent> eventList;
    @SerializedName("startPoint")
    public final StartPoint startPoint;
    @SerializedName("startsAt")
    public final String startsAt;
    @SerializedName("state")
    public final CourierShiftState state;
    @SerializedName("status")
    public final String status;
    @SerializedName("statusInitiator")
    public final String statusInitiator;

    public ShiftAttributes(String timeModel, String timeModel2, String str, StartPoint startPoint2, CourierShiftState courierShiftState, int i, String str2, String str3, String str4, List<CourierShiftEvent> list) {
        Intrinsics.checkFieldIsNotNull(timeModel, "startsAt");
        Intrinsics.checkFieldIsNotNull(timeModel2, "endsAt");
        Intrinsics.checkFieldIsNotNull(str, "status");
        Intrinsics.checkFieldIsNotNull(startPoint2, "startPoint");
        Intrinsics.checkFieldIsNotNull(str2, "courierType");
        Intrinsics.checkFieldIsNotNull(str3, "createdAt");
        Intrinsics.checkFieldIsNotNull(list, "eventList");
        this.startsAt = timeModel;
        this.endsAt = timeModel2;
        this.status = str;
        this.startPoint = startPoint2;
        this.state = courierShiftState;
        this.courierId = i;
        this.courierType = str2;
        this.createdAt = str3;
        this.statusInitiator = str4;
        this.eventList = list;
    }
}
