package com.example.nazarii_moshenskyi.cityinfo.ui;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

import java.util.List;

import io.reactivex.Observable;

public interface BaseView {

    void onLoad(Observable<List<Country>> countries);

    void onClick(Country country);

}
