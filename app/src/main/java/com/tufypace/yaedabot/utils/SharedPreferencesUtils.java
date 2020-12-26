package com.tufypace.yaedabot.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtils {
    private static final String PREFS = "yandex_prefs";
    private static final int PREFS_MODE = 0;

    public static void save(Context context, String str, Object obj) {
        if (context == null) {
            //    Logs.e("SharedPreferencesUtils: context is null");
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("yandex_prefs", 0).edit();
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


    public static Object getValue(Context context, String str, Class cls) {
        if (context == null) {
            //      Logs.e("com.tokarev.mafia.utils.SharedPreferencesUtils: context is null");
            return null;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("yandex_prefs", 0);
            if (!sharedPreferences.contains(str)) {
                return null;
            }
            String simpleName = cls.getSimpleName();
            char c = 65535;
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
            //    Logs.d(e.getMessage());
            return null;
        }

    }


    public static String getString(Context context, String str) {
        String str2 = (String) getValue(context, str, String.class);
        return str2 == null ? "" : str2;
    }

    public static Integer getInteger(Context context, String str) {
        int i;
        Integer num = (Integer) getValue(context, str, Integer.class);
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        return Integer.valueOf(i);
    }

    public static Long getLong(Context context, String str) {
        long j;
        Long l = (Long) getValue(context, str, Long.class);
        if (l == null) {
            j = 0;
        } else {
            j = l.longValue();
        }
        return Long.valueOf(j);
    }

    public static Float getFloat(Context context, String str) {
        float f;
        Float f2 = (Float) getValue(context, str, Float.class);
        if (f2 == null) {
            f = 0.0f;
        } else {
            f = f2.floatValue();
        }
        return Float.valueOf(f);
    }

    public static Boolean getBoolean(Context context, String str) {
        boolean z;
        Boolean bool = (Boolean) getValue(context, str, Boolean.class);
        if (bool == null) {
            z = false;
        } else {
            z = bool.booleanValue();
        }
        return Boolean.valueOf(z);
    }
}
