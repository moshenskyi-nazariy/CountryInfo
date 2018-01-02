package com.example.nazarii_moshenskyi.cityinfo.interactor.repository;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryAnalytics;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryAnalyticsService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryInfoService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

public class WebServiceImpl implements WebService {
    private static final String TAG = "WebServiceImpl";
    private CountryInfoService countryInfoService;
    private CountryService countryService;
    private CountryAnalyticsService countryAnalyticsService;

    public WebServiceImpl(CountryInfoService countryInfoService,
                          CountryService countryService,
                          CountryAnalyticsService countryAnalyticsService) {
        this.countryInfoService = countryInfoService;
        this.countryService = countryService;
        this.countryAnalyticsService = countryAnalyticsService;
    }

    @Override
    public Observable<CountryInfo> getInfo(final String countryName) {
        //return countryInfoService.getInfo(countryName);
        return  countryInfoService.getInfo(countryName).flatMap(new Function<CountryInfo, ObservableSource<List<CountryAnalytics>>>() {
            @Override
            public ObservableSource<List<CountryAnalytics>> apply(CountryInfo countryInfo) throws Exception {
                return countryAnalyticsService.getAnalytics(countryName);
            }
        }, new BiFunction<CountryInfo, List<CountryAnalytics>, CountryInfo>() {
            @Override
            public CountryInfo apply(CountryInfo countryInfo, List<CountryAnalytics> o) throws Exception {
                countryInfo.setAnalytics(o);
                return countryInfo;
            }
        });
    }

    @Override
    public Observable<List<Country>> getCountries() {
        return countryService.getCountries();
    }

}
