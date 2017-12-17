package com.example.nazarii_moshenskyi.cityinfo.interactor.repository;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CountryRepository {
    private CountryService service;

    public CountryRepository(CountryService service) {
        this.service = service;
    }

    public Observable<List<Country>> getCountries() {
        return service.getCountries().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
