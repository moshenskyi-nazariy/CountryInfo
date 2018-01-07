package com.example.nazarii_moshenskyi.cityinfo.ui;

public interface BasePresenter<T> {
    void attachView(T view);

    void detachView();

    void start();
}
