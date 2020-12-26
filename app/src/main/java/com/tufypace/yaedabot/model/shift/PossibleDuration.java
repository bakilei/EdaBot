package com.tufypace.yaedabot.model.shift;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.Intrinsics;

public class PossibleDuration {
    @SerializedName("explanation")
    private final String explanation;
    @SerializedName("isPossible")
    private final boolean isPossible;
    @SerializedName("maxAllowedDuration")
    private final int maxAllowedDuration;
    @SerializedName("maxPossibleDuration")
    private final int maxPossibleDuration;

    public PossibleDuration(int i, int i2, boolean z, String str) {
        this.maxPossibleDuration = i;
        this.maxAllowedDuration = i2;
        this.isPossible = z;
        this.explanation = str;
    }

    public static PossibleDuration copy$default(PossibleDuration possibleDuration, int i, int i2, boolean z, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = possibleDuration.maxPossibleDuration;
        }
        if ((i3 & 2) != 0) {
            i2 = possibleDuration.maxAllowedDuration;
        }
        if ((i3 & 4) != 0) {
            z = possibleDuration.isPossible;
        }
        if ((i3 & 8) != 0) {
            str = possibleDuration.explanation;
        }
        return possibleDuration.copy(i, i2, z, str);
    }

    public final int component1() {
        return this.maxPossibleDuration;
    }

    public final int component2() {
        return this.maxAllowedDuration;
    }

    public final boolean component3() {
        return this.isPossible;
    }

    public final String component4() {
        return this.explanation;
    }

    public final PossibleDuration copy(int i, int i2, boolean z, String str) {
        return new PossibleDuration(i, i2, z, str);
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PossibleDuration) {
                PossibleDuration possibleDuration = (PossibleDuration) obj;
                if (this.maxPossibleDuration == possibleDuration.maxPossibleDuration) {
                    if (this.maxAllowedDuration == possibleDuration.maxAllowedDuration) {
                        if (!(this.isPossible == possibleDuration.isPossible) || !Intrinsics.areEqual((Object) this.explanation, (Object) possibleDuration.explanation)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final String getExplanation() {
        return this.explanation;
    }

    public final int getMaxAllowedDuration() {
        return this.maxAllowedDuration;
    }

    public final int getMaxPossibleDuration() {
        return this.maxPossibleDuration;
    }

    @Override
    public int hashCode() {
        int i = ((this.maxPossibleDuration * 31) + this.maxAllowedDuration) * 31;
        boolean z = this.isPossible;
        if (z) {
            z = true;
        }
        int i2 = (i + (z ? 1 : 0)) * 31;
        String str = this.explanation;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isPossible() {
        return this.isPossible;
    }

    @Override
    public String toString() {
        return "PossibleDuration(maxPossibleDuration=" + this.maxPossibleDuration + ", maxAllowedDuration=" + this.maxAllowedDuration + ", isPossible=" + this.isPossible + ", explanation=" + this.explanation + ")";
    }
}
