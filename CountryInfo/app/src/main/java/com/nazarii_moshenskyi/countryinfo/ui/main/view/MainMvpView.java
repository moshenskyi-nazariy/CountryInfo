package com.nazarii_moshenskyi.countryinfo.ui.main.view;


import com.nazarii_moshenskyi.countryinfo.data.model.Country;
import com.nazarii_moshenskyi.countryinfo.ui.base.BaseMvpActivityView;

public interface MainMvpView extends BaseMvpActivityView {

    boolean isTablet();

    void setDetailFragment();

    void replaceDetailFragment(Country country);

    void startDetailActivity(Country country);

    boolean isLandscape();

}
