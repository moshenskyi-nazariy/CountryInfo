package com.example.nazarii_moshenskyi.cityinfo.data.model;

import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
