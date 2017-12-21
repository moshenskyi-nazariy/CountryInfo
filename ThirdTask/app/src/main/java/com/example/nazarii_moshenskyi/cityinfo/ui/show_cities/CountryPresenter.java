package com.example.nazarii_moshenskyi.cityinfo.ui.show_cities;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.ApiFactory;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CountryPresenter {
    private CountryView view;
    private CountryRepository repository;
    private CountryService service;

    public CountryPresenter(CountryView view) {
        this.view = view;
        service = ApiFactory.getCountryService();
        repository = new CountryRepository(service);
    }

    public void getCountries() {
        repository.getCountries().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Country>>() {
                    @Override
                    public void accept(List<Country> countries) throws Exception {
                        view.onLoad(countries);
                    }
                });


    }
}
