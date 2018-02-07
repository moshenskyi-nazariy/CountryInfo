package com.nazarii_moshenskyi.countryinfo.dependecies;

import com.nazarii_moshenskyi.countryinfo.interactor.repository.DataManager;
import com.nazarii_moshenskyi.countryinfo.ui.InternetManager;
import com.nazarii_moshenskyi.countryinfo.ui.main.presenter.MainMvpPresenter;
import com.nazarii_moshenskyi.countryinfo.ui.main.presenter.MainPresenterImpl;
import com.nazarii_moshenskyi.countryinfo.ui.show_country.presenter.CountryMvpPresenter;
import com.nazarii_moshenskyi.countryinfo.ui.show_country.presenter.CountryPresenterImpl;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.presenter.CountryInfoMvpPresenter;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.presenter.CountryInfoPresenterImpl;

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
