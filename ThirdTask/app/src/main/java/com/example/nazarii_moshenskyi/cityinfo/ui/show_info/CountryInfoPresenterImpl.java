package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.util.Log;

import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Electricity;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryInfoRepository;
import com.example.nazarii_moshenskyi.cityinfo.ui.model.InfoModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CountryInfoPresenterImpl implements CountryInfoPresenter {
    private static final String TAG = "CountryInfoPresenter";
    private final CountryInfoRepository repository;
    private CountryInfoView view;

    public CountryInfoPresenterImpl(CountryInfoRepository repository) {
        this.repository = repository;
    }


    public void attachView(CountryInfoView view) {
        this.view = view;
    }

    public void detachView() {
        if (view != null) {
            view = null;
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
                        InfoModel infoModel = createModel(countryInfo);
                        view.onLoad(infoModel);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "accept: " + throwable);
                    }
                });
    }

    private InfoModel createModel(CountryInfo countryInfo) {
        InfoModel infoModel = new InfoModel();
        infoModel.setCurrency(countryInfo.getCurrency().getCode());
        infoModel.setVaccinations(countryInfo.getVaccinations());
        infoModel.setAdvise(countryInfo.getAdvise().getAdvise());
        infoModel.setLanguages(countryInfo.getLanguage());
        infoModel.setSockets(getSockets(countryInfo));

        return infoModel;
    }

    private String getSockets(CountryInfo countryInfo) {
        StringBuilder socketsData = new StringBuilder();
        Electricity electricityData = countryInfo.getElectricity();
        List<String> plugs = electricityData.getPlugs();

        socketsData.append("Country uses ").append(electricityData.getVoltage())
                .append(" V and ").append(electricityData.getFrequency())
                .append(" Hz with plugs: ").append(plugs.get(0))
                .append(" and ").append(plugs.get(1));

        return socketsData.toString();
    }
}