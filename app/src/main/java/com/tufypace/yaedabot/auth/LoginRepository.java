package com.tufypace.yaedabot.auth;

import com.tufypace.yaedabot.model.responses.LoginResponse;

import io.reactivex.Observable;

public interface LoginRepository {
    Observable<LoginResponse> auth(String str, String str2);
}
