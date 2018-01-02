package com.example.nazarii_moshenskyi.cityinfo.data.model;

import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ViewHolderFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Electricity implements RowType {
    @SerializedName("voltage")
    @Expose
    private String voltage;
    @SerializedName("frequency")
    @Expose
    private String frequency;
    @SerializedName("plugs")
    @Expose
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
        builder.deleteCharAt(builder.length());
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
