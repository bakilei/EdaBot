package com.tufypace.yaedabot.ui.ui.activities.mvp;


public interface MvpView {
    void dismissError();

    void hideLoader();

    void showError(int i);

    void showError(String str);

    void showLoader();
}
