package com.tufypace.yaedabot.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourierTypeShiftOperation extends ShiftOperation {
    @JsonProperty("courierType")
    public final String courierType;


    public CourierTypeShiftOperation(String str, ShiftLocation shiftLocation, String str2, boolean z) {
        super(str, shiftLocation, z);
        //      f.b(str, "id");
        //     f.b(shiftLocation, "location");
        //      f.b(str2, "courierType");
        this.courierType = str2;
    }
}
