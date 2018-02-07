package com.nazarii_moshenskyi.countryinfo.data.model;

import android.util.Log;

import java.util.List;

import static android.content.ContentValues.TAG;

public class InfoModel {
    private CountryInfo countryInfo;

    private List<CountryAnalytics> analytics;

    public List<CountryAnalytics> getAnalytics() {
        return analytics;
    }

    public void setAnalytics(List<CountryAnalytics> analytics) {
        Log.d(TAG, "setAnalytics: is null =  " + (analytics == null));
        this.analytics = analytics;
    }

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }
}
