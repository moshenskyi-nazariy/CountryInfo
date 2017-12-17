package com.example.nazarii_moshenskyi.cityinfo.ui.show_cities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.RecyclerViewOnClickListener;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private final RecyclerViewOnClickListener listener;
    private List<Country> countries;

    public CountryAdapter(List<Country> countries, RecyclerViewOnClickListener listener) {
        this.countries = countries;
        this.listener = listener;
    }

    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryAdapter.ViewHolder holder, int position) {
        final Country country = countries.get(position);
        String countryName = country.getName();

        holder.countryName.setText(countryName);
        holder.countryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(country);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView countryName;

        ViewHolder(View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.country_name);
        }
    }
}
