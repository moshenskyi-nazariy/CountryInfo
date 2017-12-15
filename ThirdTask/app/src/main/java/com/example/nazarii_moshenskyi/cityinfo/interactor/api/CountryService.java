package com.example.nazarii_moshenskyi.cityinfo.interactor.api;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryService {

    @GET("countries/")
    Call<Country> getCountries();

}
