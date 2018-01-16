package com.example.nazarii_moshenskyi.cityinfo.ui.show_country.presenter;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.DataManager;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.BasePresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view.CountryMvpView;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view.recycler.CountryAdapter;
import com.example.nazarii_moshenskyi.cityinfo.util.Filter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CountryPresenterImpl extends BasePresenter<CountryMvpView> implements CountryMvpPresenter {
    private Disposable countriesDisposable;
    private final DataManager manager;
    private Filter itemFilter;

    public CountryPresenterImpl(DataManager manager) {
        this.manager = manager;
    }

    @Override
    public void detachView() {
        super.detachView();
        countriesDisposable.dispose();
    }

    public void getCountries() {
        countriesDisposable = manager.getCountries().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Country>>() {
                    @Override
                    public void accept(List<Country> countries) throws Exception {
                        getView().onLoad(countries);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        handleError(throwable);
                    }
                });
    }

    @Override
    public void updateItems(String input, CountryAdapter adapter) {
        if (itemFilter == null) {
            itemFilter = new Filter(getView().getItems());
        }
        adapter.update(itemFilter.filter(input));
    }
}
