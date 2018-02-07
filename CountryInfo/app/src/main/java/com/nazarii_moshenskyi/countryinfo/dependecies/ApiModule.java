package com.nazarii_moshenskyi.countryinfo.dependecies;

import com.nazarii_moshenskyi.countryinfo.BuildConfig;
import com.nazarii_moshenskyi.countryinfo.data.model.Advise;
import com.nazarii_moshenskyi.countryinfo.data.model.Month;
import com.nazarii_moshenskyi.countryinfo.data.model.Vaccine;
import com.nazarii_moshenskyi.countryinfo.data.model.Weather;
import com.nazarii_moshenskyi.countryinfo.dependecies.scopes.AnalyticsRetrofit;
import com.nazarii_moshenskyi.countryinfo.dependecies.scopes.InfoRetrofit;
import com.nazarii_moshenskyi.countryinfo.interactor.api.CountryAnalyticsService;
import com.nazarii_moshenskyi.countryinfo.interactor.api.CountryInfoService;
import com.nazarii_moshenskyi.countryinfo.util.deserializer.AdviseDeserializer;
import com.nazarii_moshenskyi.countryinfo.util.deserializer.MonthDeserializer;
import com.nazarii_moshenskyi.countryinfo.util.deserializer.VaccineDeserializer;
import com.nazarii_moshenskyi.countryinfo.util.deserializer.WeatherDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    @InfoRetrofit
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
    OkHttpClient providesClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }

    @Provides
    @Singleton
    @AnalyticsRetrofit
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
    CountryInfoService provideInfoService(@InfoRetrofit Retrofit retrofit) {
        return retrofit.create(CountryInfoService.class);
    }

    @Provides
    @Singleton
    CountryAnalyticsService provideAnalyticsService(@AnalyticsRetrofit Retrofit retrofit) {
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
