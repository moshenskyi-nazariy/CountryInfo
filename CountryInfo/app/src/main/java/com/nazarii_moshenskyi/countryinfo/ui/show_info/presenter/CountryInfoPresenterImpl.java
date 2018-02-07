package com.nazarii_moshenskyi.countryinfo.ui.show_info.presenter;

import android.support.annotation.NonNull;

import com.nazarii_moshenskyi.countryinfo.data.model.Advise;
import com.nazarii_moshenskyi.countryinfo.data.model.CountryInfo;
import com.nazarii_moshenskyi.countryinfo.data.model.Currency;
import com.nazarii_moshenskyi.countryinfo.data.model.Electricity;
import com.nazarii_moshenskyi.countryinfo.data.model.InfoModel;
import com.nazarii_moshenskyi.countryinfo.data.model.Timezone;
import com.nazarii_moshenskyi.countryinfo.data.model.Water;
import com.nazarii_moshenskyi.countryinfo.data.model.Weather;
import com.nazarii_moshenskyi.countryinfo.interactor.repository.DataManager;
import com.nazarii_moshenskyi.countryinfo.ui.InternetManager;
import com.nazarii_moshenskyi.countryinfo.ui.base.RxBasePresenter;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.AnalyticsInfo;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.RowType;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.WeatherInfo;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.mapper.CountryAnalyticsMapper;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.mapper.CountryInfoMapper;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.view.CountryInfoMvpView;
import com.nazarii_moshenskyi.countryinfo.ui.util.RxUtils;

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
                .compose(RxUtils.applySchedulersObservable())
                .compose(getProgressTransformer())
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