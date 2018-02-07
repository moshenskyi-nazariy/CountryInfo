package com.nazarii_moshenskyi.countryinfo.dependecies;

import com.nazarii_moshenskyi.countryinfo.interactor.api.CountryAnalyticsService;
import com.nazarii_moshenskyi.countryinfo.interactor.api.CountryInfoService;
import com.nazarii_moshenskyi.countryinfo.interactor.repository.DataManager;
import com.nazarii_moshenskyi.countryinfo.interactor.repository.WebService;
import com.nazarii_moshenskyi.countryinfo.interactor.repository.WebServiceImpl;

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
