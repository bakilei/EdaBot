package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.Intrinsics;

public final class ShiftSettingsResponse {
    @SerializedName("data")
    private final ShiftSettings data;

    public ShiftSettingsResponse(ShiftSettings shiftSettings) {
        Intrinsics.checkNotNull(shiftSettings, "data");
        this.data = shiftSettings;
    }

    public static ShiftSettingsResponse copy$default(ShiftSettingsResponse shiftSettingsResponse, ShiftSettings shiftSettings, int i, Object obj) {
        if ((i & 1) != 0) {
            shiftSettings = shiftSettingsResponse.data;
        }
        return shiftSettingsResponse.copy(shiftSettings);
    }

    public final ShiftSettings component1() {
        return this.data;
    }

    public final ShiftSettingsResponse copy(ShiftSettings shiftSettings) {
        Intrinsics.checkNotNull(shiftSettings, "data");
        return new ShiftSettingsResponse(shiftSettings);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ShiftSettingsResponse) && Intrinsics.areEqual(this.data, ((ShiftSettingsResponse) obj).data);
        }
        return true;
    }

    public final ShiftSettings getData() {
        return this.data;
    }

    public int hashCode() {
        ShiftSettings shiftSettings = this.data;
        if (shiftSettings != null) {
            return shiftSettings.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ShiftSettingsResponse(data=" + this.data + ")";
    }
}
