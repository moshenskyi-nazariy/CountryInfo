package com.nazarii_moshenskyi.countryinfo.interactor.repository;

import com.nazarii_moshenskyi.countryinfo.data.model.Country;
import com.nazarii_moshenskyi.countryinfo.data.model.CountryAnalytics;
import com.nazarii_moshenskyi.countryinfo.data.model.CountryInfo;
import com.nazarii_moshenskyi.countryinfo.interactor.api.CountryAnalyticsService;
import com.nazarii_moshenskyi.countryinfo.interactor.api.CountryInfoService;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class WebServiceImpl implements WebService {
    private static final String TAG = "WebServiceImpl";
    private CountryInfoService countryInfoService;
    private CountryAnalyticsService countryAnalyticsService;

    public WebServiceImpl(CountryInfoService countryInfoService,
                          CountryAnalyticsService countryAnalyticsService) {
        this.countryInfoService = countryInfoService;
        this.countryAnalyticsService = countryAnalyticsService;
    }

    @Override
    public Observable<CountryInfo> getInfo(String countryName) {
        return countryInfoService.getInfo(countryName)
                .subscribeOn(Schedulers.io())
                .onErrorReturn(throwable -> new CountryInfo());
    }

    public Observable<List<CountryAnalytics>> getAnalytics(String countryName) {
        return countryAnalyticsService.getAnalytics(countryName)
                .subscribeOn(Schedulers.io())
                .onErrorReturn(throwable -> Collections.emptyList());
    }

    @Override
    public Observable<List<Country>> getCountries() {
        return countryInfoService.getCountries()
                .subscribeOn(Schedulers.io());
    }

}
