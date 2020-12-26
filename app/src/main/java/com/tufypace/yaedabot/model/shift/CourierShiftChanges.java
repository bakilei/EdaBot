package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.Intrinsics;

public final class CourierShiftChanges {
    @SerializedName("attributes")
    private final CourierShiftChangesAttributes attributes;
    @SerializedName("id")
    private final int id;
    @SerializedName("type")
    private final String type;

    public CourierShiftChanges(int i, String str, CourierShiftChangesAttributes courierShiftChangesAttributes) {
        Intrinsics.checkNotNull(str, "type");
        Intrinsics.checkNotNull(courierShiftChangesAttributes, "attributes");
        this.id = i;
        this.type = str;
        this.attributes = courierShiftChangesAttributes;
    }

    public static CourierShiftChanges copy$default(CourierShiftChanges courierShiftChanges, int i, String str, CourierShiftChangesAttributes courierShiftChangesAttributes, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = courierShiftChanges.id;
        }
        if ((i2 & 2) != 0) {
            str = courierShiftChanges.type;
        }
        if ((i2 & 4) != 0) {
            courierShiftChangesAttributes = courierShiftChanges.attributes;
        }
        return courierShiftChanges.copy(i, str, courierShiftChangesAttributes);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final CourierShiftChangesAttributes component3() {
        return this.attributes;
    }

    public final CourierShiftChanges copy(int i, String str, CourierShiftChangesAttributes courierShiftChangesAttributes) {
        Intrinsics.checkNotNull(str, "type");
        Intrinsics.checkNotNull(courierShiftChangesAttributes, "attributes");
        return new CourierShiftChanges(i, str, courierShiftChangesAttributes);
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CourierShiftChanges) {
                CourierShiftChanges courierShiftChanges = (CourierShiftChanges) obj;
                if (!(this.id == courierShiftChanges.id) || !Intrinsics.areEqual((Object) this.type, (Object) courierShiftChanges.type) || !Intrinsics.areEqual(this.attributes, courierShiftChanges.attributes)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final CourierShiftChangesAttributes getAttributes() {
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
        CourierShiftChangesAttributes courierShiftChangesAttributes = this.attributes;
        if (courierShiftChangesAttributes != null) {
            i2 = courierShiftChangesAttributes.hashCode();
        }
        return hashCode + i2;
    }

    @Override
    public String toString() {
        return "CourierShiftChanges(id=" + this.id + ", type=" + this.type + ", attributes=" + this.attributes + ")";
    }
}
