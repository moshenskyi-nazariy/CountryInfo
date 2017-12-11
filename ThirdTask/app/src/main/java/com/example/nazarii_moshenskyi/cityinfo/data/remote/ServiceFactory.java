package com.example.nazarii_moshenskyi.cityinfo.data.remote;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {
    private static CityService service;
    private static final String URL = "https://restcountries.eu/rest/v2/";
    /*private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();*/

    @NonNull
    public static CityService getService() {
        //createGson();
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CityService.class);
    }

    /*private static void createGson() {
        gson = new GsonBuilder()
                .registerTypeAdapter(CountryList.class, new CountryListDeserializer())
                .registerTypeAdapter(Country.class, new CountryDeserializer())
                .setLenient()
                .create();
    }*/
}
