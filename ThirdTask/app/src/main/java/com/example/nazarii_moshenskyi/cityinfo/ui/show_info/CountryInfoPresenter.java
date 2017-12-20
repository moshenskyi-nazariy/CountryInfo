package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Electricity;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryInfoRepository;
import com.example.nazarii_moshenskyi.cityinfo.ui.BaseView;
import com.example.nazarii_moshenskyi.cityinfo.ui.model.InfoModel;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CountryInfoPresenter {
    private BaseView<InfoModel> view;
    private CountryInfoRepository repository;

    public CountryInfoPresenter(BaseView<InfoModel> view, CountryInfoRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void getInfo() {
        final Observable<CountryInfo> countries = repository.getInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        countries.subscribe(new Consumer<CountryInfo>() {
            @Override
            public void accept(CountryInfo countryInfo) throws Exception {
                InfoModel infoModel = createModel(countryInfo);
                view.onLoad(infoModel);
            }
        });
    }

    private InfoModel createModel(CountryInfo countryInfo) {
        InfoModel infoModel = new InfoModel();
        infoModel.setCurrency(countryInfo.getCurrency().getCode());
        infoModel.setVaccinations(countryInfo.getVaccinations());
        infoModel.setAdvise(countryInfo.getAdvise().getUA());
        infoModel.setLanguages(countryInfo.getLanguage());
        infoModel.setSockets(getSockets(countryInfo));

        return infoModel;
    }

    private String getSockets(CountryInfo countryInfo) {
        StringBuilder socketsData = new StringBuilder();
        Electricity electricityData = countryInfo.getElectricity();

        socketsData.append("Country uses ").append(electricityData.getVoltage())
                .append(" V and ").append(" Hz with plugs: ");

        for (String plug : electricityData.getPlugs()) {
            socketsData.append(plug).append(" ");
        }
        return socketsData.toString();
    }
}
