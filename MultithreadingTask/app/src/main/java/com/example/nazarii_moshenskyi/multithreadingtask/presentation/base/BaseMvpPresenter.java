package com.example.nazarii_moshenskyi.multithreadingtask.presentation.base;

public interface BaseMvpPresenter<T extends BaseMvpView> {

    void attachView(T view);

    void detachView();

}
