package com.nazarii_moshenskyi.countryinfo.ui;

import android.app.Application;

import com.nazarii_moshenskyi.countryinfo.dependecies.ApiModule;
import com.nazarii_moshenskyi.countryinfo.dependecies.CountryComponent;
import com.nazarii_moshenskyi.countryinfo.dependecies.DaggerCountryComponent;
import com.nazarii_moshenskyi.countryinfo.dependecies.NetModule;
import com.nazarii_moshenskyi.countryinfo.dependecies.PresentersModule;
import com.nazarii_moshenskyi.countryinfo.dependecies.RxModule;
import com.nazarii_moshenskyi.countryinfo.dependecies.UtilsModule;
import com.squareup.leakcanary.LeakCanary;

public class CountryInfoApplication extends Application {

    private CountryComponent countryComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        countryComponent = DaggerCountryComponent.builder()
                .rxModule(new RxModule())
                .utilsModule(new UtilsModule())
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
