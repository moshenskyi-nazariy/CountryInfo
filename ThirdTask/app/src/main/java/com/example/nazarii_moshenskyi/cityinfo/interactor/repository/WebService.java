package com.example.nazarii_moshenskyi.cityinfo.interactor.repository;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryAnalytics;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

public interface WebService {

    Observable<CountryInfo> getInfo(String countryName);

    Observable<List<Country>> getCountries();

    Observable<List<CountryAnalytics>> getAnalytics(String countryName);

}
