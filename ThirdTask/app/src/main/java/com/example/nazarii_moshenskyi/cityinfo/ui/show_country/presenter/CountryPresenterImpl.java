package com.example.nazarii_moshenskyi.cityinfo.ui.show_country.presenter;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.DataManager;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.BasePresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.RxBasePresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view.CountryMvpView;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view.recycler.CountryAdapter;
import com.example.nazarii_moshenskyi.cityinfo.util.Filter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CountryPresenterImpl extends RxBasePresenter<CountryMvpView> implements CountryMvpPresenter {
    private final DataManager manager;
    private Filter itemFilter;

    public CountryPresenterImpl(DataManager manager, CompositeDisposable disposable) {
        super(disposable);
        this.manager = manager;
    }

    public void getCountries() {
        getCompositeDisposable().add(manager.getCountries().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(countries -> getView().onLoad(countries)
                , this::handleError));
    }

    @Override
    public void updateItems(String input, CountryAdapter adapter) {
        if (itemFilter == null) {
            itemFilter = new Filter(getView().getItems());
        }
        adapter.update(itemFilter.filter(input));
    }
}
