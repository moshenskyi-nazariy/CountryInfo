package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.delegates;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.DangerInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ElectricityInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ViewHolderFactory;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

public class DangerInfoDelegate extends AdapterDelegate<List<RowType>> {
    private ViewHolderFactory.DangerViewHolder dangerViewHolder;

    @Override
    protected boolean isForViewType(@NonNull List<RowType> items, int position) {
        return items.get(position) instanceof DangerInfo;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return dangerViewHolder = (ViewHolderFactory.DangerViewHolder) ViewHolderFactory.createDangerViewHolder(parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull List<RowType> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        DangerInfo infoItem = (DangerInfo) items.get(position);

        int level = infoItem.getLevel();
        dangerViewHolder.setLevel(String.valueOf(level));
    }
}
