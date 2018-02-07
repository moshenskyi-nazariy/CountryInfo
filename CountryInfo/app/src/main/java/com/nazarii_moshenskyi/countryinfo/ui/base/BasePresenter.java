package com.nazarii_moshenskyi.countryinfo.ui.base;

import com.nazarii_moshenskyi.countryinfo.ui.InternetManager;

public abstract class BasePresenter<T extends BaseMvpView> implements BaseMvpPresenter<T> {
    private T view;
    private static final String TAG = "BasePresenter";
    private InternetManager manager;

    public BasePresenter(InternetManager manager) {
        this.manager = manager;
    }

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) {
            view = null;
        }
    }

    protected T getView() {
        return view;
    }

}
