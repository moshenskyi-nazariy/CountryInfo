package com.nazarii_moshenskyi.countryinfo.ui.show_info.presenter;

import com.nazarii_moshenskyi.countryinfo.ui.base.BaseMvpPresenter;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.view.CountryInfoMvpView;

public interface CountryInfoMvpPresenter extends BaseMvpPresenter<CountryInfoMvpView> {

    void getInfo(String countryName);

}
