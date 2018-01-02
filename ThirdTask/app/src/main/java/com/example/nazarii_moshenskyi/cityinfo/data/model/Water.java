package com.example.nazarii_moshenskyi.cityinfo.data.model;

import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ViewHolderFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Water implements RowType {

    @SerializedName("short")
    @Expose
    private String _short;
    @SerializedName("full")
    @Expose
    private String full;

    public String getShort() {
        return _short;
    }

    public void setShort(String _short) {
        this._short = _short;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    @Override
    public int getItemViewType() {
        return TEXT_ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        ViewHolderFactory.TextViewHolder textViewHolder = (ViewHolderFactory.TextViewHolder) viewHolder;
        textViewHolder.setTitleText("Water rate");
        textViewHolder.setDescriprionText(_short);
    }
}
