package com.tufypace.yaedabot.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.shift.ShiftSettingsResponse;

public class DialogHours extends Dialog {
    public TextView hours_dialog_hours_current_week;
    public TextView hours_dialog_hours_next_week;
    public ShiftSettingsResponse shiftSettingsResponse;

    public DialogHours(@NonNull Context context, ShiftSettingsResponse shiftSettingsResponse) {
        super(context);
        this.shiftSettingsResponse = shiftSettingsResponse;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }

        setContentView(R.layout.dialog_hours);
        findViewById(R.id.dialog_no_connection_exit_button).setOnClickListener(v -> DialogHours.this.dismiss());
    }

    @Override
    public void show() {
        super.show();
        hours_dialog_hours_current_week = findViewById(R.id.hours_dialog_hours_current_week);
        hours_dialog_hours_next_week = findViewById(R.id.hours_dialog_hours_next_week);
        hours_dialog_hours_current_week.setText("Часов на этой неделе: " + (int) this.shiftSettingsResponse.getData().getAttributes().getWorkTimeLimit().getCurrentWeek().getChosenShiftHours());
        hours_dialog_hours_next_week.setText("Часов на следующей неделе: " + (int) this.shiftSettingsResponse.getData().getAttributes().getWorkTimeLimit().getNextWeek().getChosenShiftHours());
    }
}
