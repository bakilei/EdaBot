package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.Intrinsics;

public class StartPoint {
    @SerializedName("attributes")
    private final StartPointAttributes attributes;
    @SerializedName("id")
    private final String id;
    @SerializedName("type")
    private final String type;

    public StartPoint(String str, String str2, StartPointAttributes startPointAttributes) {
        Intrinsics.checkFieldIsNotNull(str, "id");
        Intrinsics.checkFieldIsNotNull(str2, "type");
        Intrinsics.checkFieldIsNotNull(startPointAttributes, "attributes");
        this.id = str;
        this.type = str2;
        this.attributes = startPointAttributes;
    }

    public static StartPoint copy$default(StartPoint startPoint, String str, String str2, StartPointAttributes startPointAttributes, int i, Object obj) {
        if ((i & 1) != 0) {
            str = startPoint.id;
        }
        if ((i & 2) != 0) {
            str2 = startPoint.type;
        }
        if ((i & 4) != 0) {
            startPointAttributes = startPoint.attributes;
        }
        return startPoint.copy(str, str2, startPointAttributes);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final StartPointAttributes component3() {
        return this.attributes;
    }

    public final StartPoint copy(String str, String str2, StartPointAttributes startPointAttributes) {
        Intrinsics.checkFieldIsNotNull(str, "id");
        Intrinsics.checkFieldIsNotNull(str2, "type");
        Intrinsics.checkFieldIsNotNull(startPointAttributes, "attributes");
        return new StartPoint(str, str2, startPointAttributes);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StartPoint)) {
            return false;
        }
        StartPoint startPoint = (StartPoint) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) startPoint.id) && Intrinsics.areEqual((Object) this.type, (Object) startPoint.type) && Intrinsics.areEqual((Object) this.attributes, (Object) startPoint.attributes);
    }

    public final StartPointAttributes getAttributes() {
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
        StartPointAttributes startPointAttributes = this.attributes;
        if (startPointAttributes != null) {
            i = startPointAttributes.hashCode();
        }
        return hashCode2 + i;
    }

    @Override
    public String toString() {
        return "StartPoint{" +
                "attributes=" + attributes +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
