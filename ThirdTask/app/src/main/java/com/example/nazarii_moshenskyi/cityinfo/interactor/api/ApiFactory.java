package com.example.nazarii_moshenskyi.cityinfo.interactor.api;

import com.example.nazarii_moshenskyi.cityinfo.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    public static CountryService getCountryService() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(CountryService.class);
    }

    private static OkHttpClient getClient() {
        return new OkHttpClient().newBuilder()
                .addInterceptor(new AutorizationInterceptor())
                .build();
    }
}
