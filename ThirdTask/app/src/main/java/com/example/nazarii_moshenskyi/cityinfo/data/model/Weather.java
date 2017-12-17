
package com.example.nazarii_moshenskyi.cityinfo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("January")
    @Expose
    private January january;
    @SerializedName("February")
    @Expose
    private February february;
    @SerializedName("March")
    @Expose
    private March march;
    @SerializedName("April")
    @Expose
    private April april;
    @SerializedName("May")
    @Expose
    private May may;
    @SerializedName("June")
    @Expose
    private June june;
    @SerializedName("July")
    @Expose
    private July july;
    @SerializedName("August")
    @Expose
    private August august;
    @SerializedName("September")
    @Expose
    private September september;
    @SerializedName("October")
    @Expose
    private October october;
    @SerializedName("November")
    @Expose
    private November november;
    @SerializedName("December")
    @Expose
    private December december;

    public January getJanuary() {
        return january;
    }

    public void setJanuary(January january) {
        this.january = january;
    }

    public February getFebruary() {
        return february;
    }

    public void setFebruary(February february) {
        this.february = february;
    }

    public March getMarch() {
        return march;
    }

    public void setMarch(March march) {
        this.march = march;
    }

    public April getApril() {
        return april;
    }

    public void setApril(April april) {
        this.april = april;
    }

    public May getMay() {
        return may;
    }

    public void setMay(May may) {
        this.may = may;
    }

    public June getJune() {
        return june;
    }

    public void setJune(June june) {
        this.june = june;
    }

    public July getJuly() {
        return july;
    }

    public void setJuly(July july) {
        this.july = july;
    }

    public August getAugust() {
        return august;
    }

    public void setAugust(August august) {
        this.august = august;
    }

    public September getSeptember() {
        return september;
    }

    public void setSeptember(September september) {
        this.september = september;
    }

    public October getOctober() {
        return october;
    }

    public void setOctober(October october) {
        this.october = october;
    }

    public November getNovember() {
        return november;
    }

    public void setNovember(November november) {
        this.november = november;
    }

    public December getDecember() {
        return december;
    }

    public void setDecember(December december) {
        this.december = december;
    }

}
