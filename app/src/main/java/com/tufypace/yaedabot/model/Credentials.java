package com.tufypace.yaedabot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {
    @JsonProperty("password")
    public String password;
    @JsonProperty("username")
    public String username;

    public Credentials(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
