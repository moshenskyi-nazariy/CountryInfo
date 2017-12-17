package com.example.nazarii_moshenskyi.cityinfo.ui.show_cities;

import com.example.nazarii_moshenskyi.cityinfo.ui.BaseView;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryRepository;

import java.util.List;

import io.reactivex.Observable;

public class CountryPresenter {
    private BaseView view;
    private CountryRepository repository;

    public CountryPresenter(BaseView view, CountryRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void getCountries() {
        Observable<List<Country>> countries = repository.getCountries();
        view.onLoad(countries);
    }
}
