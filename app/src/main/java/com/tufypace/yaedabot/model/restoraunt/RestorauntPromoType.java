package com.tufypace.yaedabot.model.restoraunt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestorauntPromoType {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("picture_uri")
    private String picture_uri;
    @JsonProperty("pictureUri")
    private String pictureUri;
    @JsonProperty("detailedPictureUrl")
    private String detailedPictureUrl;


    public RestorauntPromoType(int id, String name, String picture_uri, String pictureUri, String detailedPictureUrl) {
        this.id = id;
        this.name = name;
        this.picture_uri = picture_uri;
        this.pictureUri = pictureUri;
        this.detailedPictureUrl = detailedPictureUrl;
    }

    public RestorauntPromoType() {
        super();
    }
}
