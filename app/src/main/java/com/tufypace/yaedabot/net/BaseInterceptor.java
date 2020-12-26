package com.tufypace.yaedabot.net;

import android.location.Location;
import android.os.Build;

import com.tufypace.yaedabot.data.model.UIDPrefs;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URLEncoder;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BaseInterceptor implements Interceptor {
    private LocationProvider locationProvider;
    private UIDPrefs uidPrefs;

    public BaseInterceptor(LocationProvider locationProvider, UIDPrefs uidPrefs) {
        this.locationProvider = locationProvider;
        this.uidPrefs = uidPrefs;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("X-OS-Version", URLEncoder.encode(Build.VERSION.RELEASE, "UTF-8"));
        builder.addHeader("X-Device-Model", URLEncoder.encode(Build.MODEL, "UTF-8"));
        builder.addHeader("X-Device-Brand", URLEncoder.encode(Build.BRAND, "UTF-8"));
        builder.addHeader("X-Device-Manufacturer", URLEncoder.encode(Build.MANUFACTURER, "UTF-8"));
        builder.addHeader("X-App-Version", URLEncoder.encode("3.7.1", "UTF-8"));
        builder.addHeader("X-Code-Version", URLEncoder.encode(String.valueOf(169), "UTF-8"));
        builder.addHeader("X-Device-Id", URLEncoder.encode(this.uidPrefs.getUID(), "UTF-8"));
        builder.addHeader("X-API-TOKEN", URLEncoder.encode("", "UTF-8"));
        if ("POST".equalsIgnoreCase(request.method())) {
            builder.addHeader("Content-Type", "application/json");
            Location lastKnownLocation = this.locationProvider.getLastKnownLocation();
            if (lastKnownLocation != null) {
                try {
                    builder.addHeader("latitude", Double.toString(lastKnownLocation.getLatitude()));
                    builder.addHeader("longitude", Double.toString(lastKnownLocation.getLongitude()));
                    builder.addHeader("accuracy", Double.toString((double) lastKnownLocation.getAccuracy()));
                    if (Build.VERSION.SDK_INT >= 18) {
                        builder.addHeader("fakeGPS", "false");
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        Response a = chain.proceed(builder.build());
        if (a.code() == 403) {
            //       this.logoutManager.logout(LogoutManager.LogOutType.TOKEN_INVALID);
        }
        return a;
        //  return null;
    }
}

