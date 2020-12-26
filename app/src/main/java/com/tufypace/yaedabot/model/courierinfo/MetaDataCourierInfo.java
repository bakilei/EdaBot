package com.tufypace.yaedabot.model.courierinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaDataCourierInfo {
    @JsonProperty("isHardOfHearing")
    public boolean isDeafMute;

    public boolean isDeafMute() {
        return isDeafMute;
    }

    public void setDeafMute(boolean deafMute) {
        isDeafMute = deafMute;
    }
}
