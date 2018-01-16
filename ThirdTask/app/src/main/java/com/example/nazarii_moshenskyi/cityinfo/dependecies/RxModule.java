package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class RxModule {

    @Provides
    public CompositeDisposable providesDisposable() {
        return new CompositeDisposable();
    }
}
