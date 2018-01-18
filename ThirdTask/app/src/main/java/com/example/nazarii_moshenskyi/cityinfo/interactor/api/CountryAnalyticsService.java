package com.example.nazarii_moshenskyi.cityinfo.interactor.api;

import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryAnalytics;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CountryAnalyticsService {

    @GET("{country}?fullText=true&fields=flag;timezones;area;population")
    Observable<List<CountryAnalytics>> getAnalytics(@Path("country") String country);

}
