package com.example.nazarii_moshenskyi.cityinfo.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Country {
    @SerializedName("name")
    private String name;

    @SerializedName("cities")
    private List<City> cities = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCity(String cityName) {
        City city = new City();
        city.setName(cityName);
        cities.add(city);
    }

    public List<City> getCities() {
        return cities;
    }
}