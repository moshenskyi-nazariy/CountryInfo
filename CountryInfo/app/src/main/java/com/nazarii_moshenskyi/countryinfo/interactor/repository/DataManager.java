package com.nazarii_moshenskyi.countryinfo.interactor.repository;

import android.util.Log;

import com.nazarii_moshenskyi.countryinfo.data.model.Country;
import com.nazarii_moshenskyi.countryinfo.data.model.InfoModel;

import java.util.List;

import io.reactivex.Observable;

public class DataManager {
    private static final String TAG = "DataManager";
    private WebService webService;

    public DataManager(WebService webService) {
        this.webService = webService;
    }

    public Observable<InfoModel> getInfo(final String countryName) {
        final InfoModel infoModel = new InfoModel();

        return Observable.zip(webService.getInfo(countryName),
                webService.getAnalytics(countryName),
                (countryInfo, analytics) -> {
                    Log.d(TAG, "apply:" + countryName + " == null is " + (countryInfo == null));
                    infoModel.setAnalytics(analytics);
                    infoModel.setCountryInfo(countryInfo);
                    return infoModel;
                });
    }

    public Observable<List<Country>> getCountries() {
        return webService.getCountries();
    }
}
