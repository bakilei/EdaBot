package com.tufypace.yaedabot.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import com.tufypace.yaedabot.Application;

public class NetworkUtils {
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;
    public static int TYPE_UNKNOWN = 3;
    public static int TYPE_WIFI = 1;

    public static int getConnectivityStatus(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return TYPE_NOT_CONNECTED;
        }
        if (!activeNetworkInfo.isConnected()) {
            return TYPE_NOT_CONNECTED;
        }
        if (activeNetworkInfo.getType() == 1) {
            return TYPE_WIFI;
        }
        if (activeNetworkInfo.getType() == 0) {
            return TYPE_MOBILE;
        }
        return TYPE_UNKNOWN;
    }

    public static String getConnectivityStatusString() {
        return getConnectivityStatusString(Application.getInstance());
    }

    public static String getConnectivityStatusString(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "not connected";
        }
        if (!activeNetworkInfo.isConnected()) {
            return activeNetworkInfo.getDetailedState().name();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(activeNetworkInfo.getDetailedState().name());
        sb.append(" ");
        sb.append(activeNetworkInfo.getTypeName());
        if (!TextUtils.isEmpty(activeNetworkInfo.getSubtypeName())) {
            sb.append(" ");
            sb.append(activeNetworkInfo.getSubtypeName());
        }
        return sb.toString();
    }
}
