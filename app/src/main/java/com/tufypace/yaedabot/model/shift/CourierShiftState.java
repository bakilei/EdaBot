package com.tufypace.yaedabot.model.shift;

import kotlin.jvm.internal.Intrinsics;

public final class CourierShiftState {
    private final CourierShiftStateAttributes attributes;
    private final int id;
    private String type;

    public CourierShiftState(int i, String str, CourierShiftStateAttributes courierShiftStateAttributes) {
        Intrinsics.checkFieldIsNotNull(str, "type");
        this.id = i;
        this.type = str;
        this.attributes = courierShiftStateAttributes;
    }

    public static CourierShiftState copy$default(CourierShiftState courierShiftState, int i, String str, CourierShiftStateAttributes courierShiftStateAttributes, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = courierShiftState.id;
        }
        if ((i2 & 2) != 0) {
            str = courierShiftState.type;
        }
        if ((i2 & 4) != 0) {
            courierShiftStateAttributes = courierShiftState.attributes;
        }
        return courierShiftState.copy(i, str, courierShiftStateAttributes);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final CourierShiftStateAttributes component3() {
        return this.attributes;
    }

    public final CourierShiftState copy(int i, String str, CourierShiftStateAttributes courierShiftStateAttributes) {
        Intrinsics.checkFieldIsNotNull(str, "type");
        return new CourierShiftState(i, str, courierShiftStateAttributes);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CourierShiftState) {
                CourierShiftState courierShiftState = (CourierShiftState) obj;
                if (!(this.id == courierShiftState.id) || !Intrinsics.areEqual((Object) this.type, (Object) courierShiftState.type) || !Intrinsics.areEqual((Object) this.attributes, (Object) courierShiftState.attributes)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final CourierShiftStateAttributes getAttributes() {
        return this.attributes;
    }

    public final int getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.type;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        CourierShiftStateAttributes courierShiftStateAttributes = this.attributes;
        if (courierShiftStateAttributes != null) {
            i2 = courierShiftStateAttributes.hashCode();
        }
        return hashCode + i2;
    }

    public final void setType(String str) {
        Intrinsics.checkFieldIsNotNull(str, "<set-?>");
        this.type = str;
    }

    public String toString() {
        return "CourierShiftState(id=" + this.id + ", type=" + this.type + ", attributes=" + this.attributes + ")";
    }
}
