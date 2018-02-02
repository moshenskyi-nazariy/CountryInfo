package com.example.nazarii_moshenskyi.cityinfo.ui.main.view;


import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.BaseMvpActivityView;

public interface MainMvpView extends BaseMvpActivityView {

    boolean isTablet();

    void setDetailFragment();

    void replaceDetailFragment(Country country);

    void startDetailActivity(Country country);

    boolean isLandscape();

}
