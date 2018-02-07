package com.nazarii_moshenskyi.countryinfo.data.model;

import java.util.List;

public class Electricity {
    private String voltage;
    private String frequency;
    private List<String> plugs = null;

    private String data;

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
