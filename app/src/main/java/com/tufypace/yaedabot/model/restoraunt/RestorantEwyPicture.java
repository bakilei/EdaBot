package com.tufypace.yaedabot.model.restoraunt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestorantEwyPicture {
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("ratio")
    private double ratio;

    public RestorantEwyPicture(String uri, double ratio) {
        this.uri = uri;
        this.ratio = ratio;
    }

    public RestorantEwyPicture() {
        super();
    }
}
