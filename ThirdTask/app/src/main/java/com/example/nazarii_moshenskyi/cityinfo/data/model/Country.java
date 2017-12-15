package com.example.nazarii_moshenskyi.cityinfo.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Country {
    @SerializedName("name")
    private String name;

    @SerializedName("cities")
    private List<City> cities;

    public Country() {
        cities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public List<City> getCities() {
        return cities;
    }
}