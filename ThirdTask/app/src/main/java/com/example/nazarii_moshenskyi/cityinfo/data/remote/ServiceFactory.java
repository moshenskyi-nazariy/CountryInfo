package com.example.nazarii_moshenskyi.cityinfo.data.remote;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {
    private static CityService service;
    private static final String URL = "https://github.com/moshenskyi-nazariy/JsonCitiesParser/blob/master/new/citiesJson.json/";
    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    @NonNull
    public static CityService getService() {
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(CityService.class);
    }
}
