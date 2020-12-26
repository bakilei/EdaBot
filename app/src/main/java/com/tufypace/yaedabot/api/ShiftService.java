package com.tufypace.yaedabot.api;

import com.tufypace.yaedabot.model.order.ApiOrderModel;
import com.tufypace.yaedabot.model.order.OrderCancelClientNotConnected;
import com.tufypace.yaedabot.model.order.OrderTransition;
import com.tufypace.yaedabot.model.request.CourierShiftSaveRequest;
import com.tufypace.yaedabot.model.request.CourierTypeShiftOperation;
import com.tufypace.yaedabot.model.request.ShiftOperation;
import com.tufypace.yaedabot.model.request.StartUnplannedShiftOperation;
import com.tufypace.yaedabot.model.responses.ChangesListResponse;
import com.tufypace.yaedabot.model.responses.DeliveryZonesResponse;
import com.tufypace.yaedabot.model.responses.PossibleDurationResponse;
import com.tufypace.yaedabot.model.responses.ShiftsResponse;
import com.tufypace.yaedabot.model.shift.CourierShiftsActive;
import com.tufypace.yaedabot.model.shift.ShiftSettingsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ShiftService {
   /* @POST("/courier-shifts/{shiftId}/changes/approve")
    a approveShiftChanges(@p("shiftId") int i);

    @POST("/courier-shifts/{shiftId}/swap")
    a changeShift(@p("shiftId") int i, @retrofit2.q.a CourierShiftSaveRequest courierShiftSaveRequest);

    @POST("/courier-shifts/{shiftId}/changes/decline")
    a declineShiftChanges(@p("shiftId") int i);

    @GET("/delivery-zones")
    Observable<DeliveryZonesResponse> getDeliveryZones();

    @GET("/possible-shift-duration/unplanned")
    Observable<PossibleDurationResponse> getPossibleShiftDuration();


    @GET("/courier-shifts/changes")
    Observable<ChangesListResponse> getShiftChanges();

    @GET("/courier-shifts")
    Observable<ShiftsResponse> getShifts(@q("filters[date]") String str, @q("filters[zones][]") List<String> list);

    @GET("/courier-shifts/actual")
    Observable<CourierShiftsActive> getShiftsActive();

    @POST("/courier-shifts/{shiftId}/pause")
    a pauseShift(@p("shiftId") int i, @retrofit2.q.a ShiftOperation shiftOperation);

    @POST("/courier-shifts/{shiftId}/refuse")
    a refuseShift(@p("shiftId") int i);

    @POST("/courier-shifts/")
    a saveShifts(@retrofit2.q.a CourierShiftSaveRequest courierShiftSaveRequest);

    @POST("/courier-shifts/{shiftId}/start")
    a startShift(@p("shiftId") int i, @retrofit2.q.a CourierTypeShiftOperation courierTypeShiftOperation);

    @POST("/courier-shifts/unplanned/start")
    a startUnplannedShift(@retrofit2.q.a StartUnplannedShiftOperation startUnplannedShiftOperation);

    @POST("/courier-shifts/{shiftId}/stop")
    a stopShift(@p("shiftId") int i, @retrofit2.q.a ShiftOperation shiftOperation);

    @POST("/courier-shifts/{shiftId}/unpause")
    a unpauseShift(@p("shiftId") int i, @retrofit2.q.a CourierTypeShiftOperation courierTypeShiftOperation);*/

    @GET("/courier-shifts/actual")
    Call<CourierShiftsActive> getShiftsActive();

    @POST("/courier-shifts/{shiftId}/start")
    Call<String> startShift(@Path("shiftId") int i, @Body CourierTypeShiftOperation courierTypeShiftOperation);

    @POST("/courier-shifts/")
    Call<String> saveShifts(@Body CourierShiftSaveRequest courierShiftSaveRequest);


    @POST("api/v2/orders/{orderNr}/transition")
    Call<ApiOrderModel> cancelOrder(@Path("orderNr") String str, @Body OrderCancelClientNotConnected orderCancelClientNotConnected);

    @POST("api/v2/orders/{orderNr}/transition")
    Call<ApiOrderModel> changeOrderState(@Path("orderNr") String str, @Body OrderTransition orderTransition);


    @POST("/courier-shifts/{shiftId}/changes/approve")
    Call<String> approveShiftChanges(@Path("shiftId") int i);

    @POST("/courier-shifts/{shiftId}/swap")
    Call<String> changeShift(@Path("shiftId") int i, @Body CourierShiftSaveRequest courierShiftSaveRequest);

    @POST("/courier-shifts/{shiftId}/changes/decline")
    Call<String> declineShiftChanges(@Path("shiftId") int i);

    @GET("/delivery-zones")
    Call<DeliveryZonesResponse> getDeliveryZones();

    @GET("/possible-shift-duration/unplanned")
    Call<PossibleDurationResponse> getPossibleShiftDuration();

    @GET("/settings")
    Call<ShiftSettingsResponse> getSettings();

    @GET("/courier-shifts/changes")
    Call<ChangesListResponse> getShiftChanges();

    @GET("/courier-shifts")
    Call<ShiftsResponse> getShifts(@Query("filters[date]") String str, @Query("filters[zones][]") List<String> list);


    @POST("/courier-shifts/{shiftId}/pause")
    Call<String> pauseShift(@Path("shiftId") int i, @Body ShiftOperation shiftOperation);

    @POST("/courier-shifts/{shiftId}/refuse")
    Call<String> refuseShift(@Path("shiftId") int i);


    @POST("/courier-shifts/unplanned/start")
    Call<String> startUnplannedShift(@Body StartUnplannedShiftOperation startUnplannedShiftOperation);

    @POST("/courier-shifts/{shiftId}/stop")
    Call<String> stopShift(@Path("shiftId") int i, @Body ShiftOperation shiftOperation);

    @POST("/courier-shifts/{shiftId}/unpause")
    Call<String> unpauseShift(@Path("shiftId") int i, @Body CourierTypeShiftOperation courierTypeShiftOperation);


    Call<Boolean> sendCoordinates();
}


