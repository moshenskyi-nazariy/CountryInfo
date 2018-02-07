package com.nazarii_moshenskyi.countryinfo.data.model;

import com.google.gson.annotations.SerializedName;

public class Water {

    @SerializedName("short")
    private String shortInfo;

    @SerializedName("full")
    private String fullInfo;

    public String getShort() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public String getFullInfo() {
        return fullInfo;
    }

    public void setFullInfo(String fullInfo) {
        this.fullInfo = fullInfo;
    }
}
