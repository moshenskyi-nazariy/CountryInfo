package com.example.nazarii_moshenskyi.cityinfo.ui.show_country;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryRepository;
import com.example.nazarii_moshenskyi.cityinfo.ui.BaseView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CountryPresenter {
    private BaseView<List<Country>> view;
    private CountryRepository repository;

    public CountryPresenter(BaseView<List<Country>> view, CountryRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void getCountries() {
        Observable<List<Country>> countries = repository.getCountries().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        countries.subscribe(new Consumer<List<Country>>() {
            @Override
            public void accept(List<Country> countries) throws Exception {
                view.onLoad(countries);
            }
        });
    }
}
