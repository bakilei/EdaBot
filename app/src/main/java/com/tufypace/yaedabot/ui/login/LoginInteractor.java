package com.tufypace.yaedabot.ui.login;

import com.tufypace.yaedabot.data.LoginRepository;

public class LoginInteractor {
    public final LoginRepository loginRepository;

    public LoginInteractor(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
}
