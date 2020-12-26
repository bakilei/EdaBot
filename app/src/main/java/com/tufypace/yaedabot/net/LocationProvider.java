package com.tufypace.yaedabot.net;

import android.location.Location;

public class LocationProvider {
    public Location lastKnownLocation;

    public LocationProvider(Location lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }

    public final Location getLastKnownLocation() {
        return this.lastKnownLocation;
    }
}
