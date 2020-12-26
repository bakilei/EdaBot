package com.tufypace.yaedabot.model.shift;

import kotlin.jvm.internal.Intrinsics;

public class CourierShiftStateAttributes {
    private final Long duration;
    private final String finishedAt;
    private final String startedAt;

    public CourierShiftStateAttributes(String str, String str2, Long l) {
        this.startedAt = str;
        this.finishedAt = str2;
        this.duration = l;
    }

    public static CourierShiftStateAttributes copy$default(CourierShiftStateAttributes courierShiftStateAttributes, String str, String str2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = courierShiftStateAttributes.startedAt;
        }
        if ((i & 2) != 0) {
            str2 = courierShiftStateAttributes.finishedAt;
        }
        if ((i & 4) != 0) {
            l = courierShiftStateAttributes.duration;
        }
        return courierShiftStateAttributes.copy(str, str2, l);
    }

    public final String component1() {
        return this.startedAt;
    }

    public final String component2() {
        return this.finishedAt;
    }

    public final Long component3() {
        return this.duration;
    }

    public final CourierShiftStateAttributes copy(String str, String str2, Long l) {
        return new CourierShiftStateAttributes(str, str2, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourierShiftStateAttributes)) {
            return false;
        }
        CourierShiftStateAttributes courierShiftStateAttributes = (CourierShiftStateAttributes) obj;
        return Intrinsics.areEqual((Object) this.startedAt, (Object) courierShiftStateAttributes.startedAt) && Intrinsics.areEqual((Object) this.finishedAt, (Object) courierShiftStateAttributes.finishedAt) && Intrinsics.areEqual((Object) this.duration, (Object) courierShiftStateAttributes.duration);
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getFinishedAt() {
        return this.finishedAt;
    }

    public final String getStartedAt() {
        return this.startedAt;
    }

    public int hashCode() {
        String str = this.startedAt;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.finishedAt;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.duration;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CourierShiftStateAttributes(startedAt=" + this.startedAt + ", finishedAt=" + this.finishedAt + ", duration=" + this.duration + ")";
    }
}
