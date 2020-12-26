package com.tufypace.yaedabot.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.lifecycle.ViewModelProviders;

import com.tufypace.yaedabot.R;
import com.tufypace.yaedabot.api.ApiClient;
import com.tufypace.yaedabot.api.ApiEndpoints;
import com.tufypace.yaedabot.model.Credentials;
import com.tufypace.yaedabot.model.responses.ConfigResponse;
import com.tufypace.yaedabot.model.responses.LoginResponse;
import com.tufypace.yaedabot.ui.BaseActivity;
import com.tufypace.yaedabot.utils.SharedPreferencesUtils;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    //  private final SchedulerProvider schedulerProvider;
    private LoginViewModel loginViewModel;
    ApiEndpoints client = ApiClient.getClientEda();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final Button loginApi = findViewById(R.id.sign_api);
        final EditText apiET = findViewById(R.id.eTapi);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginViewModel.getLoginFormState().observe(this, loginFormState -> {
            if (loginFormState == null) {
                return;
            }
            loginButton.setEnabled(loginFormState.isDataValid());
            if (loginFormState.getUsernameError() != null) {
                usernameEditText.setError(getString(loginFormState.getUsernameError()));
            }
            if (loginFormState.getPasswordError() != null) {
                passwordEditText.setError(getString(loginFormState.getPasswordError()));
            }
        });

        loginViewModel.getLoginResult().observe(this, loginResult -> {
            if (loginResult == null) {
                return;
            }
            loadingProgressBar.setVisibility(View.GONE);
            if (loginResult.getError() != null) {
                showLoginFailed(loginResult.getError());
            }
            if (loginResult.getSuccess() != null) {
                updateUiWithUser(loginResult.getSuccess());
            }
            setResult(Activity.RESULT_OK);

            //Complete and destroy login activity once successful
            finish();
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(v -> {
            //   AuthUtils loginInteractor = this.interactor;
            //    loadingProgressBar.setVisibility(View.VISIBLE);
            //      loginViewModel.login(usernameEditText.getText().toString(),
            //              passwordEditText.getText().toString());
            client.authenticate(new Credentials("S2r7m3RvmK", "Олег Куракин")).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NotNull Call<LoginResponse> call, @NotNull Response<LoginResponse> response) {
                    Log.d("Login", "on response " + response.toString() + response.code() + response.errorBody());
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null) {
                        if (loginResponse.getPayload().getApiKey() != null) {
                            Log.d("Login", "on response " + response.toString() + response.code() + response.errorBody());
                            SharedPreferencesUtils.save(getApplicationContext(), "api_key", loginResponse.getPayload().getApiKey());
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
        loginApi.setOnClickListener(v -> {
            client.getConfig(apiET.getText().toString().trim()).enqueue(new Callback<ConfigResponse>() {
                @Override
                public void onResponse(Call<ConfigResponse> call, Response<ConfigResponse> response) {
                    Log.d("Login", "on response " + response.toString() + response.code() + response.errorBody());
                }

                @Override
                public void onFailure(Call<ConfigResponse> call, Throwable t) {
                    Log.d("Login", "on response " + t.getMessage());

                }
            });
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}