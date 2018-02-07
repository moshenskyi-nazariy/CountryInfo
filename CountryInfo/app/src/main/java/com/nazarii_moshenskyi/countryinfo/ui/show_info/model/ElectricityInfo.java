package com.nazarii_moshenskyi.countryinfo.ui.show_info.model;

import java.util.List;

public class ElectricityInfo implements RowType {
    private String voltage;
    private String frequency;
    private List<String> plugs = null;

    public String data;

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

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setPlugs(List<String> plugs) {
        this.plugs = plugs;

        if (plugs != null && !plugs.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (String plug : plugs) {
                builder.append(plug).append(",");
            }
            builder.deleteCharAt(builder.length() - 1);
            data = builder.toString();
        }
    }
}

