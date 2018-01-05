package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.DataManager;
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
    public CountryPresenter provideCountryPresenter(DataManager manager) {
        return new CountryPresenterImpl(manager);
    }

    @Provides
    @Singleton
    public CountryInfoPresenter provideCountryInfoPresenter(DataManager manager) {
        return new CountryInfoPresenterImpl(manager);
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenterImpl();
    }
}
