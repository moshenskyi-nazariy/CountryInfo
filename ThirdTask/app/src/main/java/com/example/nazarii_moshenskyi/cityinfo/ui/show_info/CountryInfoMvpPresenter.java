package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import com.example.nazarii_moshenskyi.cityinfo.ui.BaseMvpPresenter;

public interface CountryInfoMvpPresenter extends BaseMvpPresenter<CountryInfoMvpView> {

    void getInfo(String countryName);

}
