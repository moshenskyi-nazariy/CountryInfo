package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.DataManager;
import com.example.nazarii_moshenskyi.cityinfo.ui.main.presenter.MainMvpPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.main.presenter.MainPresenterImpl;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.presenter.CountryMvpPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.presenter.CountryPresenterImpl;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.presenter.CountryInfoMvpPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.presenter.CountryInfoPresenterImpl;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class PresentersModule {

    @Provides
    public CountryMvpPresenter provideCountryPresenter(DataManager manager, CompositeDisposable disposable) {
        return new CountryPresenterImpl(manager, disposable);
    }

    @Provides
    public CountryInfoMvpPresenter provideCountryInfoPresenter(DataManager manager, CompositeDisposable disposable) {
        return new CountryInfoPresenterImpl(manager, disposable);
    }

    @Provides
    public MainMvpPresenter provideMainPresenter() {
        return new MainPresenterImpl();
    }

}
