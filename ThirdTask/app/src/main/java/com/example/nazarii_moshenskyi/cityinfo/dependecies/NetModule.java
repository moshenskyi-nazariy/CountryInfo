package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryAnalyticsService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryInfoService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.DataManager;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.WebService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.WebServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetModule {

    @Singleton
    @Provides
    DataManager provideDataManager(WebService webService) {
        return new DataManager(webService);
    }

    @Singleton
    @Provides
    WebService provideWebService(CountryInfoService countryInfoService,
                                 CountryAnalyticsService countryAnalyticsService) {

        return new WebServiceImpl(countryInfoService, countryAnalyticsService);
    }

}
