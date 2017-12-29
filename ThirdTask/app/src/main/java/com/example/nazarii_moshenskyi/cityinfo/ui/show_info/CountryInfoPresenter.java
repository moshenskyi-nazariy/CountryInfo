package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import com.example.nazarii_moshenskyi.cityinfo.ui.BasePresenter;

public interface CountryInfoPresenter extends BasePresenter<CountryInfoView> {

    void getInfo(String countryName);

}
