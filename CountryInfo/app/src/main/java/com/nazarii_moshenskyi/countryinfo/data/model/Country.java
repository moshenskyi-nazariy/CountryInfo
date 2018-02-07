package com.nazarii_moshenskyi.countryinfo.data.model;

import android.os.Parcel;

public class Country {

    private String name;
    private String url;

    protected Country(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}