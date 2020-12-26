package com.tufypace.yaedabot.utils;

import android.location.Location;
import android.util.Log;

import com.tufypace.yaedabot.api.ApiClient;
import com.tufypace.yaedabot.api.ApiEndpoints;
import com.tufypace.yaedabot.api.ShiftService;
import com.tufypace.yaedabot.metrica.MetricaHandler;
import com.tufypace.yaedabot.metrica.MetricaHandlerImpl;
import com.tufypace.yaedabot.metrica.events.OrderRemovedEvent;
import com.tufypace.yaedabot.model.order.ApiOrderModel;
import com.tufypace.yaedabot.model.order.OrderModel;
import com.tufypace.yaedabot.model.order.OrderTransition;
import com.tufypace.yaedabot.model.order.OrdersResponse;
import com.tufypace.yaedabot.model.request.CourierShiftSaveRequest;
import com.tufypace.yaedabot.model.request.CourierTypeShiftOperation;
import com.tufypace.yaedabot.model.request.LocationPushRequest;
import com.tufypace.yaedabot.model.request.ShiftLocation;
import com.tufypace.yaedabot.model.request.ShiftOperation;
import com.tufypace.yaedabot.model.request.StartUnplannedShiftOperation;
import com.tufypace.yaedabot.model.responses.BalanceHistoryResponse;
import com.tufypace.yaedabot.model.responses.ChangesListResponse;
import com.tufypace.yaedabot.model.responses.CourierInfoResponse;
import com.tufypace.yaedabot.model.responses.ShiftsResponse;
import com.tufypace.yaedabot.model.shift.CourierShift;
import com.tufypace.yaedabot.model.shift.CourierShiftsActive;
import com.tufypace.yaedabot.model.shift.ShiftSettingsResponse;
import com.tufypace.yaedabot.net.LocationProvider;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderUtils {
    public CourierTypeShiftOperation courierTypeShiftOperation;
    private MetricaHandler metricaHandler = new MetricaHandlerImpl(new LocationProvider(new Location("")));

    public CourierTypeShiftOperation getRegionWork(CourierShift courierShift) {

        switch (courierShift.getAttributes().startPoint.getId()) {
            case "5801":
                Log.d("РАЙОН", "цЕНТР");
                double rangeLongitudeMinCentr = 65.541230;
                double rangeLongitudeMaxCentr = 65.541261;

                double rangeLatitudeMinCent = 57.148510;
                double rangeLatitudeMaxCentr = 57.148544;
                Random r = new Random();
                double randomLatitudeCentr = rangeLatitudeMinCent + (rangeLatitudeMaxCentr - rangeLatitudeMinCent) * r.nextDouble();
                double randomLongitudeCentr = rangeLongitudeMinCentr + (rangeLongitudeMaxCentr - rangeLongitudeMinCentr) * r.nextDouble();


                Log.d(String.valueOf(randomLatitudeCentr), String.valueOf(randomLongitudeCentr));
                courierTypeShiftOperation = new CourierTypeShiftOperation("6261666d-5c40-40f3-9b28-8eb2f943d151", new ShiftLocation(randomLatitudeCentr, randomLongitudeCentr), "pedestrian", false);
                return courierTypeShiftOperation;
            case "5804":
                Log.d("РАЙОН", "КПД");
                double rangeLongitudeMinKpd = 65.549221;
                double rangeLongitudeMaxKpd = 65.549241;

                double rangeLatitudeMinKpd = 57.146930;
                double rangeLatitudeMaxKpd = 57.146950;
                r = new Random();
                double randomLatitudeKpd = rangeLatitudeMinKpd + (rangeLatitudeMaxKpd - rangeLatitudeMinKpd) * r.nextDouble();
                double randomLongitudeKpd = rangeLongitudeMinKpd + (rangeLongitudeMaxKpd - rangeLongitudeMinKpd) * r.nextDouble();


                Log.d(String.valueOf(randomLatitudeKpd), String.valueOf(randomLongitudeKpd));
                courierTypeShiftOperation = new CourierTypeShiftOperation("6261666d-5c40-40f3-9b28-8eb2f943d151", new ShiftLocation(randomLatitudeKpd, randomLongitudeKpd), "pedestrian", false);
                return courierTypeShiftOperation;
            case "5822":
                Log.d("Район", "УХМ");

                Random random = new Random();
                double randomLatitudeUhm = 57.172824 + (57.172849 - 57.172824) * random.nextDouble();
                double randomLongitudeUhm = 65.566901 + (65.566925 - 65.566901) * random.nextDouble();
                Log.d(String.valueOf(randomLatitudeUhm), String.valueOf(randomLongitudeUhm));
                courierTypeShiftOperation = new CourierTypeShiftOperation("6261666d-5c40-40f3-9b28-8eb2f943d151", new ShiftLocation(randomLatitudeUhm, randomLongitudeUhm), "pedestrian", false);
                return courierTypeShiftOperation;
            case "5810":
                Log.d("Район", "Восточка");
                random = new Random();
                double randomLatitudeVost = 57.120172 + (57.120192 - 57.120172) * random.nextDouble();
                double randomLongitudeVost = 65.578003 + (65.578023 - 65.578003) * random.nextDouble();
                Log.d(String.valueOf(randomLatitudeVost), String.valueOf(randomLongitudeVost));
                courierTypeShiftOperation = new CourierTypeShiftOperation("6261666d-5c40-40f3-9b28-8eb2f943d151", new ShiftLocation(randomLatitudeVost, randomLongitudeVost), "pedestrian", false);
                return courierTypeShiftOperation;
            default:
                return courierTypeShiftOperation;
        }
    }


    public ShiftService clientctt = ApiClient.getClientCtt();
    public ApiEndpoints clienteda = ApiClient.getClientEda();

    public void sendStartShift(CourierShift courierShift, Callback<String> callback) {
        clientctt.startShift(courierShift.getId(), getRegionWork(courierShift)).enqueue(
                callback);
    }

    public void sendGetSettings(Callback<ShiftSettingsResponse> callback) {
        clientctt.getSettings().enqueue(callback);
    }

    public void sendGetFreeSlots(Callback<ShiftsResponse> callback, String data, List<String> stringList) {
        clientctt.getShifts(data, stringList).enqueue(callback);
    }

    public void sendSaveShift(CourierShiftSaveRequest courierShiftSaveRequest, Callback<String> callback) {
        clientctt.saveShifts(courierShiftSaveRequest).enqueue(callback);
    }

    public void getZakazi(Callback<OrdersResponse> callback, String latitude, String longitude) {
        clienteda.getOrders(latitude, longitude).enqueue(callback);
    }

    public void sendLocation(LocationPushRequest locationPushRequest, Callback<String> callback, String latitude, String longitude) {

        clienteda.pushLocation(locationPushRequest, latitude, longitude).enqueue(callback);
    }

    public void sendShiftsChanges(Callback<ChangesListResponse> callback) {
        clientctt.getShiftChanges().enqueue(callback);
    }

/*
    public void changeZakazState(String zakazNumber, OrderTransition orderTransition, Callback<ApiOrderModel> apiOrderModelCallback){
        clientctt.changeOrderState(zakazNumber, orderTransition).enqueue(apiOrderModelCallback);
    }
*/


    public void startUnplannedShift(StartUnplannedShiftOperation startUnplannedShiftOperation, Callback<String> stringCallback) {
        clientctt.startUnplannedShift(startUnplannedShiftOperation).enqueue(stringCallback);
    }

    public void stopShift(int shiftId, ShiftOperation shiftOperation, Callback<String> stringCallback) {
        String uuid = UUID.randomUUID().toString();
        clientctt.stopShift(shiftId, shiftOperation).enqueue(stringCallback);

    }

    public void unpauseShift(int shiftId, CourierTypeShiftOperation courierTypeShiftOperation, Callback<String> stringCallback) {
        clientctt.unpauseShift(shiftId, courierTypeShiftOperation).enqueue(stringCallback);
    }

    public void refuseShift(int shiftId, Callback<String> stringCallback) {
        clientctt.refuseShift(shiftId).enqueue(stringCallback);
    }

    public void pauseShift(int shiftId, ShiftOperation shiftOperation, Callback<String> stringCallback) {
        clientctt.pauseShift(shiftId, shiftOperation).enqueue(stringCallback);
    }

    public void getCourierInfo(Callback<CourierInfoResponse> callback, String latitude, String longitude) {
        clienteda.getCourierInfo(latitude, longitude).enqueue(callback);
    }

    public void getBalanceHistory(Callback<BalanceHistoryResponse> balanceHistoryResponseCallback) {
        clienteda.getBalanceHistory(20, 0).enqueue(balanceHistoryResponseCallback);
    }


    public void changeZakaState(String orderNr, OrderTransition orderTransition, Callback<ApiOrderModel> callback) {
        clienteda.changeOrderState(orderNr, orderTransition).enqueue(new Callback<ApiOrderModel>() {
            @Override
            public void onResponse(Call<ApiOrderModel> call, Response<ApiOrderModel> response) {
                Log.d("ZAKAZ STATE", response.toString());
            }

            @Override
            public void onFailure(Call<ApiOrderModel> call, Throwable t) {
                Log.d("ZAKAZ STATE", t.toString());
            }
        });
    }

    public void changeZakaState(String orderNr, OrderTransition orderTransition, String latitude, String longitude, Callback<ApiOrderModel> callback) {
        clienteda.changeOrderState(orderNr, orderTransition, latitude, longitude).enqueue(new Callback<ApiOrderModel>() {
            @Override
            public void onResponse(Call<ApiOrderModel> call, Response<ApiOrderModel> response) {
                Log.d("ZAKAZ STATE", response.toString());
            }

            @Override
            public void onFailure(Call<ApiOrderModel> call, Throwable t) {
                Log.d("ZAKAZ STATE", t.toString());
            }
        });
    }

    public void getShiftActive(Callback<CourierShiftsActive> callback) {
        clientctt.getShiftsActive().enqueue(callback);
    }

    private final void publishRemovedEvent(OrderModel orderModel, CourierShift courierShift, String str) {
        if (courierShift != null) {
            MetricaHandler metricaHandler2 = this.metricaHandler;
            String orderNumber = orderModel.orderNumber;
            Intrinsics.areEqual((Object) orderNumber, "order.orderNumber");
            metricaHandler2.publishEvent(new OrderRemovedEvent(orderNumber, courierShift.getId(), str), Save.sleep_latitude, Save.sleep_longitude);
        }
    }
}