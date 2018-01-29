package com.example.nazarii_moshenskyi.cityinfo.ui.show_country.presenter;

import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.DataManager;
import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.RxBasePresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view.CountryMvpView;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view.recycler.CountryAdapter;
import com.example.nazarii_moshenskyi.cityinfo.util.Filter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class CountryPresenterImpl extends RxBasePresenter<CountryMvpView> implements CountryMvpPresenter {
    private final DataManager manager;
    private final InternetManager internetManager;
    private Filter itemFilter;

    @Inject
    public CountryPresenterImpl(InternetManager internetManager, DataManager manager, CompositeDisposable disposable) {
        super(disposable, internetManager);
        this.manager = manager;
        this.internetManager = internetManager;
    }

    public void getCountries() {
        getCompositeDisposable().add(internetManager.getConnectionObservable()
                .filter(hasConnection -> hasConnection)
                .doOnNext(ready -> getView().showLoadingBar())
                .flatMap(hasConnection -> manager.getCountries())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(countries -> {
                    getView().onLoad(countries);
                    getView().hideLoadingBar();
                }, this::handleError));
    }

    @Override
    public void updateItems(String input, CountryAdapter adapter) {
        if (itemFilter == null) {
            itemFilter = new Filter(getView().getItems());
        }
        adapter.update(itemFilter.filter(input));
    }
}
