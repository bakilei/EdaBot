package com.tufypace.yaedabot.ui.dialog;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.tufypace.yaedabot.R;

public class DialogError extends Dialog {

    public String error;

    public DialogError(@NonNull Context context, String error) {
        super(context);
        this.error = error;
    }


    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }

        setContentView(R.layout.dialog);
        setCancelable(true);
        findViewById(R.id.dialog_no_connection_exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogError.this.dismiss();
            }
        });
    }

    @Override
    public void show() {
        super.show();
        TextView textView = findViewById(R.id.error_textview);
        textView.setText(this.error);
    }
}
