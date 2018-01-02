package com.example.nazarii_moshenskyi.cityinfo.interactor.api;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CountryService {

    @GET("countries.json")
    Observable<List<Country>> getCountries();

}
