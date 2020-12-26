package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public final class CourierShiftChangesAttributes {
    @SerializedName("changes")
    private final List<String> changes;
    @SerializedName("newEndsAt")
    private final String newEndsAt;
    @SerializedName("newStartPoint")
    private final StartPoint newStartPoint;
    @SerializedName("newStartsAt")
    private final String newStartsAt;
    @SerializedName("oldEndsAt")
    private final String oldEndsAt;
    @SerializedName("oldStartPoint")
    private final StartPoint oldStartPoint;
    @SerializedName("oldStartsAt")
    private final String oldStartsAt;

    public CourierShiftChangesAttributes(String timeModel, String timeModel2, String timeModel3, String timeModel4, StartPoint startPoint, StartPoint startPoint2, List<String> list) {
        Intrinsics.checkNotNull(timeModel, "oldStartsAt");
        Intrinsics.checkNotNull(timeModel3, "oldEndsAt");
        Intrinsics.checkNotNull(startPoint, "oldStartPoint");
        Intrinsics.checkNotNull(list, "changes");
        this.oldStartsAt = timeModel;
        this.newStartsAt = timeModel2;
        this.oldEndsAt = timeModel3;
        this.newEndsAt = timeModel4;
        this.oldStartPoint = startPoint;
        this.newStartPoint = startPoint2;
        this.changes = list;
    }

    public static CourierShiftChangesAttributes copy$default(CourierShiftChangesAttributes courierShiftChangesAttributes, String timeModel, String timeModel2, String timeModel3, String timeModel4, StartPoint startPoint, StartPoint startPoint2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            timeModel = courierShiftChangesAttributes.oldStartsAt;
        }
        if ((i & 2) != 0) {
            timeModel2 = courierShiftChangesAttributes.newStartsAt;
        }
        String timeModel5 = timeModel2;
        if ((i & 4) != 0) {
            timeModel3 = courierShiftChangesAttributes.oldEndsAt;
        }
        String timeModel6 = timeModel3;
        if ((i & 8) != 0) {
            timeModel4 = courierShiftChangesAttributes.newEndsAt;
        }
        String timeModel7 = timeModel4;
        if ((i & 16) != 0) {
            startPoint = courierShiftChangesAttributes.oldStartPoint;
        }
        StartPoint startPoint3 = startPoint;
        if ((i & 32) != 0) {
            startPoint2 = courierShiftChangesAttributes.newStartPoint;
        }
        StartPoint startPoint4 = startPoint2;
        if ((i & 64) != 0) {
            list = courierShiftChangesAttributes.changes;
        }
        return courierShiftChangesAttributes.copy(timeModel, timeModel5, timeModel6, timeModel7, startPoint3, startPoint4, list);
    }

    public final String component1() {
        return this.oldStartsAt;
    }

    public final String component2() {
        return this.newStartsAt;
    }

    public final String component3() {
        return this.oldEndsAt;
    }

    public final String component4() {
        return this.newEndsAt;
    }

    public final StartPoint component5() {
        return this.oldStartPoint;
    }

    public final StartPoint component6() {
        return this.newStartPoint;
    }

    public final List<String> component7() {
        return this.changes;
    }

    public final CourierShiftChangesAttributes copy(String timeModel, String timeModel2, String timeModel3, String timeModel4, StartPoint startPoint, StartPoint startPoint2, List<String> list) {
        Intrinsics.checkNotNull(timeModel, "oldStartsAt");
        Intrinsics.checkNotNull(timeModel3, "oldEndsAt");
        Intrinsics.checkNotNull(startPoint, "oldStartPoint");
        List<String> list2 = list;
        Intrinsics.checkNotNull(list2, "changes");
        return new CourierShiftChangesAttributes(timeModel, timeModel2, timeModel3, timeModel4, startPoint, startPoint2, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourierShiftChangesAttributes)) {
            return false;
        }
        CourierShiftChangesAttributes courierShiftChangesAttributes = (CourierShiftChangesAttributes) obj;
        return Intrinsics.areEqual(this.oldStartsAt, courierShiftChangesAttributes.oldStartsAt) && Intrinsics.areEqual(this.newStartsAt, courierShiftChangesAttributes.newStartsAt) && Intrinsics.areEqual(this.oldEndsAt, courierShiftChangesAttributes.oldEndsAt) && Intrinsics.areEqual(this.newEndsAt, courierShiftChangesAttributes.newEndsAt) && Intrinsics.areEqual(this.oldStartPoint, courierShiftChangesAttributes.oldStartPoint) && Intrinsics.areEqual(this.newStartPoint, courierShiftChangesAttributes.newStartPoint) && Intrinsics.areEqual(this.changes, courierShiftChangesAttributes.changes);
    }

    public final List<String> getChanges() {
        return this.changes;
    }

    public final String getNewEndsAt() {
        return this.newEndsAt;
    }

    public final StartPoint getNewStartPoint() {
        return this.newStartPoint;
    }

    public final String getNewStartsAt() {
        return this.newStartsAt;
    }

    public final String getOldEndsAt() {
        return this.oldEndsAt;
    }

    public final StartPoint getOldStartPoint() {
        return this.oldStartPoint;
    }

    public final String getOldStartsAt() {
        return this.oldStartsAt;
    }

    @Override
    public int hashCode() {
        String timeModel = this.oldStartsAt;
        int i = 0;
        int hashCode = (timeModel != null ? timeModel.hashCode() : 0) * 31;
        String timeModel2 = this.newStartsAt;
        int hashCode2 = (hashCode + (timeModel2 != null ? timeModel2.hashCode() : 0)) * 31;
        String timeModel3 = this.oldEndsAt;
        int hashCode3 = (hashCode2 + (timeModel3 != null ? timeModel3.hashCode() : 0)) * 31;
        String timeModel4 = this.newEndsAt;
        int hashCode4 = (hashCode3 + (timeModel4 != null ? timeModel4.hashCode() : 0)) * 31;
        StartPoint startPoint = this.oldStartPoint;
        int hashCode5 = (hashCode4 + (startPoint != null ? startPoint.hashCode() : 0)) * 31;
        StartPoint startPoint2 = this.newStartPoint;
        int hashCode6 = (hashCode5 + (startPoint2 != null ? startPoint2.hashCode() : 0)) * 31;
        List<String> list = this.changes;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode6 + i;
    }

    @Override
    public String toString() {
        return "CourierShiftChangesAttributes(oldStartsAt=" + this.oldStartsAt + ", newStartsAt=" + this.newStartsAt + ", oldEndsAt=" + this.oldEndsAt + ", newEndsAt=" + this.newEndsAt + ", oldStartPoint=" + this.oldStartPoint + ", newStartPoint=" + this.newStartPoint + ", changes=" + this.changes + ")";
    }
}
