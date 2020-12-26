package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.Intrinsics;

public final class ShiftSettings {
    @SerializedName("attributes")
    private final ShiftSettingsAttributes attributes;
    @SerializedName("id")
    private final String id;
    @SerializedName("type")
    private final String type;

    public ShiftSettings(String str, String str2, ShiftSettingsAttributes shiftSettingsAttributes) {
        Intrinsics.checkNotNull(str, "id");
        Intrinsics.checkNotNull(str2, "type");
        Intrinsics.checkNotNull(shiftSettingsAttributes, "attributes");
        this.id = str;
        this.type = str2;
        this.attributes = shiftSettingsAttributes;
    }

    public static ShiftSettings copy$default(ShiftSettings shiftSettings, String str, String str2, ShiftSettingsAttributes shiftSettingsAttributes, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shiftSettings.id;
        }
        if ((i & 2) != 0) {
            str2 = shiftSettings.type;
        }
        if ((i & 4) != 0) {
            shiftSettingsAttributes = shiftSettings.attributes;
        }
        return shiftSettings.copy(str, str2, shiftSettingsAttributes);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final ShiftSettingsAttributes component3() {
        return this.attributes;
    }

    public final ShiftSettings copy(String str, String str2, ShiftSettingsAttributes shiftSettingsAttributes) {
        Intrinsics.checkNotNull(str, "id");
        Intrinsics.checkNotNull(str2, "type");
        Intrinsics.checkNotNull(shiftSettingsAttributes, "attributes");
        return new ShiftSettings(str, str2, shiftSettingsAttributes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShiftSettings)) {
            return false;
        }
        ShiftSettings shiftSettings = (ShiftSettings) obj;
        return Intrinsics.areEqual(this.id, shiftSettings.id) && Intrinsics.areEqual(this.type, shiftSettings.type) && Intrinsics.areEqual(this.attributes, shiftSettings.attributes);
    }

    public final ShiftSettingsAttributes getAttributes() {
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
        ShiftSettingsAttributes shiftSettingsAttributes = this.attributes;
        if (shiftSettingsAttributes != null) {
            i = shiftSettingsAttributes.hashCode();
        }
        return hashCode2 + i;
    }

    @Override
    public String toString() {
        return "ShiftSettings(id=" + this.id + ", type=" + this.type + ", attributes=" + this.attributes + ")";
    }
}
