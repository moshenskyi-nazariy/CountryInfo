package com.example.nazarii_moshenskyi.cityinfo.ui.main.view;


import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.BaseMvpView;

public interface MainMvpView extends BaseMvpView {

    boolean isTablet();

    void setDetailFragment();

    void replaceDetailFragment(Country country);

    void startDetailActivity(Country country);

    boolean isLandscape();

}
