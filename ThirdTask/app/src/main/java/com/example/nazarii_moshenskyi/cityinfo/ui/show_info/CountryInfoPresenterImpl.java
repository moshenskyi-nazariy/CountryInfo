package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.util.Log;

import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Currency;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Electricity;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Timezone;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Water;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryInfoRepository;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.UiModelMapper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CountryInfoPresenterImpl implements CountryInfoPresenter {
    private CountryInfoView view;
    private final CountryInfoRepository repository;
    private List<RowType> infoModel;
    private static final String TAG = "CountryInfoPresenter";

    public CountryInfoPresenterImpl(CountryInfoRepository repository) {
        this.repository = repository;
        infoModel = new ArrayList<>();
    }

    public void attachView(CountryInfoView view) {
        this.view = view;
    }

    public void detachView() {
        if (view != null) {
            view = null;
        }

        if (infoModel != null && infoModel.size() > 0) {
            infoModel.clear();
        }
    }

    public void start() {
    }

    public void getInfo(String countryName) {
        repository.getInfo(countryName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CountryInfo>() {
                    @Override
                    public void accept(CountryInfo countryInfo) throws Exception {
                        Electricity electricity = countryInfo.getElectricity();
                        Currency currency = countryInfo.getCurrency();
                        Water water = countryInfo.getWater();
                        Timezone timezone = countryInfo.getTimezone();

                        infoModel.add(UiModelMapper.convertCurrency(currency));
                        infoModel.add(UiModelMapper.convertElectricity(electricity));
                        infoModel.add(UiModelMapper.convertWater(water));
                        infoModel.add(UiModelMapper.convertTimezone(timezone));

                        view.onLoad(infoModel);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "accept: " + throwable);
                    }
                });
    }
}
