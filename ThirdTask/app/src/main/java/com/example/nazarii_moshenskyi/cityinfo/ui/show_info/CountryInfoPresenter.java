package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Electricity;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.ApiFactory;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryInfoRepository;
import com.example.nazarii_moshenskyi.cityinfo.ui.model.InfoModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CountryInfoPresenter {
    private CountryInfoView view;
    private CountryInfoRepository repository;
    private CountryService infoService;

    public CountryInfoPresenter(CountryInfoView view, String countryName) {
        this.view = view;
        infoService = ApiFactory.getCountryInfoService();
        repository = new CountryInfoRepository(infoService, countryName);
    }

    public void getInfo() {
        repository.getInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CountryInfo>() {
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
        infoModel.setAdvise(countryInfo.getAdvise().getAdvise());
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
