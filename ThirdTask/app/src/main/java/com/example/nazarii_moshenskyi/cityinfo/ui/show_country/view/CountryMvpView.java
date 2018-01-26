package com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.BaseMvpView;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.BaseRxMvpView;

import java.util.List;

public interface CountryMvpView extends BaseRxMvpView {

    void onLoad(List<Country> items);

    void onTextChanged(String text);

    List<Country> getItems();

}
