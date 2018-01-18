package com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.presenter;

import com.example.nazarii_moshenskyi.multithreadingtask.presentation.base.BaseMvpPresenter;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.MainMvpView;

public interface MainMvpPresenter extends BaseMvpPresenter<MainMvpView> {

    void runAsyncTask();

    void runLoader();

    void runHandlerThread();

}
