package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model;

import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ElectricityInfo implements RowType {
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

        StringBuilder builder = new StringBuilder();
        for (String plug : plugs) {
            builder.append(plug).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        data = builder.toString();
    }

    private String checkNotNull(String toCheck) {
        return toCheck == null ? "-" : toCheck;
    }

    @Override
    public int getItemViewType() {
        return ELECTRICITY_ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        ViewHolderFactory.ElectricityViewHolder electricityViewHolder =
                (ViewHolderFactory.ElectricityViewHolder) viewHolder;

        electricityViewHolder.setVoltage(checkNotNull(voltage));

        electricityViewHolder.setFrequency(checkNotNull(frequency));

        electricityViewHolder.setPlugs(checkNotNull(data));

    }
}

