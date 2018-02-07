package com.nazarii_moshenskyi.countryinfo.interactor.repository;

import com.nazarii_moshenskyi.countryinfo.data.model.Country;
import com.nazarii_moshenskyi.countryinfo.data.model.CountryAnalytics;
import com.nazarii_moshenskyi.countryinfo.data.model.CountryInfo;

import java.util.List;

import io.reactivex.Observable;

public interface WebService {

    Observable<CountryInfo> getInfo(String countryName);

    Observable<List<Country>> getCountries();

    Observable<List<CountryAnalytics>> getAnalytics(String countryName);

}
