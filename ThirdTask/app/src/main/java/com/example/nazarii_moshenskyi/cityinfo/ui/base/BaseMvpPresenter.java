package com.example.nazarii_moshenskyi.cityinfo.ui.base;

public interface BaseMvpPresenter<T> {
    void attachView(T view);

    void detachView();
}
