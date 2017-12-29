package com.example.nazarii_moshenskyi.cityinfo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("alpha2Code")
    @Expose
    private String alpha2Code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameSanitized")
    @Expose
    private String nameSanitized;

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSanitized() {
        return nameSanitized;
    }

    public void setNameSanitized(String nameSanitized) {
        this.nameSanitized = nameSanitized;
    }

}