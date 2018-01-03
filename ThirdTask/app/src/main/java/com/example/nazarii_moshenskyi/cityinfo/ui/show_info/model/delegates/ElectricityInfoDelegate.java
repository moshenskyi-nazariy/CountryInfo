package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.delegates;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ElectricityInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ViewHolderFactory;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

public class ElectricityInfoDelegate extends AdapterDelegate<List<RowType>> {

    private ViewHolderFactory.ElectricityViewHolder electricityViewHolder;

    @Override
    protected boolean isForViewType(@NonNull List<RowType> items, int position) {
        return items.get(position) instanceof ElectricityInfo;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return electricityViewHolder = (ViewHolderFactory.ElectricityViewHolder) ViewHolderFactory.createElectricityViewHolder(parent);
    }
    @Override
    protected void onBindViewHolder(@NonNull List<RowType> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        ElectricityInfo infoItem = (ElectricityInfo) items.get(position);

        String voltage = infoItem.getVoltage();
        String frequency = infoItem.getFrequency();
        String data = infoItem.getData();

        electricityViewHolder.setVoltage(voltage);
        electricityViewHolder.setFrequency(frequency);
        electricityViewHolder.setPlugs(data);

    }
}
