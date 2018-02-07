package com.nazarii_moshenskyi.countryinfo.ui.show_country.view;

import com.nazarii_moshenskyi.countryinfo.data.model.Country;
import com.nazarii_moshenskyi.countryinfo.ui.base.BaseRxMvpView;

import java.util.List;

public interface CountryMvpView extends BaseRxMvpView {

    void onLoad(List<Country> items);

    void onTextChanged(String text);

    List<Country> getItems();

}
