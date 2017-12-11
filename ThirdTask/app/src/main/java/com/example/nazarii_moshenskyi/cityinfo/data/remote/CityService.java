package com.example.nazarii_moshenskyi.cityinfo.data.remote;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CityService {

    @GET("/all/")
    Call<List<Country>> getCountries();

}
