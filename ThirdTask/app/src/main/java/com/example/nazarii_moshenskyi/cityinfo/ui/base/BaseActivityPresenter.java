package com.example.nazarii_moshenskyi.cityinfo.ui.base;

import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;

public abstract class BaseActivityPresenter <T extends BaseMvpActivityView> extends BasePresenter<T> implements BaseMvpPresenter<T> {
    private T view;
    private InternetManager manager;

    public BaseActivityPresenter(InternetManager manager) {
        super(manager);
        this.manager = manager;
    }

    @Override
    public void attachView(T view) {
        super.attachView(view);
        view.registerReceiver(manager);
    }

    @Override
    public void detachView() {
        if (view != null) {
            view.unregisterReceiver(manager);
            view = null;
        }
    }

}
