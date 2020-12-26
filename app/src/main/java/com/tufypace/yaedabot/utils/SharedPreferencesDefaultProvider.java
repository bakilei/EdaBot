package com.tufypace.yaedabot.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesDefaultProvider implements SharedPreferencesProvider {
    public final String PREFS = "yandex_prefs";
    public final int PREFS_MODE = 0;
    public Context mContext;

    public SharedPreferencesDefaultProvider(Context context) {
        this.mContext = context;
    }


    @Override
    public Boolean getBoolean(String str) {
        boolean z;
        Boolean bool = (Boolean) getValue(str, Boolean.class);
        if (bool == null) {
            z = false;
        } else {
            z = bool;
        }
        return z;
    }

    @Override
    public Float getFloat(String str) {
        float f;
        Float f2 = (Float) getValue(str, Float.class);
        if (f2 == null) {
            f = 0.0f;
        } else {
            f = f2;
        }
        return f;
    }

    @Override
    public Integer getInteger(String str) {
        int i;
        Integer num = (Integer) getValue(str, Integer.class);
        if (num == null) {
            i = 0;
        } else {
            i = num;
        }
        return i;
    }

    @Override
    public Integer getInteger(String str, int i) {
        Integer num = (Integer) getValue(str, Integer.class);
        if (num != null) {
            i = num;
        }
        return i;
    }

    @Override
    public Long getLong(String str) {
        long j;
        Long l = (Long) getValue(str, Long.class);
        if (l == null) {
            j = 0;
        } else {
            j = l;
        }
        return j;
    }

    @Override
    public String getString(String str) {
        String str2 = (String) getValue(str, String.class);
        return str2 == null ? "" : str2;
    }

    @Override
    public void save(String str, Object obj) {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(PREFS, 0).edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, (Integer) obj);
        } else if (obj instanceof Long) {
            edit.putLong(str, (Long) obj);
        } else if (obj instanceof Float) {
            edit.putFloat(str, (Float) obj);
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, (Boolean) obj);
        } else if (obj == null) {
            edit.remove(str);
        }
        edit.apply();
    }

    private Object getValue(String str, Class cls) {
        try {
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(PREFS, 0);
            if (!sharedPreferences.contains(str)) {
                return null;
            }
            String simpleName = cls.getSimpleName();

            switch (simpleName) {
                case "String":
                    return sharedPreferences.getString(str, "");

                case "Integer":
                    return sharedPreferences.getInt(str, 0);

                case "Long":
                    return sharedPreferences.getLong(str, 0);

                case "Float":
                    return sharedPreferences.getFloat(str, 0.0f);

                case "Boolean":
                    return sharedPreferences.getBoolean(str, false);

                default:
                    return null;
            }

        } catch (Exception e) {
            //        Logs.d(e.getMessage());
            return null;
        }
    }
}
