package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.presenter;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Advise;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryAnalytics;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Currency;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Electricity;
import com.example.nazarii_moshenskyi.cityinfo.data.model.InfoModel;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Timezone;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Water;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.DataManager;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.BasePresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.RxBasePresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.DangerInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.mapper.UiModelMapper;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.view.CountryInfoMvpView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CountryInfoPresenterImpl extends RxBasePresenter<CountryInfoMvpView> implements CountryInfoMvpPresenter {
    private final DataManager manager;
    private List<RowType> model;

    public CountryInfoPresenterImpl(DataManager manager, CompositeDisposable disposable) {
        super(disposable);
        this.manager = manager;
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
        getCompositeDisposable().add(manager.getInfo(countryName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<InfoModel>() {
                    @Override
                    public void accept(InfoModel infoModel) throws Exception {
                        CountryInfo countryInfo = infoModel.getCountryInfo();
                        Electricity electricity = countryInfo.getElectricity();
                        Currency currency = countryInfo.getCurrency();
                        Water water = countryInfo.getWater();
                        Timezone timezone = countryInfo.getTimezone();
                        Advise advise = countryInfo.getAdvise();

                        model.add(UiModelMapper.convertCurrency(currency));
                        model.add(UiModelMapper.convertElectricity(electricity));
                        model.add(UiModelMapper.convertWater(water));
                        model.add(UiModelMapper.convertTimezone(timezone));

                        DangerInfo dangerInfo = UiModelMapper.convertAdvise(advise);

                        //Analytics is an array with only one item
                        CountryAnalytics countryAnalytics = UiModelMapper.convertCountryAnalytics(infoModel.getAnalytics());
                        if (countryAnalytics != null) {
                            getView().setBackground(countryAnalytics.getFlag());
                            getView().setTitleInfo(countryAnalytics, UiModelMapper.convertContinent(countryInfo.getNames()));
                        }
                        getView().onLoad(model, dangerInfo);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        handleError(throwable);
                    }
                }));
    }
}
