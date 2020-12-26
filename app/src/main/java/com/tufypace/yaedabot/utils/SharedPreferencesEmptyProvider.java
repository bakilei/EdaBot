package com.tufypace.yaedabot.utils;

public class SharedPreferencesEmptyProvider implements SharedPreferencesProvider {
    public String getString(String str) {
        return "This string is returned from Empty SharedPrefs provider";
    }

    public void save(String str, Object obj) {
    }

    public Integer getInteger(String str) {
        return 0;
    }

    public Integer getInteger(String str, int i) {
        return 0;
    }

    public Long getLong(String str) {
        return 0L;
    }

    public Float getFloat(String str) {
        return Float.valueOf(0.0f);
    }

    public Boolean getBoolean(String str) {
        return false;
    }
}
