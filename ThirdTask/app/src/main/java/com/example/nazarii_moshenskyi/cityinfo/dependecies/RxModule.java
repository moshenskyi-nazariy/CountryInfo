package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import android.content.Context;

import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class RxModule {
    private Context context;

    public RxModule(Context context) {
        this.context = context;
    }

    @Provides
    public CompositeDisposable providesDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @Singleton
    public InternetManager providesInternetManager() {
        return new InternetManager(context);
    }

}
