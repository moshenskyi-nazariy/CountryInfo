package com.example.nazarii_moshenskyi.cityinfo.ui.base;

public interface BaseMvpPresenter<T extends BaseMvpView> {
    void attachView(T view);

    void detachView();
}
