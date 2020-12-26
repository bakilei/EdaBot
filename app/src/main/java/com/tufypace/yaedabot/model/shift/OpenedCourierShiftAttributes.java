package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.Intrinsics;

public final class OpenedCourierShiftAttributes {
    @SerializedName("endsAt")
    private final String endsAt;
    @SerializedName("startPoint")
    private final StartPoint startPoint;
    @SerializedName("startsAt")
    private final String startsAt;

    public OpenedCourierShiftAttributes(String timeModel, String timeModel2, StartPoint startPoint2) {
        Intrinsics.checkNotNull(timeModel, "startsAt");
        Intrinsics.checkNotNull(timeModel2, "endsAt");
        Intrinsics.checkNotNull(startPoint2, "startPoint");
        this.startsAt = timeModel;
        this.endsAt = timeModel2;
        this.startPoint = startPoint2;
    }

    public static OpenedCourierShiftAttributes copy$default(OpenedCourierShiftAttributes openedCourierShiftAttributes, String timeModel, String timeModel2, StartPoint startPoint2, int i, Object obj) {
        if ((i & 1) != 0) {
            timeModel = openedCourierShiftAttributes.startsAt;
        }
        if ((i & 2) != 0) {
            timeModel2 = openedCourierShiftAttributes.endsAt;
        }
        if ((i & 4) != 0) {
            startPoint2 = openedCourierShiftAttributes.startPoint;
        }
        return openedCourierShiftAttributes.copy(timeModel, timeModel2, startPoint2);
    }

    public final String component1() {
        return this.startsAt;
    }

    public final String component2() {
        return this.endsAt;
    }

    public final StartPoint component3() {
        return this.startPoint;
    }

    public final OpenedCourierShiftAttributes copy(String timeModel, String timeModel2, StartPoint startPoint2) {
        Intrinsics.checkNotNull(timeModel, "startsAt");
        Intrinsics.checkNotNull(timeModel2, "endsAt");
        Intrinsics.checkNotNull(startPoint2, "startPoint");
        return new OpenedCourierShiftAttributes(timeModel, timeModel2, startPoint2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenedCourierShiftAttributes)) {
            return false;
        }
        OpenedCourierShiftAttributes openedCourierShiftAttributes = (OpenedCourierShiftAttributes) obj;
        return Intrinsics.areEqual(this.startsAt, openedCourierShiftAttributes.startsAt) && Intrinsics.areEqual(this.endsAt, openedCourierShiftAttributes.endsAt) && Intrinsics.areEqual(this.startPoint, openedCourierShiftAttributes.startPoint);
    }

    public final String getEndsAt() {
        return this.endsAt;
    }

    public final StartPoint getStartPoint() {
        return this.startPoint;
    }

    public final String getStartsAt() {
        return this.startsAt;
    }

    public int hashCode() {
        String timeModel = this.startsAt;
        int i = 0;
        int hashCode = (timeModel != null ? timeModel.hashCode() : 0) * 31;
        String timeModel2 = this.endsAt;
        int hashCode2 = (hashCode + (timeModel2 != null ? timeModel2.hashCode() : 0)) * 31;
        StartPoint startPoint2 = this.startPoint;
        if (startPoint2 != null) {
            i = startPoint2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "OpenedCourierShiftAttributes(startsAt=" + this.startsAt + ", endsAt=" + this.endsAt + ", startPoint=" + this.startPoint + ")";
    }
}
