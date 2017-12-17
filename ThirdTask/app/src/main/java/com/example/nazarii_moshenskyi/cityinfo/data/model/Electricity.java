
package com.example.nazarii_moshenskyi.cityinfo.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Electricity {

    @SerializedName("voltage")
    @Expose
    private String voltage;
    @SerializedName("frequency")
    @Expose
    private String frequency;
    @SerializedName("plugs")
    @Expose
    private List<String> plugs = null;

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public List<String> getPlugs() {
        return plugs;
    }

    public void setPlugs(List<String> plugs) {
        this.plugs = plugs;
    }

}
