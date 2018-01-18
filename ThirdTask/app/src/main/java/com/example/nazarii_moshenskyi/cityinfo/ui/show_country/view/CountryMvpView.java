package com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.BaseMvpView;

import java.util.List;

public interface CountryMvpView extends BaseMvpView {

    void onLoad(List<Country> items);

    void onTextChanged(String text);

    List<Country> getItems();
}
