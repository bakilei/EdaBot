package com.tufypace.yaedabot.model.restoraunt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonalPlaces {
    @JsonProperty("title")
    public String title;
    @JsonProperty("foundPlaces")
    public List<Carousel> foundPlaces;


    public PersonalPlaces(String title, List<Carousel> foundPlaces) {
        this.title = title;
        this.foundPlaces = foundPlaces;
    }

    public PersonalPlaces() {
        super();
    }

    @Override
    public String toString() {
        return "PersonalPlaces{" +
                "title='" + title + '\'' +
                ", foundPlaces=" + foundPlaces +
                '}';
    }
}

