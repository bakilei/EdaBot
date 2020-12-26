package com.tufypace.yaedabot.api;

import android.os.Build;

import com.tufypace.yaedabot.Application;
import com.tufypace.yaedabot.utils.SharedPreferencesDefaultProvider;
import com.tufypace.yaedabot.utils.SharedPreferencesProvider;
import com.tufypace.yaedabot.utils.Utils;

import org.jetbrains.annotations.NotNull;

import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiClient {
    private static final String HEADER_NAME_AUTHORIZATION = "Authorization";
    public static final SharedPreferencesProvider mSharedPreferencesProvider = new SharedPreferencesDefaultProvider(Application.getAppContext());
    public SharedPreferencesDefaultProvider sharedPreferencesDefaultProvider;

    public static ApiEndpoints getClientEda() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Builder builder = new Builder();
        builder.addInterceptor(httpLoggingInterceptor).readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS);


        builder.addInterceptor(chain -> chain.proceed(chain.request().newBuilder()
                // .header(HEADER_NAME_AUTHORIZATION, AuthUtils.encodeAuthHeader(user.uid(), user.token()))
                /*       .addHeader("X-OS-Version", String.valueOf(Build.VERSION.SDK_INT))
                       .addHeader("X-Device-Model", Build.MODEL)
                       .addHeader("X-Device-Brand", Build.BRAND)
                       .addHeader("X-Device-Manufacturer", Build.MANUFACTURER)
                       .addHeader("X-App-Version", "3.7.1")
                       .addHeader("X-Code-Version", "169")
                       .addHeader("X-Device-Id", "")
                       .addHeader("X-API-TOKEN","")
                  //     .addHeader("latitude", String.valueOf(latitude))
                  //     .addHeader("longitude", String.valueOf(longitude))
                       .addHeader("accuracy","24.55242849345674")
                       .addHeader("fakeGPS","false")*/
                .addHeader("X-OS-Version", URLEncoder.encode(Build.VERSION.RELEASE, "UTF-8"))
                .addHeader("X-Device-Model", URLEncoder.encode(Build.MODEL, "UTF-8"))
                .addHeader("X-Device-Brand", URLEncoder.encode(Build.BRAND, "UTF-8"))
                .addHeader("X-Device-Manufacturer", URLEncoder.encode(Build.MANUFACTURER, "UTF-8"))
                .addHeader("X-App-Version", URLEncoder.encode("4.1.1", "UTF-8"))
                .addHeader("X-Code-Version", URLEncoder.encode(String.valueOf(178), "UTF-8"))
                .addHeader("X-Device-Id", URLEncoder.encode("frdfs342-fdf54gh57-h6fh-tgfh", "UTF-8"))

                .addHeader("X-API-TOKEN", URLEncoder.encode(mSharedPreferencesProvider.getString("api_key"), "UTF-8"))

                .addHeader("Content-Type", "application/json")
                //    Location lastKnownLocation = this.locationProvider.getLastKnownLocation();

                .addHeader("accuracy", Double.toString(Utils.randFloat(1, 99)))
                .addHeader("fakeGPS", "false")


                .build()));

        return new Retrofit.Builder().client(builder.build()).baseUrl("https://courier.eda.yandex/")
                //       .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiEndpoints.class);
    }

    @NotNull
    public static ShiftService getClientCtt() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Builder builder = new Builder();
        builder.addInterceptor(httpLoggingInterceptor).readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS);

        builder.addInterceptor(chain -> chain.proceed(chain.request().newBuilder()
                // .header(HEADER_NAME_AUTHORIZATION, AuthUtils.encodeAuthHeader(user.uid(), user.token()))
                /*       .addHeader("X-OS-Version", String.valueOf(Build.VERSION.SDK_INT))
                       .addHeader("X-Device-Model", Build.MODEL)
                       .addHeader("X-Device-Brand", Build.BRAND)
                       .addHeader("X-Device-Manufacturer", Build.MANUFACTURER)
                       .addHeader("X-App-Version", "3.7.1")
                       .addHeader("X-Code-Version", "169")
                       .addHeader("X-Device-Id", "")
                       .addHeader("X-API-TOKEN","")
                  //     .addHeader("latitude", String.valueOf(latitude))
                  //     .addHeader("longitude", String.valueOf(longitude))
                       .addHeader("accuracy","24.55242849345674")
                       .addHeader("fakeGPS","false")*/
                /*   .addHeader("X-OS-Version", URLEncoder.encode(Build.VERSION.RELEASE, "UTF-8"))
                   .addHeader("X-Device-Model", URLEncoder.encode(Build.MODEL, "UTF-8"))
                   .addHeader("X-Device-Brand", URLEncoder.encode(Build.BRAND, "UTF-8"))
                   .addHeader("X-Device-Manufacturer", URLEncoder.encode(Build.MANUFACTURER, "UTF-8"))
                   .addHeader("X-App-Version", URLEncoder.encode("3.7.1", "UTF-8"))
                   .addHeader("X-Code-Version", URLEncoder.encode(String.valueOf(169), "UTF-8"))
                   .addHeader("X-Device-Id", URLEncoder.encode("frdfs342-fdfdgh57-hgfh-tgfh", "UTF-8"))
                   .addHeader("X-API-TOKEN", URLEncoder.encode("", "UTF-8"))*/
                .addHeader("Content-Type", "application/json")
                //    Location lastKnownLocation = this.locationProvider.getLastKnownLocation();

                .addHeader("AUTHORIZATION", "Bearer " + mSharedPreferencesProvider.getString("api_key"))
                //      .addHeader("longitude", Double.toString(55.6753))
                //       .addHeader("accuracy", Double.toString((double) 24.55242849345674))
                //     .addHeader("fakeGPS", "false")


                .build()));

        return new Retrofit.Builder().client(builder.build()).baseUrl("https://ctt.eda.yandex/")
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build().create(ShiftService.class);
    }

    public static RestorauntService getClientRestoraunt() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        Builder builder = new Builder();
        builder.addInterceptor(httpLoggingInterceptor).readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS);


        builder.addInterceptor(chain -> chain.proceed(chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")

                .build()));

        return new Retrofit.Builder().client(builder.build()).baseUrl("https://eda.yandex/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RestorauntService.class);
    }

    public static ShiftService getClientStartCtt() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Builder builder = new Builder();
        builder.addInterceptor(httpLoggingInterceptor).readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS);


        builder.addInterceptor(chain -> chain.proceed(chain.request().newBuilder()
                // .header(HEADER_NAME_AUTHORIZATION, AuthUtils.encodeAuthHeader(user.uid(), user.token()))
                /*       .addHeader("X-OS-Version", String.valueOf(Build.VERSION.SDK_INT))
                       .addHeader("X-Device-Model", Build.MODEL)
                       .addHeader("X-Device-Brand", Build.BRAND)
                       .addHeader("X-Device-Manufacturer", Build.MANUFACTURER)
                       .addHeader("X-App-Version", "3.7.1")
                       .addHeader("X-Code-Version", "169")
                       .addHeader("X-Device-Id", "")
                       .addHeader("X-API-TOKEN","")
                  //     .addHeader("latitude", String.valueOf(latitude))
                  //     .addHeader("longitude", String.valueOf(longitude))
                       .addHeader("accuracy","24.55242849345674")
                       .addHeader("fakeGPS","false")*/
                /*   .addHeader("X-OS-Version", URLEncoder.encode(Build.VERSION.RELEASE, "UTF-8"))
                   .addHeader("X-Device-Model", URLEncoder.encode(Build.MODEL, "UTF-8"))
                   .addHeader("X-Device-Brand", URLEncoder.encode(Build.BRAND, "UTF-8"))
                   .addHeader("X-Device-Manufacturer", URLEncoder.encode(Build.MANUFACTURER, "UTF-8"))
                   .addHeader("X-App-Version", URLEncoder.encode("3.7.1", "UTF-8"))
                   .addHeader("X-Code-Version", URLEncoder.encode(String.valueOf(169), "UTF-8"))
                   .addHeader("X-Device-Id", URLEncoder.encode("frdfs342-fdfdgh57-hgfh-tgfh", "UTF-8"))
                   .addHeader("X-API-TOKEN", URLEncoder.encode("", "UTF-8"))*/
                .addHeader("Content-Type", "application/json")
                //    Location lastKnownLocation = this.locationProvider.getLastKnownLocation();

                .addHeader("AUTHORIZATION", "Bearer " + mSharedPreferencesProvider.getString("api_key"))
                //      .addHeader("longitude", Double.toString(55.6753))
                //       .addHeader("accuracy", Double.toString((double) 24.55242849345674))
                //     .addHeader("fakeGPS", "false")


                .build()));

        return new Retrofit.Builder().client(builder.build()).baseUrl("https://ctt.eda.yandex/").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(ShiftService.class);
    }
}

