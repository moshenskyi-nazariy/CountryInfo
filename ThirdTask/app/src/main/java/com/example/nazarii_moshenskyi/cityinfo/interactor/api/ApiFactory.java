package com.example.nazarii_moshenskyi.cityinfo.interactor.api;

import com.example.nazarii_moshenskyi.cityinfo.BuildConfig;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Vaccine;
import com.example.nazarii_moshenskyi.cityinfo.util.MonthDeserializer;
import com.example.nazarii_moshenskyi.cityinfo.util.VaccineDeserializer;
import com.example.nazarii_moshenskyi.cityinfo.util.WeatherDeserializer;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Month;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Weather;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    public static CountryService getCountryService() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(CountryService.class);
    }

    private static OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new AutorizationInterceptor())
                .build();
    }

    public static CountryService getCountryInfoService() {
        Gson gson = getGson();
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.INFO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(CountryService.class);
    }

    private static Gson getGson() {
        return new GsonBuilder().registerTypeAdapter(Weather.class, new WeatherDeserializer())
                .registerTypeAdapter(Month.class, new MonthDeserializer())
                .registerTypeAdapter(Vaccine.class, new VaccineDeserializer())
                .create();
    }
}
