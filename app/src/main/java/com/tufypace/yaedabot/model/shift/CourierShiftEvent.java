package com.tufypace.yaedabot.model.shift;

import kotlin.jvm.internal.Intrinsics;

public class CourierShiftEvent {
    private final CourierShiftEventAttributes attributes;
    private final String id;
    private final String type;

    public CourierShiftEvent(String str, String str2, CourierShiftEventAttributes courierShiftEventAttributes) {
        Intrinsics.checkFieldIsNotNull(str, "id");
        Intrinsics.checkFieldIsNotNull(str2, "type");
        Intrinsics.checkFieldIsNotNull(courierShiftEventAttributes, "attributes");
        this.id = str;
        this.type = str2;
        this.attributes = courierShiftEventAttributes;
    }

    public static CourierShiftEvent copy$default(CourierShiftEvent courierShiftEvent, String str, String str2, CourierShiftEventAttributes courierShiftEventAttributes, int i, Object obj) {
        if ((i & 1) != 0) {
            str = courierShiftEvent.id;
        }
        if ((i & 2) != 0) {
            str2 = courierShiftEvent.type;
        }
        if ((i & 4) != 0) {
            courierShiftEventAttributes = courierShiftEvent.attributes;
        }
        return courierShiftEvent.copy(str, str2, courierShiftEventAttributes);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final CourierShiftEventAttributes component3() {
        return this.attributes;
    }

    public final CourierShiftEvent copy(String str, String str2, CourierShiftEventAttributes courierShiftEventAttributes) {
        Intrinsics.checkFieldIsNotNull(str, "id");
        Intrinsics.checkFieldIsNotNull(str2, "type");
        Intrinsics.checkFieldIsNotNull(courierShiftEventAttributes, "attributes");
        return new CourierShiftEvent(str, str2, courierShiftEventAttributes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourierShiftEvent)) {
            return false;
        }
        CourierShiftEvent courierShiftEvent = (CourierShiftEvent) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) courierShiftEvent.id) && Intrinsics.areEqual((Object) this.type, (Object) courierShiftEvent.type) && Intrinsics.areEqual((Object) this.attributes, (Object) courierShiftEvent.attributes);
    }

    public final CourierShiftEventAttributes getAttributes() {
        return this.attributes;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        CourierShiftEventAttributes courierShiftEventAttributes = this.attributes;
        if (courierShiftEventAttributes != null) {
            i = courierShiftEventAttributes.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CourierShiftEvent(id=" + this.id + ", type=" + this.type + ", attributes=" + this.attributes + ")";
    }
}
