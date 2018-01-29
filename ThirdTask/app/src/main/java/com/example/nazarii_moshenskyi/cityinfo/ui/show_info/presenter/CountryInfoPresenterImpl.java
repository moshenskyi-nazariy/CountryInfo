package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.presenter;

import android.support.annotation.NonNull;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Advise;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Currency;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Electricity;
import com.example.nazarii_moshenskyi.cityinfo.data.model.InfoModel;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Timezone;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Water;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Weather;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.DataManager;
import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.RxBasePresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.AnalyticsInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.WeatherInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.mapper.CountryAnalyticsMapper;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.mapper.CountryInfoMapper;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.view.CountryInfoMvpView;
import com.example.nazarii_moshenskyi.cityinfo.ui.util.RxUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class CountryInfoPresenterImpl extends RxBasePresenter<CountryInfoMvpView, InfoModel> implements CountryInfoMvpPresenter {
    private final DataManager manager;
    private final InternetManager internetManager;
    private List<RowType> model;

    @Inject
    public CountryInfoPresenterImpl(InternetManager internetManager, DataManager manager, CompositeDisposable disposable) {
        super(disposable, internetManager);
        this.manager = manager;
        this.internetManager = internetManager;
        model = new ArrayList<>();
    }

    @Override
    public void detachView() {
        super.detachView();

        if (model != null && model.size() > 0) {
            model.clear();
        }
    }

    public void getInfo(String countryName) {
        getCompositeDisposable().add(internetManager.getConnectionObservable()
                .flatMap(hasConnection -> manager.getInfo(countryName))
                .compose(getProgressTransformer())
                .compose(RxUtils.applySchedulersObservable())
                .subscribe(infoModel -> {
                    CountryInfo countryInfo = instantiateModels(infoModel);

                    //Analytics is an array with only one item
                    AnalyticsInfo countryAnalytics = CountryAnalyticsMapper.convertCountryAnalytics(infoModel.getAnalytics());
                    if (countryAnalytics != null) {
                        getView().setBackground(countryAnalytics.getFlag());
                        getView().setTitleInfo(countryAnalytics, CountryInfoMapper.convertContinent(countryInfo.getNames()));
                    }
                    getView().onLoad(model);
                    getView().hideLoadingBar();
                }, this::handleError));

    }

    @NonNull
    private CountryInfo instantiateModels(InfoModel infoModel) {
        CountryInfo countryInfo = infoModel.getCountryInfo();
        Electricity electricity = countryInfo.getElectricity();
        Currency currency = countryInfo.getCurrency();
        Water water = countryInfo.getWater();
        Timezone timezone = countryInfo.getTimezone();
        Advise advise = countryInfo.getAdvise();
        Weather weather = countryInfo.getWeather();

        model.add(new WeatherInfo(weather));
        model.add(CountryInfoMapper.convertCurrency(currency));
        model.add(CountryInfoMapper.convertElectricity(electricity));
        model.add(CountryInfoMapper.convertWater(water));
        model.add(CountryInfoMapper.convertTimezone(timezone));
        model.add(CountryInfoMapper.convertAdvise(advise));
        return countryInfo;
    }
}