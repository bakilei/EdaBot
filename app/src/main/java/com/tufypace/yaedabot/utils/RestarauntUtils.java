package com.tufypace.yaedabot.utils;

import com.tufypace.yaedabot.api.ApiClient;
import com.tufypace.yaedabot.api.RestorauntService;
import com.tufypace.yaedabot.ui.restoraunt.orders.PersonalPlacesOrder;

import retrofit2.Callback;

public class RestarauntUtils {

    public RestorauntService clientRestoraunt = ApiClient.getClientRestoraunt();


    public void getCatalogRestoraunt(double latitude, double longitude, String sort, Callback<PersonalPlacesOrder> callback) {
        clientRestoraunt.getCatalog(latitude, longitude, sort).enqueue(callback);
    }
}
