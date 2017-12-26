package com.example.nazarii_moshenskyi.cityinfo.di;

import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.CountryFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = CountryPresenterModule.class)
public interface CountryComponent {
    void inject(CountryFragment countryFragment);
}
