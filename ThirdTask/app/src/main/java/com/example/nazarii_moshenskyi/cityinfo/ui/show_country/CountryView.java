package com.example.nazarii_moshenskyi.cityinfo.ui.show_country;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

import java.util.List;

public interface CountryView {

    void onLoad(List<Country> items);

    void onClick(Country country);

    void  onTextChanged(String text);

    List<Country> getItems();
}
