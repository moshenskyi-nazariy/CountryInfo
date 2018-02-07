package com.nazarii_moshenskyi.countryinfo.interactor.api;

import com.nazarii_moshenskyi.countryinfo.data.model.Country;
import com.nazarii_moshenskyi.countryinfo.data.model.CountryInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CountryInfoService {

    @GET("countries.json")
    Observable<List<Country>> getCountries();

    @GET("{country}?format=json")
    Observable<CountryInfo> getInfo(@Path("country") String country);

}
