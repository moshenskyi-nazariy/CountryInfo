package com.example.nazarii_moshenskyi.cityinfo.ui;

public interface BaseMvpPresenter<T> {
    void attachView(T view);

    void detachView();
}
