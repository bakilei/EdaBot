package com.tufypace.yaedabot.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.utils.SharedPreferencesDefaultProvider;
import com.tufypace.yaedabot.utils.SharedPreferencesProvider;

public class DialogSettings extends Dialog {
    public final SharedPreferencesProvider mSharedPreferencesProvider = new SharedPreferencesDefaultProvider(getContext());

    public DialogSettings(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }

        setContentView(R.layout.dialog_settings);
        setCancelable(true);
        findViewById(R.id.dialog_no_connection_exit_button).setOnClickListener(v -> DialogSettings.this.dismiss());
    }

    @Override
    public void show() {
        super.show();
        CheckBox checkBox = findViewById(R.id.hunter_slots_cb);
        checkBox.setChecked(mSharedPreferencesProvider.getBoolean("hunter_slots"));
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            mSharedPreferencesProvider.save("hunter_slots", isChecked);
        });
    }
}
