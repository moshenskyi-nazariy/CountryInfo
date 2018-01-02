package com.example.nazarii_moshenskyi.cityinfo.interactor.api;

import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CountryInfoService {

    @GET("{country}?format=json")
    Observable<CountryInfo> getInfo(@Path("country") String country);

}
