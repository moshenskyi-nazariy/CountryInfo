package com.nazarii_moshenskyi.countryinfo.ui.base;

public interface BaseMvpPresenter<T extends BaseMvpView> {
    void attachView(T view);

    void detachView();
}
