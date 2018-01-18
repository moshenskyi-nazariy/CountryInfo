package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.presenter;

import com.example.nazarii_moshenskyi.cityinfo.ui.base.BaseMvpPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.view.CountryInfoMvpView;

public interface CountryInfoMvpPresenter extends BaseMvpPresenter<CountryInfoMvpView> {

    void getInfo(String countryName);

}
