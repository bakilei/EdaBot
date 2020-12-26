package com.tufypace.yaedabot.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.request.CourierShiftSaveRequest;
import com.tufypace.yaedabot.model.request.FlatOpenedCourierShift;
import com.tufypace.yaedabot.model.shift.OpenedCourierShift;
import com.tufypace.yaedabot.utils.OrderUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DialogOpenSlot extends Dialog {
    public OpenedCourierShift openedCourierShift;
    public TextView open_dialog_start_at, open_dialog_point_name, open_dialog_end_at, dialog_name_slot;
    public Button open_slot_button_give_slot;

    public DialogOpenSlot(@NonNull Context context, OpenedCourierShift openedCourierShift) {
        super(context);
        this.openedCourierShift = openedCourierShift;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }

        setContentView(R.layout.dialog_open_slot);

        setCancelable(true);


        findViewById(R.id.dialog_no_connection_exit_button).setOnClickListener(v -> DialogOpenSlot.this.dismiss());
    }

    @Override
    public void show() {
        super.show();
        dialog_name_slot = findViewById(R.id.dialog_name_slot);
        open_dialog_start_at = findViewById(R.id.open_dialog_start_at);
        open_dialog_point_name = findViewById(R.id.open_dialog_point_name);
        open_dialog_end_at = findViewById(R.id.open_dialog_end_at);
        this.open_slot_button_give_slot = findViewById(R.id.open_slot_button_give_slot);
        setTitle("Слот№ " + openedCourierShift.getId());
        open_dialog_start_at.setText(openedCourierShift.getAttributes().getStartsAt());
        open_dialog_end_at.setText(openedCourierShift.getAttributes().getEndsAt());
        open_dialog_point_name.setText(openedCourierShift.getAttributes().getStartPoint().getAttributes().getName());
        this.open_slot_button_give_slot.setOnClickListener(view -> {
            List<FlatOpenedCourierShift> listFlatOpenedCourierShift = new ArrayList<>();

            String format = openedCourierShift.getAttributes().getStartsAt();
            String format2 = openedCourierShift.getAttributes().getEndsAt();
            String uuid = UUID.randomUUID().toString();
            Intrinsics.areEqual(uuid, "UUID.randomUUID().toString()");
            Intrinsics.areEqual(format, "startsAt");
            Intrinsics.areEqual(format2, "endsAt");
            OrderUtils orderUtils = new OrderUtils();
            listFlatOpenedCourierShift.add(new FlatOpenedCourierShift(uuid, format, format2, openedCourierShift.getAttributes().getStartPoint().getId()));
            String uuid2 = UUID.randomUUID().toString();
            CourierShiftSaveRequest courierShiftSaveRequest = new CourierShiftSaveRequest(uuid2, listFlatOpenedCourierShift);
            orderUtils.sendSaveShift(courierShiftSaveRequest, new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.body() != null) {
                        Log.d("ПРИШЕЛ ОТВЕ", response.body());
                    }
                    if (response.errorBody() != null) {
                        try {
                            Log.d("ПРИШЕЛ ОТВЕ", response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("ПРИШЕЛ ОТВЕТ ОШИБКА", Objects.requireNonNull(t.getMessage()));
                }
            });

        });
    }

    public void setTitle(String title) {
        dialog_name_slot.setText(title);
    }
}
