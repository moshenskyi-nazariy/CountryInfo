package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.delegates;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.TimezoneInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ViewHolderFactory;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

public class TimezoneInfoDelegate extends AdapterDelegate<List<RowType>> {
    private ViewHolderFactory.TextViewHolder timezoneViewHolder;

    @Override
    protected boolean isForViewType(@NonNull List<RowType> items, int position) {
        return items.get(position) instanceof TimezoneInfo;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return timezoneViewHolder = (ViewHolderFactory.TextViewHolder) ViewHolderFactory.createTextViewHolder(parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull List<RowType> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        TimezoneInfo infoItem = (TimezoneInfo) items.get(position);

        timezoneViewHolder.setTitleText(R.string.timezone_title_text);
        timezoneViewHolder.setDescriptionText(infoItem.getName());
    }
}
