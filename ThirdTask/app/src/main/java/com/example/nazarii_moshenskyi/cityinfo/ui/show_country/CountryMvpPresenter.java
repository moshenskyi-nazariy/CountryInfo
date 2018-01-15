package com.example.nazarii_moshenskyi.cityinfo.ui.show_country;

import com.example.nazarii_moshenskyi.cityinfo.ui.BaseMvpPresenter;

public interface CountryMvpPresenter extends BaseMvpPresenter<CountryMvpView> {

    void getCountries();

    void updateItems(String input, CountryAdapter adapter);

}
