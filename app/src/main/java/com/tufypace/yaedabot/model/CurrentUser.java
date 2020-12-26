package com.tufypace.yaedabot.model;

import com.tufypace.yaedabot.utils.SharedPreferencesProvider;

public class CurrentUser {
    private static SharedPreferencesProvider sSharedPreferencesProvider;// = new SharedPreferencesEmptyProvider();

    public static void init(SharedPreferencesProvider sharedPreferencesProvider) {
        sSharedPreferencesProvider = sharedPreferencesProvider;
    }

    public static String getUserObjectID() {
        return sSharedPreferencesProvider.getString("user_object_id");
    }

    public static void saveUserObjectID(String str) {
        sSharedPreferencesProvider.save("user_object_id", str);
    }


    public static void saveBoolean(String name, boolean value) {
        sSharedPreferencesProvider.save(name, value);
    }

    public static boolean getBoolean(String name) {
        return sSharedPreferencesProvider.getBoolean(name);
    }


    public static void saveInt(String name, int value) {
        sSharedPreferencesProvider.save(name, value);
    }

    public static int getInt(String name) {
        return sSharedPreferencesProvider.getInteger(name);
    }

    public static String getApi() {
        return sSharedPreferencesProvider.getString("user_api");
    }

    public static void saveApi(String str) {
        sSharedPreferencesProvider.save("user_api", str);
    }
}
