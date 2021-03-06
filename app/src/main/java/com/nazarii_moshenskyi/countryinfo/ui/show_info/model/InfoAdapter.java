package com.nazarii_moshenskyi.countryinfo.ui.show_info.model;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.delegates.CurrencyInfoDelegate;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.delegates.DangerInfoDelegate;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.delegates.ElectricityInfoDelegate;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.delegates.TimezoneInfoDelegate;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.delegates.WaterInfoDelegate;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.delegates.WeatherInfoDelegate;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import java.util.ArrayList;
import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter {
    private List<RowType> dataSet;
    private AdapterDelegatesManager<List<RowType>> delegatesManager;

    public InfoAdapter() {
        this.dataSet = new ArrayList<>(0);

        delegatesManager = new AdapterDelegatesManager<>();

        delegatesManager.addDelegate(new CurrencyInfoDelegate());
        delegatesManager.addDelegate(new ElectricityInfoDelegate());
        delegatesManager.addDelegate(new TimezoneInfoDelegate());
        delegatesManager.addDelegate(new WaterInfoDelegate());
        delegatesManager.addDelegate(new DangerInfoDelegate());
        delegatesManager.addDelegate(new WeatherInfoDelegate());
    }

    public void update(List<RowType> dataSet) {
        if (dataSet != null) {
            this.dataSet = dataSet;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return delegatesManager.getItemViewType(dataSet, position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        delegatesManager.onBindViewHolder(dataSet, position, holder);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
