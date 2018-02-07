package com.nazarii_moshenskyi.countryinfo.ui.show_info.model.delegates;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.nazarii_moshenskyi.countryinfo.R;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.RowType;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.ViewHolderFactory;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.WaterInfo;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

public class WaterInfoDelegate extends AdapterDelegate<List<RowType>> {
    private ViewHolderFactory.TextViewHolder waterViewHolder;

    @Override
    protected boolean isForViewType(@NonNull List<RowType> items, int position) {
        return items.get(position) instanceof WaterInfo;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return waterViewHolder = (ViewHolderFactory.TextViewHolder) ViewHolderFactory.createTextViewHolder(parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull List<RowType> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        WaterInfo infoItem = (WaterInfo) items.get(position);

        waterViewHolder.setTitleText(R.string.water_title_text);
        waterViewHolder.setDescriptionText(infoItem.getShortInfo());
    }
}
