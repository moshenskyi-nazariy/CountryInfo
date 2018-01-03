package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.delegates;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.CurrencyInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ViewHolderFactory;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

public class CurrencyInfoDelegate extends AdapterDelegate<List<RowType>> {
    private ViewHolderFactory.TextViewHolder currencyInfoHolder;
    private Resources resources;

    @Override
    protected boolean isForViewType(@NonNull List<RowType> items, int position) {
        return items.get(position) instanceof CurrencyInfo;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        resources = parent.getResources();
        return currencyInfoHolder = (ViewHolderFactory.TextViewHolder) ViewHolderFactory.createTextViewHolder(parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull List<RowType> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        currencyInfoHolder.setTitleText(R.string.currency_title);

        CurrencyInfo item = (CurrencyInfo) items.get(position);
        String name = item.getName();

        String rate = item.getRate();
        if (!(name.isEmpty() && rate.isEmpty())) {
            currencyInfoHolder.setDescriptionText(resources.getString(R.string.currency_description), rate, name);
        }
    }
}
