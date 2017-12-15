package com.example.nazarii_moshenskyi.cityinfo.data.model;

import java.util.ArrayList;
import java.util.List;

public class CountryList {
    private List<Country> countries;

    public CountryList() {
        countries   = new ArrayList<>();
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public void add(Country country) {
        countries.add(country);
    }
}
