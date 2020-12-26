package com.tufypace.yaedabot.ui.hunter;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.CurrentUser;
import com.tufypace.yaedabot.ui.BaseFragment;

public class HunterFragment extends BaseFragment {
    public String TAG = HunterFragment.this.getTag();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_hunter, container, false);
        TextView tv_hunter_status = inflate.findViewById(R.id.tv_hunter_status);
        Button bt_hunter_save = inflate.findViewById(R.id.bt_hunter_save);

        CheckBox cb_uhm_monday = inflate.findViewById(R.id.cb_uhm_monday);
        CheckBox cb_kpd_monday = inflate.findViewById(R.id.cb_kpd_monday);
        CheckBox cb_center_monday = inflate.findViewById(R.id.cb_center_monday);
        CheckBox cb_vostok_monday = inflate.findViewById(R.id.cb_vostok_monday);

        CheckBox cb_uhm_tuesday = inflate.findViewById(R.id.cb_uhm_tuesday);
        CheckBox cb_kpd_tuesday = inflate.findViewById(R.id.cb_kpd_tuesday);
        CheckBox cb_center_tuesday = inflate.findViewById(R.id.cb_center_tuesday);
        CheckBox cb_vostok_tuesday = inflate.findViewById(R.id.cb_vostok_tuesday);

        CheckBox cb_uhm_wednesday = inflate.findViewById(R.id.cb_uhm_wednesday);
        CheckBox cb_kpd_wednesday = inflate.findViewById(R.id.cb_kpd_wednesday);
        CheckBox cb_center_wednesday = inflate.findViewById(R.id.cb_center_wednesday);
        CheckBox cb_vostok_wednesday = inflate.findViewById(R.id.cb_vostok_wednesday);

        CheckBox cb_uhm_thursday = inflate.findViewById(R.id.cb_uhm_thursday);
        CheckBox cb_kpd_thursday = inflate.findViewById(R.id.cb_kpd_thursday);
        CheckBox cb_center_thursday = inflate.findViewById(R.id.cb_center_thursday);
        CheckBox cb_vostok_thursday = inflate.findViewById(R.id.cb_vostok_thursday);

        CheckBox cb_uhm_friday = inflate.findViewById(R.id.cb_uhm_friday);
        CheckBox cb_kpd_friday = inflate.findViewById(R.id.cb_kpd_friday);
        CheckBox cb_center_friday = inflate.findViewById(R.id.cb_center_friday);
        CheckBox cb_vostok_friday = inflate.findViewById(R.id.cb_vostok_friday);

        CheckBox cb_uhm_saturday = inflate.findViewById(R.id.cb_uhm_saturday);
        CheckBox cb_kpd_saturday = inflate.findViewById(R.id.cb_kpd_saturday);
        CheckBox cb_center_saturday = inflate.findViewById(R.id.cb_center_saturday);
        CheckBox cb_vostok_saturday = inflate.findViewById(R.id.cb_vostok_saturday);

        CheckBox cb_uhm_sunday = inflate.findViewById(R.id.cb_uhm_sunday);
        CheckBox cb_kpd_sunday = inflate.findViewById(R.id.cb_kpd_sunday);
        CheckBox cb_center_sunday = inflate.findViewById(R.id.cb_center_sunday);
        CheckBox cb_vostok_sunday = inflate.findViewById(R.id.cb_vostok_sunday);

        EditText etn_hunter_time = inflate.findViewById(R.id.etn_hunter_time);
        if (!CurrentUser.getBoolean("hunter_slots")) {
            tv_hunter_status.setText("OFF");
            tv_hunter_status.setTextColor(Color.RED);
        } else {
            tv_hunter_status.setText("ON");
            tv_hunter_status.setTextColor(Color.GREEN);
        }

        cb_uhm_monday.setChecked(CurrentUser.getBoolean("cb_uhm_monday"));
        cb_kpd_monday.setChecked(CurrentUser.getBoolean("cb_kpd_monday"));
        cb_center_monday.setChecked(CurrentUser.getBoolean("cb_center_monday"));
        cb_vostok_monday.setChecked(CurrentUser.getBoolean("cb_vostok_monday"));

        cb_uhm_tuesday.setChecked(CurrentUser.getBoolean("cb_uhm_tuesday"));
        cb_kpd_tuesday.setChecked(CurrentUser.getBoolean("cb_kpd_tuesday"));
        cb_center_tuesday.setChecked(CurrentUser.getBoolean("cb_center_tuesday"));
        cb_vostok_tuesday.setChecked(CurrentUser.getBoolean("cb_vostok_tuesday"));

        cb_uhm_wednesday.setChecked(CurrentUser.getBoolean("cb_uhm_wednesday"));
        cb_kpd_wednesday.setChecked(CurrentUser.getBoolean("cb_kpd_wednesday"));
        cb_center_wednesday.setChecked(CurrentUser.getBoolean("cb_center_wednesday"));
        cb_vostok_wednesday.setChecked(CurrentUser.getBoolean("cb_vostok_wednesday"));

        cb_uhm_thursday.setChecked(CurrentUser.getBoolean("cb_uhm_thursday"));
        cb_kpd_thursday.setChecked(CurrentUser.getBoolean("cb_kpd_thursday"));
        cb_center_thursday.setChecked(CurrentUser.getBoolean("cb_center_thursday"));
        cb_vostok_thursday.setChecked(CurrentUser.getBoolean("cb_vostok_thursday"));

        cb_uhm_friday.setChecked(CurrentUser.getBoolean("cb_uhm_friday"));
        cb_kpd_friday.setChecked(CurrentUser.getBoolean("cb_kpd_friday"));
        cb_center_friday.setChecked(CurrentUser.getBoolean("cb_center_friday"));
        cb_vostok_friday.setChecked(CurrentUser.getBoolean("cb_vostok_friday"));

        cb_uhm_saturday.setChecked(CurrentUser.getBoolean("cb_uhm_saturday"));
        cb_kpd_saturday.setChecked(CurrentUser.getBoolean("cb_kpd_saturday"));
        cb_center_saturday.setChecked(CurrentUser.getBoolean("cb_center_saturday"));
        cb_vostok_saturday.setChecked(CurrentUser.getBoolean("cb_vostok_saturday"));

        cb_uhm_sunday.setChecked(CurrentUser.getBoolean("cb_uhm_sunday"));
        cb_kpd_sunday.setChecked(CurrentUser.getBoolean("cb_kpd_sunday"));
        cb_center_sunday.setChecked(CurrentUser.getBoolean("cb_center_sunday"));
        cb_vostok_sunday.setChecked(CurrentUser.getBoolean("cb_vostok_sunday"));
        etn_hunter_time.setText(String.valueOf(CurrentUser.getInt("etn_hunter_time")));


        bt_hunter_save.setOnClickListener(view -> new Thread(() -> {
            CurrentUser.saveBoolean("cb_uhm_monday", cb_uhm_monday.isChecked());
            CurrentUser.saveBoolean("cb_kpd_monday", cb_kpd_monday.isChecked());
            CurrentUser.saveBoolean("cb_center_monday", cb_center_monday.isChecked());
            CurrentUser.saveBoolean("cb_vostok_monday", cb_vostok_monday.isChecked());

            CurrentUser.saveBoolean("cb_uhm_tuesday", cb_uhm_tuesday.isChecked());
            CurrentUser.saveBoolean("cb_kpd_tuesday", cb_kpd_tuesday.isChecked());
            CurrentUser.saveBoolean("cb_center_tuesday", cb_center_tuesday.isChecked());
            CurrentUser.saveBoolean("cb_vostok_tuesday", cb_vostok_tuesday.isChecked());

            CurrentUser.saveBoolean("cb_uhm_wednesday", cb_uhm_wednesday.isChecked());
            CurrentUser.saveBoolean("cb_kpd_wednesday", cb_kpd_wednesday.isChecked());
            CurrentUser.saveBoolean("cb_center_wednesday", cb_center_wednesday.isChecked());
            CurrentUser.saveBoolean("cb_vostok_wednesday", cb_vostok_wednesday.isChecked());

            CurrentUser.saveBoolean("cb_uhm_thursday", cb_uhm_thursday.isChecked());
            CurrentUser.saveBoolean("cb_kpd_thursday", cb_kpd_thursday.isChecked());
            CurrentUser.saveBoolean("cb_center_thursday", cb_center_thursday.isChecked());
            CurrentUser.saveBoolean("cb_vostok_thursday", cb_vostok_thursday.isChecked());

            CurrentUser.saveBoolean("cb_uhm_friday", cb_uhm_friday.isChecked());
            CurrentUser.saveBoolean("cb_kpd_friday", cb_kpd_friday.isChecked());
            CurrentUser.saveBoolean("cb_center_friday", cb_center_friday.isChecked());
            CurrentUser.saveBoolean("cb_vostok_friday", cb_vostok_friday.isChecked());

            CurrentUser.saveBoolean("cb_uhm_saturday", cb_uhm_saturday.isChecked());
            CurrentUser.saveBoolean("cb_kpd_saturday", cb_kpd_saturday.isChecked());
            CurrentUser.saveBoolean("cb_center_saturday", cb_center_saturday.isChecked());
            CurrentUser.saveBoolean("cb_vostok_saturday", cb_vostok_saturday.isChecked());

            CurrentUser.saveBoolean("cb_uhm_sunday", cb_uhm_sunday.isChecked());
            CurrentUser.saveBoolean("cb_kpd_sunday", cb_kpd_sunday.isChecked());
            CurrentUser.saveBoolean("cb_center_sunday", cb_center_sunday.isChecked());
            CurrentUser.saveBoolean("cb_vostok_sunday", cb_vostok_sunday.isChecked());
            if (!etn_hunter_time.getText().toString().equals("")) {
                CurrentUser.saveInt("etn_hunter_time", Integer.parseInt(etn_hunter_time.getText().toString()));
                //  getActivity().
            }

        }).start());

        return inflate;
    }
}
