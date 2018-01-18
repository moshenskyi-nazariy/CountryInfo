package com.example.nazarii_moshenskyi.cityinfo.ui.base;

public abstract class BasePresenter<T extends BaseMvpView> implements BaseMvpPresenter<T> {
    private T view;
    private static final String TAG = "BasePresenter";

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
