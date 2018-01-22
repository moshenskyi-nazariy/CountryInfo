package com.example.nazarii_moshenskyi.cityinfo.interactor.repository;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryAnalytics;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryAnalyticsService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryInfoService;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;

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
        return countryInfoService.getInfo(countryName).onErrorResumeNext(throwable -> {
            return Observable.create(emitter -> {
                emitter.onNext(new CountryInfo());
                emitter.onComplete();
            });
        });
    }

    public Observable<List<CountryAnalytics>> getAnalytics(String countryName) {
        return countryAnalyticsService.getAnalytics(countryName)
                .onErrorResumeNext(throwable -> {
                   return Observable.create(emitter -> {
                       emitter.onNext(Collections.emptyList());
                       emitter.onComplete();
                    });
                });
    }

    @Override
    public Observable<List<Country>> getCountries() {
        return countryInfoService.getCountries();
    }

}
