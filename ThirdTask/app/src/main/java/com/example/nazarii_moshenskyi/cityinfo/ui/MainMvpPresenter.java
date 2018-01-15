package com.example.nazarii_moshenskyi.cityinfo.ui;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

public interface MainMvpPresenter extends BaseMvpPresenter<MainMvpView> {

    void onItemClicked(Country country);

    void defineLayout();

}
