package com.tufypace.yaedabot.api;

import com.tufypace.yaedabot.ui.restoraunt.orders.PersonalPlacesOrder;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestorauntService {

    @GET("/api/v2/catalog")
    Call<PersonalPlacesOrder> getCatalog(@Query("latitude") double latitude, @Query("longitude") double longitude, @Query("sort") String sort);
}
