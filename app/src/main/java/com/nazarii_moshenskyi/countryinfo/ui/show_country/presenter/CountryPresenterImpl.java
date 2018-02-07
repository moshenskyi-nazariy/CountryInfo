package com.nazarii_moshenskyi.countryinfo.ui.show_country.presenter;

import com.nazarii_moshenskyi.countryinfo.data.model.Country;
import com.nazarii_moshenskyi.countryinfo.interactor.repository.DataManager;
import com.nazarii_moshenskyi.countryinfo.ui.InternetManager;
import com.nazarii_moshenskyi.countryinfo.ui.base.RxBasePresenter;
import com.nazarii_moshenskyi.countryinfo.ui.show_country.view.CountryMvpView;
import com.nazarii_moshenskyi.countryinfo.ui.show_country.view.recycler.CountryAdapter;
import com.nazarii_moshenskyi.countryinfo.ui.util.RxUtils;
import com.nazarii_moshenskyi.countryinfo.util.Filter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class CountryPresenterImpl extends RxBasePresenter<CountryMvpView, List<Country>> implements CountryMvpPresenter {
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
                .flatMap(hasConnection -> manager.getCountries())
                .compose(RxUtils.applySchedulersObservable())
                .compose(getProgressTransformer())
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
