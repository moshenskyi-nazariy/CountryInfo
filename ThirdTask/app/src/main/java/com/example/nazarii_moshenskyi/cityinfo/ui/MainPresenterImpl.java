package com.example.nazarii_moshenskyi.cityinfo.ui;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private boolean isTwoPane;

    // Configuration.SIZE_LARGE
    private static final int TABLET_SIZE = 3;

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
        if (view.getSize() >= TABLET_SIZE) {
            isTwoPane = true;
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
