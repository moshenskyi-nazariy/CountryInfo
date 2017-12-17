package com.example.nazarii_moshenskyi.cityinfo.interactor.repository;

import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CountryInfoRepository {
    private final String countryName;
    private CountryService service;

    public CountryInfoRepository(CountryService service, String countryName) {
        this.service = service;
        this.countryName = countryName;
    }

    public Observable<CountryInfo> getInfo() {
        return service.getInfo(countryName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
