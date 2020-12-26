package com.tufypace.yaedabot.base;

import com.tufypace.yaedabot.data.model.UIDPrefs;
import com.tufypace.yaedabot.net.BaseInterceptor;
import com.tufypace.yaedabot.net.LocationProvider;

import javax.inject.Provider;

import dagger.internal.Factory;

public class BaseInterceptor_Factory implements Factory<BaseInterceptor> {
    private final Provider<LocationProvider> locationProvider;
    private final Provider<UIDPrefs> uidPrefsProvider;

    public BaseInterceptor_Factory(Provider<LocationProvider> locationProvider, Provider<UIDPrefs> uidPrefsProvider) {
        this.locationProvider = locationProvider;
        this.uidPrefsProvider = uidPrefsProvider;
    }

    @Override
    public BaseInterceptor get() {
        return new BaseInterceptor(this.locationProvider.get(), this.uidPrefsProvider.get());
    }
}
