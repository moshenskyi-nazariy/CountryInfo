package com.example.nazarii_moshenskyi.cityinfo.di;

import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.CountryView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CountryPresenterModule {

    private final CountryView view;

    public CountryPresenterModule(CountryView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    public CountryView provideView() {
        return view;
    }
}
