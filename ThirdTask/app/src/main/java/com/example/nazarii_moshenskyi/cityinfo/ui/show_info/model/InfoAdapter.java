package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter {
    private List<RowType> dataSet;

    public InfoAdapter() {
        this.dataSet = new ArrayList<>(0);
    }

    public void update(List<RowType> dataSet) {
        if(dataSet != null) {
            this.dataSet = dataSet;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return dataSet.get(position).getItemViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolderFactory.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        dataSet.get(position).onBindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
