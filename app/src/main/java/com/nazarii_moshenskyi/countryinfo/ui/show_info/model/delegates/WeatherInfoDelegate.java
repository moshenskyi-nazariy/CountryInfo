package com.nazarii_moshenskyi.countryinfo.ui.show_info.model.delegates;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.RowType;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.ViewHolderFactory;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.WeatherInfo;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

public class WeatherInfoDelegate extends AdapterDelegate<List<RowType>> {

    private ViewHolderFactory.WeatherViewHolder weatherViewHolder;

    @Override
    protected boolean isForViewType(@NonNull List<RowType> items, int position) {
        return items.get(position) instanceof WeatherInfo;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return weatherViewHolder = (ViewHolderFactory.WeatherViewHolder) ViewHolderFactory.createWeatherViewHolder(parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull List<RowType> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        WeatherInfo info = (WeatherInfo) items.get(position);
        weatherViewHolder.setWeather(info);
    }
}
