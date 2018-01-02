package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.WebService;
import com.example.nazarii_moshenskyi.cityinfo.ui.MainPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.MainPresenterImpl;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.CountryPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.CountryPresenterImpl;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.CountryInfoPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.CountryInfoPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {

    @Provides
    @Singleton
    public CountryPresenter provideCountryPresenter(WebService service) {
        return new CountryPresenterImpl(service);
    }

    @Provides
    @Singleton
    public CountryInfoPresenter provideCountryInfoPresenter(WebService service) {
        return new CountryInfoPresenterImpl(service);
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenterImpl();
    }
}
