package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Advise;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryAnalytics;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Currency;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Electricity;
import com.example.nazarii_moshenskyi.cityinfo.data.model.InfoModel;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Timezone;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Water;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.DataManager;
import com.example.nazarii_moshenskyi.cityinfo.ui.BasePresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.DangerInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.UiModelMapper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CountryInfoPresenterImpl extends BasePresenter<CountryInfoMvpView> implements CountryInfoMvpPresenter {
    private final DataManager manager;
    private List<RowType> model;
    private Disposable countryDisposable;
    private static final String TAG = "CountryInfoMvpPresenter";

    public CountryInfoPresenterImpl(DataManager manager) {
        this.manager = manager;
        model = new ArrayList<>();
    }

    @Override
    public void detachView() {
        super.detachView();

        if (model != null && model.size() > 0) {
            model.clear();
        }

        countryDisposable.dispose();
    }

    public void getInfo(String countryName) {
        countryDisposable = manager.getInfo(countryName)
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
                        List<CountryAnalytics> countryAnalytics = infoModel.getAnalytics();
                        if (!countryAnalytics.isEmpty()) {
                            getView().setBackground(countryAnalytics.get(0).getFlag());
                        }
                        getView().onLoad(model, dangerInfo);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        handleError(throwable);
                    }
                });
    }
}
