package com.nazarii_moshenskyi.countryinfo.ui.base;

import com.nazarii_moshenskyi.countryinfo.ui.InternetManager;

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
            // TODO: 2/23/18 Isn't reached after closing DetailsActivity.
            view.unregisterReceiver(manager);
            view = null;
        }
    }

}
