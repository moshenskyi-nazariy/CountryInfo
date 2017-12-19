package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryInfoRepository;
import com.example.nazarii_moshenskyi.cityinfo.ui.BaseView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CountryInfoPresenter {
    private BaseView<CountryInfo> view;
    private CountryInfoRepository repository;

    public CountryInfoPresenter(BaseView<CountryInfo> view, CountryInfoRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void getInfo() {
        Observable<CountryInfo> countries = repository.getInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        view.onLoad(countries);
    }
}
