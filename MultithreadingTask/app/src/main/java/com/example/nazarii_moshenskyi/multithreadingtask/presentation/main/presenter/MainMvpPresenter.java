package com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.presenter;

import com.example.nazarii_moshenskyi.multithreadingtask.presentation.base.BaseMvpPresenter;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.view.MainMvpView;

public interface MainMvpPresenter extends BaseMvpPresenter<MainMvpView> {

    void runHandlerThread(String[] data);

    void runAsyncTask(String[] data);

}
