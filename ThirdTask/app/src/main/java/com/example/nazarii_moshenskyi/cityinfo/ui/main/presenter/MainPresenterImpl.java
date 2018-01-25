package com.example.nazarii_moshenskyi.cityinfo.ui.main.presenter;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.BasePresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.main.view.MainMvpView;

import javax.inject.Inject;

public class MainPresenterImpl extends BasePresenter<MainMvpView> implements MainMvpPresenter {
    private final InternetManager internetManager;
    private boolean isTwoPane;

    @Inject
    public MainPresenterImpl(InternetManager internetManager) {
        this.internetManager = internetManager;
    }

    public void defineLayout() {
        MainMvpView view = getView();
        isTwoPane = view.isLandscape() && view.isTablet();
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
