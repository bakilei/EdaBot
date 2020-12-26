package com.tufypace.yaedabot.ui.nakrutka;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.order.ApiOrderModel;
import com.tufypace.yaedabot.model.order.OrderTransition;
import com.tufypace.yaedabot.ui.BaseFragment;
import com.tufypace.yaedabot.utils.OrderUtils;
import com.tufypace.yaedabot.utils.Save;
import com.tufypace.yaedabot.utils.ZakazHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NakrutkaFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_nakrutka, container, false);
        final Spinner spinnerStatus = inflate.findViewById(R.id.nakrutka_spinner_status);
        final EditText et_order_num = inflate.findViewById(R.id.et_order_num);
        final Button bt_nakrutka_send_status = inflate.findViewById(R.id.bt_nakrutka_send_status);

        bt_nakrutka_send_status.setOnClickListener(v -> {
            OrderUtils orderUtils = new OrderUtils();
            orderUtils.changeZakaState(et_order_num.getText().toString(), new OrderTransition(ZakazHelper.zakazChangeState(spinnerStatus.getSelectedItem().toString())), String.valueOf(Save.sleep_latitude), String.valueOf(Save.sleep_longitude), new Callback<ApiOrderModel>() {
                @Override
                public void onResponse(Call<ApiOrderModel> call, Response<ApiOrderModel> response) {
                    Log.d("zakaz CHANGE STATUS", response.toString());
                }

                @Override
                public void onFailure(Call<ApiOrderModel> call, Throwable t) {
                    Log.d("zakaz CHANGE STATUS", t.toString());
                }
            });

        });
        return inflate;
    }


    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
