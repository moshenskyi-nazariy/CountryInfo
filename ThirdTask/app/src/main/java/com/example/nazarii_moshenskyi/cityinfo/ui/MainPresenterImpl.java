package com.example.nazarii_moshenskyi.cityinfo.ui;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

public class MainPresenterImpl extends BasePresenter<MainMvpView> implements MainMvpPresenter {
    private boolean isTwoPane;

    public void defineLayout() {
        MainMvpView view = getView();
        isTwoPane =  view.isLandscape() && view.isTablet();
        if (isTwoPane) {
            view.setDetailFragment();
        }
    }

    @Override
    public void onItemClicked(Country country) {
        if (isTwoPane) {
            getView().replaceDetailFragment(country);
        } else {
            getView().startDetailActivity(country);
        }
    }

}
