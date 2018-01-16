package com.example.nazarii_moshenskyi.cityinfo.dependecies;

import com.example.nazarii_moshenskyi.cityinfo.BuildConfig;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Advise;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Month;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Vaccine;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Weather;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryAnalyticsService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryInfoService;
import com.example.nazarii_moshenskyi.cityinfo.util.deserializer.AdviseDeserializer;
import com.example.nazarii_moshenskyi.cityinfo.util.deserializer.MonthDeserializer;
import com.example.nazarii_moshenskyi.cityinfo.util.deserializer.VaccineDeserializer;
import com.example.nazarii_moshenskyi.cityinfo.util.deserializer.WeatherDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    @Named("InfoRetrofit")
    Retrofit provideInfoRetrofit(Gson gson, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.INFO_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient providesClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }

    @Provides
    @Singleton
    @Named("AnalyticsRetrofit")
    Retrofit provideAnalyticsRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.ANALYTICS_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    CountryInfoService provideInfoService(@Named("InfoRetrofit") Retrofit retrofit) {
        return retrofit.create(CountryInfoService.class);
    }

    @Provides
    @Singleton
    CountryAnalyticsService provideAnalyticsService(@Named("AnalyticsRetrofit") Retrofit retrofit) {
        return retrofit.create(CountryAnalyticsService.class);
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
