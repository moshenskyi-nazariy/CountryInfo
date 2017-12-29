package com.example.nazarii_moshenskyi.cityinfo.ui;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private boolean isTwoPane;

    @Override
    public void attachView(MainView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) {
            view = null;
        }
    }

    @Override
    public void start() {
        isTwoPane =  view.isLandscape() && view.isTablet();
        if (isTwoPane) {
            view.setDetailFragment();
        }
    }

    @Override
    public void onItemClicked(Country country) {
        if (isTwoPane) {
            view.replaceDetailFragment(country);
        } else {
            view.startDetailActivity(country);
        }
    }

}
