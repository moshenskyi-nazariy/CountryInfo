package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model;

import android.support.v7.widget.RecyclerView;

public interface RowType {
    int TEXT_ROW_TYPE = 0;
    int ELECTRICITY_ROW_TYPE = 1;

    int getItemViewType();

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder);
}
