package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.util.Log;

import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Currency;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Electricity;
import com.example.nazarii_moshenskyi.cityinfo.data.model.InfoModel;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Timezone;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Water;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.DataManager;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.WebService;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.UiModelMapper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class CountryInfoPresenterImpl implements CountryInfoPresenter {
    private final DataManager manager;
    private CountryInfoView view;
    private List<RowType> model;
    private static final String TAG = "CountryInfoPresenter";

    public CountryInfoPresenterImpl(DataManager manager) {
        this.manager = manager;
        model = new ArrayList<>();
    }

    public void attachView(CountryInfoView view) {
        this.view = view;
    }

    public void detachView() {
        if (view != null) {
            view = null;
        }

        if (model != null && model.size() > 0) {
            model.clear();
        }
    }

    public void start() {
    }

    public void getInfo(String countryName) {
        manager.getInfo(countryName)
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

                        model.add(UiModelMapper.convertCurrency(currency));
                        model.add(UiModelMapper.convertElectricity(electricity));
                        model.add(UiModelMapper.convertWater(water));
                        model.add(UiModelMapper.convertTimezone(timezone));

                        //TODO: items may be null
                        view.setBackground(infoModel.getAnalytics().get(0).getFlag());
                        view.onLoad(model);
                    }
                });
    }
}
