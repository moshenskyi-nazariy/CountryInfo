package com.example.nazarii_moshenskyi.cityinfo.ui;


import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

public interface MainMvpView extends BaseMvpView {

    boolean isTablet();

    void setDetailFragment();

    void replaceDetailFragment(Country country);

    void startDetailActivity(Country country);

    boolean isLandscape();

}
