package com.tufypace.yaedabot.model.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tufypace.yaedabot.model.shift.CourierShiftChanges;

import java.util.List;

import kotlin.jvm.internal.Intrinsics;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangesListResponse {
    @JsonProperty("data")
    private final List<CourierShiftChanges> data;

    public ChangesListResponse(List<CourierShiftChanges> list) {
        Intrinsics.checkNotNull(list, "data");
        this.data = list;
    }

    public static ChangesListResponse copy$default(ChangesListResponse changesListResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = changesListResponse.data;
        }
        return changesListResponse.copy(list);
    }

    public final List<CourierShiftChanges> component1() {
        return this.data;
    }

    public final ChangesListResponse copy(List<CourierShiftChanges> list) {
        Intrinsics.checkNotNull(list, "data");
        return new ChangesListResponse(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ChangesListResponse) && Intrinsics.areEqual(this.data, ((ChangesListResponse) obj).data);
        }
        return true;
    }

    public final List<CourierShiftChanges> getData() {
        return this.data;
    }

    @Override
    public int hashCode() {
        List<CourierShiftChanges> list = this.data;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ChangesListResponse(data=" + this.data + ")";
    }
}
