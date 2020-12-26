package com.tufypace.yaedabot.api;

import com.tufypace.yaedabot.model.Credentials;
import com.tufypace.yaedabot.model.order.ApiOrderModel;
import com.tufypace.yaedabot.model.order.OrderCancelClientNotConnected;
import com.tufypace.yaedabot.model.order.OrderTransition;
import com.tufypace.yaedabot.model.order.OrdersResponse;
import com.tufypace.yaedabot.model.request.LocationPushRequest;
import com.tufypace.yaedabot.model.responses.BalanceHistoryResponse;
import com.tufypace.yaedabot.model.responses.ConfigResponse;
import com.tufypace.yaedabot.model.responses.CourierInfoResponse;
import com.tufypace.yaedabot.model.responses.EmployerResponse;
import com.tufypace.yaedabot.model.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpoints {

    @POST("api/v1/geolocation/push")
    Call<String> pushLocation(@Body LocationPushRequest locationPushReques, @Header("latitude") String latitude, @Header("longitude") String longitude);


    @POST("api/v2/authenticate")
    Call<LoginResponse> authenticate(@Body Credentials user);

    @GET("api/v2/orders")
    Call<OrdersResponse> getOrders(@Header("latitude") String latitude, @Header("longitude") String longitude);

    @POST("api/v1/geolocation/push")
    Call<Response<Void>> sendLocation(@Body LocationPushRequest locationPushRequest);

    @GET("/api/v2/config")
    Call<ConfigResponse> getConfig(@Header("x-api-token") String api);


    @POST("api/v2/orders/{orderNr}/transition")
    Call<ApiOrderModel> cancelOrder(@Path("orderNr") String str, @Body OrderCancelClientNotConnected orderCancelClientNotConnected);

    @POST("api/v2/orders/{orderNr}/transition")
    Call<ApiOrderModel> changeOrderState(@Path("orderNr") String orderNr, @Body OrderTransition orderTransition);

    @POST("api/v2/orders/{orderNr}/transition")
    Call<ApiOrderModel> changeOrderState(@Path("orderNr") String orderNr, @Body OrderTransition orderTransition, @Header("latitude") String latitude, @Header("longitude") String longitude);

    @GET("api/v2/courier/info")
    Call<CourierInfoResponse> getCourierInfo(@Header("latitude") String latitude, @Header("longitude") String longitude);


    @GET("api/v2/courier/employer")
    Call<EmployerResponse> getEmployer();


    @GET("api/v2/courier/bank_account_history")
    Call<BalanceHistoryResponse> getBalanceHistory(@Query("limit") int i, @Query("offset") int i2);
}
