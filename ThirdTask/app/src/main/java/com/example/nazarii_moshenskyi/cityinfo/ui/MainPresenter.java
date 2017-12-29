package com.example.nazarii_moshenskyi.cityinfo.ui;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

public interface MainPresenter {
    void attachView(MainView view);

    void detachView();

    void start();

    void onItemClicked(Country country);
}
