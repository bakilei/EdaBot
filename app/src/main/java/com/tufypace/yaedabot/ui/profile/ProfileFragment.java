package com.tufypace.yaedabot.ui.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.model.responses.CourierInfoResponse;
import com.tufypace.yaedabot.ui.BaseFragment;
import com.tufypace.yaedabot.utils.CourierInfoHelper;
import com.tufypace.yaedabot.utils.OrderUtils;
import com.tufypace.yaedabot.utils.Save;
import com.tufypace.yaedabot.utils.SharedPreferencesDefaultProvider;
import com.tufypace.yaedabot.utils.SharedPreferencesProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends BaseFragment {
    public final SharedPreferencesProvider mSharedPreferencesProvider = new SharedPreferencesDefaultProvider(this.getContext());
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters


    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCourierInfo();
    }

    public void getCourierInfo() {
        OrderUtils orderUtils = new OrderUtils();
        orderUtils.getCourierInfo(new Callback<CourierInfoResponse>() {
            @Override
            public void onResponse(Call<CourierInfoResponse> call, Response<CourierInfoResponse> response) {
                Log.d("onResponse", response.toString());
                if (response.body() != null) {
                    CourierInfoResponse courierInfoResponse = response.body();
                    Save.courier = courierInfoResponse.payload;
                    //        initMetricaProfile(Save.courier);
                    Log.d("onResponse balance ", String.valueOf(Save.courier.encashmentAmount));
                }

            }

            @Override
            public void onFailure(Call<CourierInfoResponse> call, Throwable t) {
                Log.d("onResponse", t.toString());
            }
        }, String.valueOf(Save.sleep_latitude), String.valueOf(Save.sleep_longitude));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_profile, container, false);

        final TextView status = inflate.findViewById(R.id.tv_status_profile);
        final TextView fio = inflate.findViewById(R.id.tv_fio_profile);
        final TextView type = inflate.findViewById(R.id.tv_type_profile);
        final TextView billingType = inflate.findViewById(R.id.tv_profile_typebilling);
        final TextView region_name = inflate.findViewById(R.id.tv_profile_region_name);
        final TextView profile_balance = inflate.findViewById(R.id.tv_profile_balance);
        //     final TextView cardlinked = inflate.findViewById(R.id.tv_card_linked_profile);
        if (Save.courier != null) {

            status.setText(CourierInfoHelper.courierStatus(Save.courier.getStatus()));
            status.setTextColor(CourierInfoHelper.colorCourierStatus(Save.courier.getStatus()));
            status.setGravity(Gravity.CENTER);
            fio.setText(Save.courier.getCourierFullname().surname + " " + Save.courier.courierFullname.firstName + " " + Save.courier.courierFullname.patronymic);
            type.setText(CourierInfoHelper.courierType(Save.courier.type));
            if (!Save.courier.cardLinked) {
                //           cardlinked.setText("Карта не привязана!");
            } else {
                //              cardlinked.setText("Карта привязана!");
            }
            billingType.setText(CourierInfoHelper.courierBillingType(Save.courier.getBillingType()));
            region_name.setText(Save.courier.getRegion().name);
            profile_balance.setText(String.valueOf(Save.courier.getBalance()));
        }


        return inflate;
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}