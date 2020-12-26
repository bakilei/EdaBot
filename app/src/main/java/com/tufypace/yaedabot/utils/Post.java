package com.tufypace.yaedabot.utils;

import android.os.Build;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Post {

    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    public interface ResultHandler {
        void onSuccess(String response);

        void onFail(IOException error);
    }

    public void post(String url, String json, final ResultHandler callback, double latitude, double longitude) throws IOException {

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url).post(body)
                .addHeader("X-OS-Version", String.valueOf(Build.VERSION.SDK_INT))
                .addHeader("X-Device-Model", Build.MODEL)
                .addHeader("X-Device-Brand", Build.BRAND)
                .addHeader("X-Device-Manufacturer", Build.MANUFACTURER)
                .addHeader("X-App-Version", "3.7.1")
                .addHeader("X-Code-Version", "169")
                .addHeader("X-Device-Id", "")
                .addHeader("X-API-TOKEN", "")
                .addHeader("latitude", String.valueOf(latitude))
                .addHeader("longitude", String.valueOf(longitude))
                .addHeader("accuracy", "24.55242849345674")
                .addHeader("fakeGPS", "false")

                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, IOException e) {
                callback.onFail(e);
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String res = response.body().string();
                callback.onSuccess(res);
            }
        });
    }
}
