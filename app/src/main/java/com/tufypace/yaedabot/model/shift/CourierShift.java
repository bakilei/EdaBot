package com.tufypace.yaedabot.model.shift;


import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.Intrinsics;

public final class CourierShift {
    @SerializedName("attributes")
    public final ShiftAttributes attributes;
    @SerializedName("id")
    public final int id;
    @SerializedName("type")
    public final String type;

    public CourierShift(int i, String str, ShiftAttributes shiftAttributes) {
        Intrinsics.checkFieldIsNotNull(str, "type");
        Intrinsics.checkFieldIsNotNull(shiftAttributes, "attributes");
        this.id = i;
        this.type = str;
        this.attributes = shiftAttributes;
    }

    public static CourierShift copy$default(CourierShift courierShift, int i, String str, ShiftAttributes shiftAttributes, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = courierShift.id;
        }
        if ((i2 & 2) != 0) {
            str = courierShift.type;
        }
        if ((i2 & 4) != 0) {
            shiftAttributes = courierShift.attributes;
        }
        return courierShift.copy(i, str, shiftAttributes);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final ShiftAttributes component3() {
        return this.attributes;
    }

    public final CourierShift copy(int i, String str, ShiftAttributes shiftAttributes) {
        Intrinsics.checkFieldIsNotNull(str, "type");
        Intrinsics.checkFieldIsNotNull(shiftAttributes, "attributes");
        return new CourierShift(i, str, shiftAttributes);
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CourierShift) {
                CourierShift courierShift = (CourierShift) obj;
                if (!(this.id == courierShift.id) || !Intrinsics.areEqual((Object) this.type, (Object) courierShift.type) || !Intrinsics.areEqual((Object) this.attributes, (Object) courierShift.attributes)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final ShiftAttributes getAttributes() {
        return this.attributes;
    }

    public final int getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        int i = this.id * 31;
        String str = this.type;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        ShiftAttributes shiftAttributes = this.attributes;
        if (shiftAttributes != null) {
            i2 = shiftAttributes.hashCode();
        }
        return hashCode + i2;
    }

    @Override
    public String toString() {
        return "CourierShift(id=" + this.id + ", type=" + this.type + ", attributes=" + this.attributes + ")";
    }
}
