package com.tufypace.yaedabot.metrica;


import com.tufypace.yaedabot.base.Provider;
import com.tufypace.yaedabot.net.LocationProvider;

import dagger.internal.Factory;

public final class MetricaHandlerImpl_Factory implements Factory<MetricaHandlerImpl> {
    private final Provider<LocationProvider> locationProvider;

    public MetricaHandlerImpl_Factory(Provider<LocationProvider> aVar) {
        this.locationProvider = aVar;
    }

    public static MetricaHandlerImpl_Factory create(Provider<LocationProvider> aVar) {
        return new MetricaHandlerImpl_Factory(aVar);
    }

    public static MetricaHandlerImpl newInstance(LocationProvider locationProvider2) {
        return new MetricaHandlerImpl(locationProvider2);
    }

    public MetricaHandlerImpl get() {
        return new MetricaHandlerImpl(this.locationProvider.get());
    }
}