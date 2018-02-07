package com.nazarii_moshenskyi.countryinfo.ui.show_country.presenter;

import com.nazarii_moshenskyi.countryinfo.ui.base.BaseMvpPresenter;
import com.nazarii_moshenskyi.countryinfo.ui.show_country.view.CountryMvpView;
import com.nazarii_moshenskyi.countryinfo.ui.show_country.view.recycler.CountryAdapter;

public interface CountryMvpPresenter extends BaseMvpPresenter<CountryMvpView> {

    void getCountries();

    void updateItems(String input, CountryAdapter adapter);

}
