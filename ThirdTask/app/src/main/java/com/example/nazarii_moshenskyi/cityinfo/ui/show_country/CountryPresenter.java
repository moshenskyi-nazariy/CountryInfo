package com.example.nazarii_moshenskyi.cityinfo.ui.show_country;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.BasePresenter;

public interface CountryPresenter extends BasePresenter<CountryView> {

    void updateItems(String input, CountryAdapter adapter);
}
