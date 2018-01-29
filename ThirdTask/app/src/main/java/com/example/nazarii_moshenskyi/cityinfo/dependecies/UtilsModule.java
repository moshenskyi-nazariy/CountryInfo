package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import android.content.Context;

import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {
    private Context context;

    public UtilsModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public InternetManager providesInternetManager() {
        return new InternetManager(context);
    }

}
