package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import com.example.nazarii_moshenskyi.cityinfo.interactor.api.ApiFactory;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryInfoRepository;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetModule {

    @Singleton
    @Provides
    public CountryRepository provideCountryRepository(CountryService service) {
        return new CountryRepository(service);
    }

    @Singleton
    @Provides
    public CountryInfoRepository provideCountryInfoRepository(CountryService service) {
        return new CountryInfoRepository(service);
    }

    @Singleton
    @Provides
    public CountryService provideService() {
        return ApiFactory.getCountryService();
    }
}
