package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryInfoRepository;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetModule {

    @Singleton
    @Provides
    CountryRepository provideCountryRepository(@Named("CountryService") CountryService service) {
        return new CountryRepository(service);
    }

    @Singleton
    @Provides
    CountryInfoRepository provideCountryInfoRepository(@Named("InfoService") CountryService service) {
        return new CountryInfoRepository(service);
    }

}
