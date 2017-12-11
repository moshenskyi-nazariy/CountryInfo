package com.example.nazarii_moshenskyi.cityinfo.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country {

    @SerializedName("country")
    private String country;

    @SerializedName("cities")
    private List<City> cities = null;

    public String getName() {
        return country;
    }

    public void setName(String country) {
        this.country = country;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
