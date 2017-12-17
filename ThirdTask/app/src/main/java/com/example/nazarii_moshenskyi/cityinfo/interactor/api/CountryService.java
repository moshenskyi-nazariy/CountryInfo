package com.example.nazarii_moshenskyi.cityinfo.interactor.api;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CountryService {

    @GET("countries/")
    Observable<List<Country>> getCountries();

    @GET("{country}?format=json")
    Observable<CountryInfo> getInfo(@Path("country") String country);

}
