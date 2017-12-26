package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryInfoRepository;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryRepository;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.CountryPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.CountryInfoPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {

    @Provides
    @Singleton
    public CountryPresenter provideCountryPresenter(CountryRepository repository) {
        return new CountryPresenter(repository);
    }

    @Provides
    @Singleton
    public CountryInfoPresenter provideCountryInfoPresenter(CountryInfoRepository repository) {
        return new CountryInfoPresenter(repository);
    }
}
