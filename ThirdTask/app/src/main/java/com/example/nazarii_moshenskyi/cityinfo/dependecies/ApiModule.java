package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import com.example.nazarii_moshenskyi.cityinfo.BuildConfig;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Advise;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Month;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Vaccine;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Weather;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.AutorizationInterceptor;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;
import com.example.nazarii_moshenskyi.cityinfo.util.AdviseDeserializer;
import com.example.nazarii_moshenskyi.cityinfo.util.MonthDeserializer;
import com.example.nazarii_moshenskyi.cityinfo.util.VaccineDeserializer;
import com.example.nazarii_moshenskyi.cityinfo.util.WeatherDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    @Named("CountryService")
    CountryService provideCountryService(@Named("CountryRetrofit") Retrofit retrofit) {
        return retrofit.create(CountryService.class);
    }

    @Provides
    @Singleton
    @Named("CountryRetrofit")
    Retrofit provideRetrofitService(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new AutorizationInterceptor())
                .build();
    }

    @Provides
    @Singleton
    @Named("InfoServiceRetrofit")
    Retrofit provideRetrofitInfoService(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.INFO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @Named("InfoService")
    CountryService provideInfoService(@Named("InfoServiceRetrofit") Retrofit retrofit) {
        return retrofit.create(CountryService.class);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().registerTypeAdapter(Advise.class, new AdviseDeserializer())
                .registerTypeAdapter(Weather.class, new WeatherDeserializer())
                .registerTypeAdapter(Month.class, new MonthDeserializer())
                .registerTypeAdapter(Vaccine.class, new VaccineDeserializer())
                .create();
    }
}
