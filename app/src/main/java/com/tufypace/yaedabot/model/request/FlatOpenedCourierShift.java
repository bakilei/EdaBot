package com.tufypace.yaedabot.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import kotlin.jvm.internal.Intrinsics;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class FlatOpenedCourierShift {
    @JsonProperty("endsAt")
    private final String endsAt;
    @JsonProperty("id")
    private final String id;
    @JsonProperty("startPointId")
    private final String startPointId;
    @JsonProperty("startsAt")
    private final String startsAt;

    public FlatOpenedCourierShift(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNull(str, "id");
        Intrinsics.checkNotNull(str2, "startsAt");
        Intrinsics.checkNotNull(str3, "endsAt");
        Intrinsics.checkNotNull(str4, "startPointId");
        this.id = str;
        this.startsAt = str2;
        this.endsAt = str3;
        this.startPointId = str4;

    }

    public static FlatOpenedCourierShift copy$default(FlatOpenedCourierShift flatOpenedCourierShift, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = flatOpenedCourierShift.id;
        }
        if ((i & 2) != 0) {
            str2 = flatOpenedCourierShift.startsAt;
        }
        if ((i & 4) != 0) {
            str3 = flatOpenedCourierShift.endsAt;
        }
        if ((i & 8) != 0) {
            str4 = flatOpenedCourierShift.startPointId;
        }
        return flatOpenedCourierShift.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.startsAt;
    }

    public final String component3() {
        return this.endsAt;
    }

    public final String component4() {
        return this.startPointId;
    }

    public final FlatOpenedCourierShift copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNull(str, "id");
        Intrinsics.checkNotNull(str2, "startsAt");
        Intrinsics.checkNotNull(str3, "endsAt");
        Intrinsics.checkNotNull(str4, "startPointId");
        return new FlatOpenedCourierShift(str, str2, str3, str4);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlatOpenedCourierShift)) {
            return false;
        }
        FlatOpenedCourierShift flatOpenedCourierShift = (FlatOpenedCourierShift) obj;
        return Intrinsics.areEqual(this.id, flatOpenedCourierShift.id) && Intrinsics.areEqual(this.startsAt, flatOpenedCourierShift.startsAt) && Intrinsics.areEqual(this.endsAt, flatOpenedCourierShift.endsAt) && Intrinsics.areEqual(this.startPointId, flatOpenedCourierShift.startPointId);
    }

    public final String getEndsAt() {
        return this.endsAt;
    }

    public final String getId() {
        return this.id;
    }

    public final String getStartPointId() {
        return this.startPointId;
    }

    public final String getStartsAt() {
        return this.startsAt;
    }

    @Override
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.startsAt;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.endsAt;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.startPointId;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @Override
    public String toString() {
        return "FlatOpenedCourierShift(id=" + this.id + ", startsAt=" + this.startsAt + ", endsAt=" + this.endsAt + ", startPointId=" + this.startPointId + ")";
    }
}
