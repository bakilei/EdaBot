package com.tufypace.yaedabot;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.tufypace.yaedabot.model.CurrentUser;
import com.tufypace.yaedabot.utils.Save;
import com.tufypace.yaedabot.utils.SharedPreferencesDefaultProvider;
import com.tufypace.yaedabot.utils.SharedPreferencesProvider;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

public class Application extends MultiDexApplication {
    private static Application instance;
    private static Context mContext;

    public static Context getAppContext() {
        return mContext;
    }

    //  private AppComponent component;
    public static Application getInstance() {
        return instance;
    }

    public static void setInstance(Application instance) {
        Application.instance = instance;
    }

    private final SharedPreferencesProvider mSharedPreferencesProvider = new SharedPreferencesDefaultProvider(this);

    private void initAppMetrica() {
        YandexMetricaConfig newInternalConfigBuilder = YandexMetricaConfig.newConfigBuilder(Save.APP_METRICA_KEY).build();
        //     newInternalConfigBuilder.withPulseConfig(PulseConfig.newBuilder(this, BuildConfig.HISTOGRAM_PULSE).build());
        YandexMetrica.activate(getApplicationContext(), newInternalConfigBuilder);
        //      YandexMetrica.activate(this, newInternalConfigBuilder);
        YandexMetrica.enableActivityAutoTracking(this);

    }

    public void onCreate() {
        super.onCreate();
        //       Fabric.with(this, new Crashlytics());
        //       mBackpack = new Backpack();
        CurrentUser.init(this.mSharedPreferencesProvider);
        mContext = getApplicationContext();
        //     initAppMetrica();
    }


}
