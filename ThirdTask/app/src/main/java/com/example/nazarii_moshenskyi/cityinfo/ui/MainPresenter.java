package com.example.nazarii_moshenskyi.cityinfo.ui;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

public interface MainPresenter extends BasePresenter<MainView> {

    void onItemClicked(Country country);

}
