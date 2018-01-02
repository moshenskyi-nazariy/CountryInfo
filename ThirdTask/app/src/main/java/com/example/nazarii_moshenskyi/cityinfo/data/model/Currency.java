package com.example.nazarii_moshenskyi.cityinfo.data.model;

import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ViewHolderFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Currency implements RowType {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("rate")
    @Expose
    private String rate;
    @SerializedName("compare")
    @Expose
    private List<Compare> compare = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public List<Compare> getCompare() {
        return compare;
    }

    public void setCompare(List<Compare> compare) {
        this.compare = compare;
    }

    @Override
    public int getItemViewType() {
        return TEXT_ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        ViewHolderFactory.TextViewHolder textViewHolder = (ViewHolderFactory.TextViewHolder) viewHolder;
        textViewHolder.setDescriprionText("1 " + name + " = " + rate + " USD");
        textViewHolder.setTitleText("Currency");
    }
}
