package com.nazarii_moshenskyi.countryinfo.ui.main.presenter;

import com.nazarii_moshenskyi.countryinfo.data.model.Country;
import com.nazarii_moshenskyi.countryinfo.ui.InternetManager;
import com.nazarii_moshenskyi.countryinfo.ui.base.BaseActivityPresenter;
import com.nazarii_moshenskyi.countryinfo.ui.main.view.MainMvpView;

import javax.inject.Inject;

public class MainPresenterImpl extends BaseActivityPresenter<MainMvpView> implements MainMvpPresenter {
    private final InternetManager internetManager;
    private boolean isTwoPane;

    @Inject
    public MainPresenterImpl(InternetManager internetManager) {
        super(internetManager);
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
    public void onStop() {
        getView().unregisterReceiver(internetManager);
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
