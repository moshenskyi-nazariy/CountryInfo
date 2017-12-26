package com.example.nazarii_moshenskyi.cityinfo;

import android.app.Application;

import com.example.nazarii_moshenskyi.cityinfo.dependecies.CountryComponent;
import com.example.nazarii_moshenskyi.cityinfo.dependecies.DaggerCountryComponent;
import com.example.nazarii_moshenskyi.cityinfo.dependecies.NetModule;
import com.example.nazarii_moshenskyi.cityinfo.dependecies.PresentersModule;

public class CountryInfoApplication extends Application {

    private CountryComponent countryComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        countryComponent = DaggerCountryComponent.builder()
                .presentersModule(new PresentersModule())
                .netModule(new NetModule())
                .build();
    }

    public CountryComponent getCountryComponent() {
        return countryComponent;
    }
}
