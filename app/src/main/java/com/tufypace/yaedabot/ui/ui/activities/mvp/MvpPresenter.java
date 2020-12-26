package com.tufypace.yaedabot.ui.ui.activities.mvp;

public interface MvpPresenter<V extends MvpView> {
    void bind(V v);

    void init();

    void unbind();
}