package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.DataManager;
import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;
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
    public CountryMvpPresenter provideCountryPresenter(InternetManager internetManager,
                                                       DataManager dataManager,
                                                       CompositeDisposable disposable) {
        return new CountryPresenterImpl(internetManager, dataManager, disposable);
    }

    @Provides
    public CountryInfoMvpPresenter provideCountryInfoPresenter(InternetManager internetManager,
                                                               DataManager manager,
                                                               CompositeDisposable disposable) {
        return new CountryInfoPresenterImpl(internetManager, manager, disposable);
    }

    @Provides
    public MainMvpPresenter provideMainPresenter(InternetManager internetManager) {
        return new MainPresenterImpl(internetManager);
    }

}
