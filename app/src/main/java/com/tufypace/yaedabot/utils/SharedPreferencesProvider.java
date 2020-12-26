package com.tufypace.yaedabot.utils;

public interface SharedPreferencesProvider {
    Boolean getBoolean(String str);

    Float getFloat(String str);

    Integer getInteger(String str);

    Integer getInteger(String str, int i);

    Long getLong(String str);

    String getString(String str);

    void save(String str, Object obj);
}
