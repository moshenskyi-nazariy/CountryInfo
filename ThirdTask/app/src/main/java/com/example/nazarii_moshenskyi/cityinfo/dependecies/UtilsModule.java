package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;

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
