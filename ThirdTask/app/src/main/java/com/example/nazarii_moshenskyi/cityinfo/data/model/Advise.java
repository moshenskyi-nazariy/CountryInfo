package com.example.nazarii_moshenskyi.cityinfo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Advise {

    @SerializedName("advise")
    @Expose
    private String advise;

    public String getAdvise() {
        return advise;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }
}
