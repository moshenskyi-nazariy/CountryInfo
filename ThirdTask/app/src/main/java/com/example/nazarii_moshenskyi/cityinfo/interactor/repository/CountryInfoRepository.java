package com.example.nazarii_moshenskyi.cityinfo.interactor.repository;

import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;

import io.reactivex.Observable;

public class CountryInfoRepository {
    private CountryService service;

    public CountryInfoRepository(CountryService service) {
        this.service = service;
    }

    public Observable<CountryInfo> getInfo(String countryName) {
        return service.getInfo(countryName);
    }
}
