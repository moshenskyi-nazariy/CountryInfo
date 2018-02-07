package com.nazarii_moshenskyi.countryinfo.dependecies;

import com.nazarii_moshenskyi.countryinfo.ui.InternetManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {

    @Provides
    @Singleton
    InternetManager providesInternetManager() {
        return new InternetManager();
    }

}
