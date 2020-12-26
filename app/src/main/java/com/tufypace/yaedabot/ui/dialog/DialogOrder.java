package com.tufypace.yaedabot.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.api.ApiClient;
import com.tufypace.yaedabot.api.ShiftService;
import com.tufypace.yaedabot.model.shift.CourierShift;
import com.tufypace.yaedabot.utils.DateUtils;
import com.tufypace.yaedabot.utils.OrderUtils;
import com.tufypace.yaedabot.utils.ShiftUtils;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DialogOrder extends Dialog {
    public Button start, pause, refuse;
    public CourierShift courierShift;

    public DialogOrder(@NonNull Context context, CourierShift courierShift) {
        super(context);
        this.courierShift = courierShift;
    }

    public TextView order_dialog_status, dialog_name_slot, order_dialog_region;

    ShiftService clientctt = ApiClient.getClientCtt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }

        setContentView(R.layout.dialog_order);

        setCancelable(true);


        findViewById(R.id.dialog_no_connection_exit_button).setOnClickListener(v -> DialogOrder.this.dismiss());
    }

    @Override
    public void show() {
        super.show();
        dialog_name_slot = findViewById(R.id.dialog_name_slot);
        order_dialog_status = findViewById(R.id.hours_dialog_hours_next_week);
        order_dialog_region = findViewById(R.id.hours_dialog_hours_current_week);
        this.start = findViewById(R.id.button_nyr);
        this.pause = findViewById(R.id.bt_dialog_order_pause);
        pause.setOnClickListener(v -> {
            OrderUtils orderUtils = new OrderUtils();
            ShiftUtils shiftUtils = new ShiftUtils();
            orderUtils.pauseShift(courierShift.id, shiftUtils.getShiftOperationByRegionWork(courierShift), new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        });
        this.refuse = findViewById(R.id.bt_dialog_order_refuse);


        refuse.setOnClickListener(v -> {
            OrderUtils orderUtils = new OrderUtils();
            ShiftUtils shiftUtils = new ShiftUtils();

            orderUtils.refuseShift(courierShift.id, new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        });
        setTitle("Слот№ " + courierShift.getId());
        order_dialog_region.setText("Район: " + courierShift.getAttributes().startPoint.getAttributes().getName());
        if (courierShift.getAttributes().status.equals("Planned")) {
            order_dialog_status.setText("Статус: " + "Запланирован на " + DateUtils.parseDateFromServer(courierShift.getAttributes().startsAt) + " (Время по МСК)");
            this.start.setVisibility(View.VISIBLE);
            this.start.setOnClickListener(v -> {

                OrderUtils orderUtils = new OrderUtils();
                orderUtils.sendStartShift(courierShift, new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d("ПРИШЕЛ ОТВЕ", "ДИАЛОГУ!!!");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("ПРИШЕЛ ОТВЕТ ОШИБКА", "ДИАЛОГУ!!!");
                    }
                });


            });
        } else if (courierShift.getAttributes().status.equals("Closed")) {
            order_dialog_status.setText("Статус: " + "Выполнен");
            order_dialog_status.setTextColor(Color.RED);
            this.start.setVisibility(View.GONE);
        } else if (courierShift.getAttributes().status.equals("In progress")) {
            this.start.setText("Закончить слот!");
            this.start.setOnClickListener(v -> {

                OrderUtils orderUtils = new OrderUtils();
                ShiftUtils shiftUtils = new ShiftUtils();
                String uuid = UUID.randomUUID().toString();
                orderUtils.stopShift(courierShift.id, shiftUtils.getShiftOperationByRegionWork(courierShift), new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d("ПРИШЕЛ ОТВЕ", "ДИАЛОГУ!!!");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("ПРИШЕЛ ОТВЕТ ОШИБКА", "ДИАЛОГУ!!!");
                    }
                });


            });
        }
        // order_dialog_status.setText("Статус: "+courierShift.getAttributes().status);
    }

    public void setTitle(String title) {
        dialog_name_slot.setText(title);
    }


}
