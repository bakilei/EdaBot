package com.tufypace.yaedabot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {
    @JsonProperty("apiKey")
    private String apiKey;

    public String getApiKey() {
        return this.apiKey;
    }

    public void setApiKey(String str) {
        this.apiKey = str;
    }
}
