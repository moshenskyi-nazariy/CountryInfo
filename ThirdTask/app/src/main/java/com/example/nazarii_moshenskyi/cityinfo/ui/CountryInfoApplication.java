package com.example.nazarii_moshenskyi.cityinfo.ui;

import android.app.Application;

import com.example.nazarii_moshenskyi.cityinfo.dependecies.ApiModule;
import com.example.nazarii_moshenskyi.cityinfo.dependecies.CountryComponent;
import com.example.nazarii_moshenskyi.cityinfo.dependecies.DaggerCountryComponent;
import com.example.nazarii_moshenskyi.cityinfo.dependecies.NetModule;
import com.example.nazarii_moshenskyi.cityinfo.dependecies.PresentersModule;
import com.example.nazarii_moshenskyi.cityinfo.dependecies.RxModule;
import com.squareup.leakcanary.LeakCanary;

public class CountryInfoApplication extends Application {

    private CountryComponent countryComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        countryComponent = DaggerCountryComponent.builder()
                .rxModule(new RxModule(getApplicationContext()))
                .presentersModule(new PresentersModule())
                .apiModule(new ApiModule())
                .netModule(new NetModule())
                .build();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    public CountryComponent getCountryComponent() {
        return countryComponent;
    }
}
