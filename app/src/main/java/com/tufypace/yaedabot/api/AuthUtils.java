package com.tufypace.yaedabot.api;

import com.tufypace.yaedabot.auth.LoginRepository;
import com.tufypace.yaedabot.model.responses.LoginResponse;
import com.tufypace.yaedabot.utils.SchedulerProvider;

import io.reactivex.Observable;

public class AuthUtils implements LoginRepository {
    private final ApiEndpoints authService;
    private final SchedulerProvider schedulerProvider;

    public AuthUtils(ApiEndpoints authService, SchedulerProvider schedulerProvider) {
        this.authService = authService;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public Observable<LoginResponse> auth(String str, String str2) {
        return null;
    }

    //  public Observable<LoginResponse> auth(String str, String str2) {
    //    f.b(str, "login");
    //   f.b(str2, "password");
//        return this.authService.authenticate(new Credentials(str, str2)).observeOn(this.schedulerProvider.ui()).subscribeOn(this.schedulerProvider.io());
    //.subscribeOn(this.schedulerProvider.io()).observeOn(this.schedulerProvider.ui());
    // }
}
