package com.tufypace.yaedabot.model.restoraunt;

public enum RestorauntPlaceBusiness {
    RESTAURANT("restaurant"),
    LAVKA("store"),
    SHOP("shop"),
    PHARMACY("pharmacy");

    private final String business;

    private RestorauntPlaceBusiness(String str) {
        this.business = str;
    }

    public final String a() {
        return this.business;
    }

    public String toString() {
        return this.business;
    }


}
