package com.tufypace.yaedabot.model.courierinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourierFullname {
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("patronymic")
    public String patronymic;
    @JsonProperty("surname")
    public String surname;

}
