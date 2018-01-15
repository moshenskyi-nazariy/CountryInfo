package com.example.nazarii_moshenskyi.cityinfo.ui;

public abstract class BasePresenter<T extends BaseView> implements BaseMvpPresenter<T> {
    private T view;

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
