package com.example.nazarii_moshenskyi.cityinfo.show_cities;

import com.example.nazarii_moshenskyi.cityinfo.BaseView;
import com.example.nazarii_moshenskyi.cityinfo.data.GsonService;
import com.example.nazarii_moshenskyi.cityinfo.data.model.City;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryList;

import java.util.List;

public class CityPresenter {
    private final BaseView view;
    private final GsonService gsonService;
    private CountryList countries;

    public CityPresenter(BaseView view, GsonService gsonService) {
        this.gsonService = gsonService;
        this.view = view;
    }

    public void getCountryList() {
        countries = gsonService.getCountries();
        view.onLoad(countries);
    }

    public List<City> getCityList(int position) {
        Country country = countries.getCountries().get(position);
        return country.getCities();
    }
}
