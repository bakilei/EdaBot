package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.Intrinsics;

public final class OpenedCourierShift {
    @SerializedName("attributes")
    private final OpenedCourierShiftAttributes attributes;
    @SerializedName("id")
    private final String id;
    @SerializedName("type")
    private final String type;

    public OpenedCourierShift(String str, String str2, OpenedCourierShiftAttributes openedCourierShiftAttributes) {
        Intrinsics.checkNotNull(str, "id");
        Intrinsics.checkNotNull(str2, "type");
        Intrinsics.checkNotNull(openedCourierShiftAttributes, "attributes");
        this.id = str;
        this.type = str2;
        this.attributes = openedCourierShiftAttributes;
    }

    public static OpenedCourierShift copy$default(OpenedCourierShift openedCourierShift, String str, String str2, OpenedCourierShiftAttributes openedCourierShiftAttributes, int i, Object obj) {
        if ((i & 1) != 0) {
            str = openedCourierShift.id;
        }
        if ((i & 2) != 0) {
            str2 = openedCourierShift.type;
        }
        if ((i & 4) != 0) {
            openedCourierShiftAttributes = openedCourierShift.attributes;
        }
        return openedCourierShift.copy(str, str2, openedCourierShiftAttributes);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final OpenedCourierShiftAttributes component3() {
        return this.attributes;
    }

    public final OpenedCourierShift copy(String str, String str2, OpenedCourierShiftAttributes openedCourierShiftAttributes) {
        Intrinsics.checkNotNull(str, "id");
        Intrinsics.checkNotNull(str2, "type");
        Intrinsics.checkNotNull(openedCourierShiftAttributes, "attributes");
        return new OpenedCourierShift(str, str2, openedCourierShiftAttributes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenedCourierShift)) {
            return false;
        }
        OpenedCourierShift openedCourierShift = (OpenedCourierShift) obj;
        return Intrinsics.areEqual(this.id, openedCourierShift.id) && Intrinsics.areEqual(this.type, openedCourierShift.type) && Intrinsics.areEqual(this.attributes, openedCourierShift.attributes);
    }

    public final OpenedCourierShiftAttributes getAttributes() {
        return this.attributes;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        OpenedCourierShiftAttributes openedCourierShiftAttributes = this.attributes;
        if (openedCourierShiftAttributes != null) {
            i = openedCourierShiftAttributes.hashCode();
        }
        return hashCode2 + i;
    }

    @Override
    public String toString() {
        return "OpenedCourierShift(id=" + this.id + ", type=" + this.type + ", attributes=" + this.attributes + ")";
    }
}
