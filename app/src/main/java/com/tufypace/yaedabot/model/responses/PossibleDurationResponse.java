package com.tufypace.yaedabot.model.responses;

import com.google.gson.annotations.SerializedName;
import com.tufypace.yaedabot.model.shift.PossibleDuration;

import kotlin.jvm.internal.Intrinsics;

public final class PossibleDurationResponse {
    @SerializedName("data")
    private final PossibleDuration data;

    public PossibleDurationResponse(PossibleDuration possibleDuration) {
        Intrinsics.checkNotNull(possibleDuration, "data");
        this.data = possibleDuration;
    }

    public static PossibleDurationResponse copy$default(PossibleDurationResponse possibleDurationResponse, PossibleDuration possibleDuration, int i, Object obj) {
        if ((i & 1) != 0) {
            possibleDuration = possibleDurationResponse.data;
        }
        return possibleDurationResponse.copy(possibleDuration);
    }

    public final PossibleDuration component1() {
        return this.data;
    }

    public final PossibleDurationResponse copy(PossibleDuration possibleDuration) {
        Intrinsics.checkNotNull(possibleDuration, "data");
        return new PossibleDurationResponse(possibleDuration);
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PossibleDurationResponse) && Intrinsics.areEqual(this.data, ((PossibleDurationResponse) obj).data);
        }
        return true;
    }

    public final PossibleDuration getData() {
        return this.data;
    }

    @Override
    public int hashCode() {
        PossibleDuration possibleDuration = this.data;
        if (possibleDuration != null) {
            return possibleDuration.hashCode();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "PossibleDurationResponse(data=" + this.data + ")";
    }
}