package com.example.nazarii_moshenskyi.cityinfo.show_cities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    private List<Country> countries;

    public CityAdapter(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, int position) {
        Country country = countries.get(position);
        String countryName = country.getName();

        int cityCount = country.getCities().size();

        holder.countryName.setText(countryName);
        holder.cityCount.setText(String.valueOf(cityCount));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView countryName;
        private TextView cityCount;

        ViewHolder(View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.country_name);
            cityCount = itemView.findViewById(R.id.city_count);
        }
    }
}
