package com.example.nazarii_moshenskyi.cityinfo.ui.show_country.presenter;

import com.example.nazarii_moshenskyi.cityinfo.ui.base.BaseMvpPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view.CountryMvpView;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view.recycler.CountryAdapter;

public interface CountryMvpPresenter extends BaseMvpPresenter<CountryMvpView> {

    void getCountries();

    void updateItems(String input, CountryAdapter adapter);

}
