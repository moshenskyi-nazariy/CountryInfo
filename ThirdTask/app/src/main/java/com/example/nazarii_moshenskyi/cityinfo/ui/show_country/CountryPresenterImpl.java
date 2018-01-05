package com.example.nazarii_moshenskyi.cityinfo.ui.show_country;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.DataManager;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.WebService;
import com.example.nazarii_moshenskyi.cityinfo.util.Filter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CountryPresenterImpl implements CountryPresenter {

    private final DataManager manager;
    private CountryView view;
    private Filter itemFilter;

    public CountryPresenterImpl(DataManager manager) {
        this.manager = manager;
    }

    @Override
    public void attachView(CountryView view){
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) {
            view = null;
        }
    }

    @Override
    public void start() {
        manager.getCountries().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Country>>() {
                    @Override
                    public void accept(List<Country> countries) throws Exception {
                        view.onLoad(countries);
                    }
                });
    }

    @Override
    public void updateItems(String input, CountryAdapter adapter) {
        if (itemFilter == null) {
            itemFilter = new Filter(view.getItems());
        }
        adapter.update(itemFilter.filter(input));
    }
}
