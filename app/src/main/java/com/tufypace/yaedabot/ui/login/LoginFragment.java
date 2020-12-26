package com.tufypace.yaedabot.ui.login;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;
import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.api.ApiClient;
import com.tufypace.yaedabot.api.ApiEndpoints;
import com.tufypace.yaedabot.model.Credentials;
import com.tufypace.yaedabot.model.responses.CourierInfoResponse;
import com.tufypace.yaedabot.model.responses.LoginResponse;
import com.tufypace.yaedabot.ui.BaseFragment;
import com.tufypace.yaedabot.ui.ToolbarState;
import com.tufypace.yaedabot.ui.dialog.DialogError;
import com.tufypace.yaedabot.utils.OrderUtils;
import com.tufypace.yaedabot.utils.Save;
import com.tufypace.yaedabot.utils.SharedPreferencesDefaultProvider;
import com.tufypace.yaedabot.utils.SharedPreferencesProvider;
import com.tufypace.yaedabot.utils.SharedPreferencesUtils;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends BaseFragment {
    public SharedPreferencesProvider mSharedPreferencesProvider;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferencesProvider = new SharedPreferencesDefaultProvider(this.getContext());
    }

    ApiEndpoints client = ApiClient.getClientEda();
    private LoginViewModel loginViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_login, container, false);
        // Inflate the layout for this fragment
        //    return inflater.inflate(R.layout.fragment_login, container, false);

        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final TextInputEditText usernameEditText = inflate.findViewById(R.id.username);
        final TextInputEditText passwordEditText = inflate.findViewById(R.id.password);
        final EditText apidEditText = inflate.findViewById(R.id.eTapi);
        final Button loginButton = inflate.findViewById(R.id.login);
        final Button loginButtonApi = inflate.findViewById(R.id.sign_api);
        final CheckBox remember = inflate.findViewById(R.id.remember);
        final ProgressBar loadingProgressBar = inflate.findViewById(R.id.loading);
        setToolbarState(ToolbarState.HIDE_NAV_MENU);
        usernameEditText.setText(SharedPreferencesUtils.getString(getContext(), "username"));
        passwordEditText.setText(SharedPreferencesUtils.getString(getContext(), "pass"));
        loginButton.setOnClickListener(v -> {
            //   AuthUtils loginInteractor = this.interactor;
            //    loadingProgressBar.setVisibility(View.VISIBLE);
            //      loginViewModel.login(usernameEditText.getText().toString(),
            //              passwordEditText.getText().toString());

            String username = Objects.requireNonNull(usernameEditText.getText()).toString().trim();
            String pass = Objects.requireNonNull(passwordEditText.getText()).toString().trim();
            if (remember.isChecked()) {
                SharedPreferencesUtils.save(getContext(), "username", username);
                SharedPreferencesUtils.save(getContext(), "pass", pass);

            }
            client.authenticate(new Credentials(pass, username)).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NotNull Call<LoginResponse> call, @NotNull Response<LoginResponse> response) {
                    if (response.code() == 403) {
                        new DialogError(getContext(), "Пользователь не найден!").show();

                        //  dialog.
                    }
                    Log.d("Login", "on response " + response.toString() + response.code() + response.errorBody());
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null) {
                        if (loginResponse.getPayload().getApiKey() != null) {
                            Log.d("Login", "on response " + response.toString() + response.code() + response.errorBody());
                            //    sharedPreferencesDefaultProvider.save("api_key", loginResponse.getPayload().getApiKey());
                            Save.api = loginResponse.getPayload().getApiKey();
                            mSharedPreferencesProvider.save("api_key", Objects.requireNonNull(loginResponse.getPayload().getApiKey().trim()));

                            getCourierInfo();
                            showFragment("OrderFragment");

                        }
                        //        Log.d("Login", loginResponse.getPayload().getApiKey());
                    }
//                    System.out.println(response.body().toString());

                }

                @Override
                public void onFailure(@NotNull Call<LoginResponse> call, @NotNull Throwable t) {

                    System.out.println(t);
                }
            });
        });
        apidEditText.setText(mSharedPreferencesProvider.getString("api_key"));
        loginButtonApi.setOnClickListener(v -> {
            if (remember.isChecked()) {

                //       SharedPreferencesUtils.save(getContext(),"api",Objects.requireNonNull(apidEditText.getText()).toString().trim());
                mSharedPreferencesProvider.save("api_key", Objects.requireNonNull(apidEditText.getText().toString().trim()));
            }

            Save.api = Objects.requireNonNull(apidEditText.getText()).toString().trim();
            showFragment("OrderFragment");
        });
        return inflate;
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
                    //       initMetricaProfile(courierInfoResponse.payload);
                    Log.d("onResponse balance ", String.valueOf(Save.courier.encashmentAmount));
                }

            }

            @Override
            public void onFailure(Call<CourierInfoResponse> call, Throwable t) {
                Log.d("onResponse", t.toString());
            }
        }, String.valueOf(Save.sleep_latitude), String.valueOf(Save.sleep_longitude));
    }

}