package com.example.nazarii_moshenskyi.cityinfo.data.model;

import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ViewHolderFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timezone implements RowType {

    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getItemViewType() {
        return TEXT_ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        ViewHolderFactory.TextViewHolder textViewHolder = (ViewHolderFactory.TextViewHolder) viewHolder;
        textViewHolder.setTitleText("Timezone");
        textViewHolder.setDescriprionText(name);
    }
}
