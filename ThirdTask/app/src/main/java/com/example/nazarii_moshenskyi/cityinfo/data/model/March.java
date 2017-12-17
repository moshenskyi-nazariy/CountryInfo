
package com.example.nazarii_moshenskyi.cityinfo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class March {

    @SerializedName("tMin")
    @Expose
    private String tMin;
    @SerializedName("tMax")
    @Expose
    private String tMax;
    @SerializedName("tAvg")
    @Expose
    private String tAvg;
    @SerializedName("pMin")
    @Expose
    private String pMin;
    @SerializedName("pMax")
    @Expose
    private String pMax;
    @SerializedName("pAvg")
    @Expose
    private String pAvg;

    public String getTMin() {
        return tMin;
    }

    public void setTMin(String tMin) {
        this.tMin = tMin;
    }

    public String getTMax() {
        return tMax;
    }

    public void setTMax(String tMax) {
        this.tMax = tMax;
    }

    public String getTAvg() {
        return tAvg;
    }

    public void setTAvg(String tAvg) {
        this.tAvg = tAvg;
    }

    public String getPMin() {
        return pMin;
    }

    public void setPMin(String pMin) {
        this.pMin = pMin;
    }

    public String getPMax() {
        return pMax;
    }

    public void setPMax(String pMax) {
        this.pMax = pMax;
    }

    public String getPAvg() {
        return pAvg;
    }

    public void setPAvg(String pAvg) {
        this.pAvg = pAvg;
    }

}
