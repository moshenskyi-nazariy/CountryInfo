package com.example.nazarii_moshenskyi.cityinfo.interactor.repository;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;

import java.util.List;

import io.reactivex.Observable;

public class DataManager {
    private WebService webService;

    public DataManager(WebService webService) {
        this.webService = webService;
    }

    public Observable<CountryInfo> getInfo(String countryName) {
        return webService.getInfo(countryName);
    }

    public Observable<List<Country>> getCountries() {
        return webService.getCountries();
    }
}
