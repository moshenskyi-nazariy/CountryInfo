package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model;

import android.support.v7.widget.RecyclerView;

public class CurrencyInfo extends BaseRowType {
    private String name;
    private String rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public int getItemViewType() {
        return TEXT_ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        ViewHolderFactory.TextViewHolder textViewHolder = (ViewHolderFactory.TextViewHolder) viewHolder;
        textViewHolder.setTitleText("Currency");

        if (name != null && rate != null) {
            textViewHolder.setDescriprionText("1 USD = " + rate + " " + name);
        } else {
            textViewHolder.setDescriprionText("-");
        }
    }
}
