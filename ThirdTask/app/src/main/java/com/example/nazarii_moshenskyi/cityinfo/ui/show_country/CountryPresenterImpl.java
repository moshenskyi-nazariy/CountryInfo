package com.example.nazarii_moshenskyi.cityinfo.ui.show_country;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CountryPresenterImpl implements CountryPresenter {
    private final CountryRepository repository;
    private CountryView view;

    public CountryPresenterImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void attachView(CountryView view){
        this.view = view;
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

    @Override
    public void detachView() {
        if (view != null) {
            view = null;
        }
    }
}
