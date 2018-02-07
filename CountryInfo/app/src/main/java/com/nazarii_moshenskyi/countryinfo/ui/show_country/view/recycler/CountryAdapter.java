package com.nazarii_moshenskyi.countryinfo.ui.show_country.view.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nazarii_moshenskyi.countryinfo.R;
import com.nazarii_moshenskyi.countryinfo.data.model.Country;
import com.nazarii_moshenskyi.countryinfo.ui.show_country.view.AdapterOnClickListener;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private final AdapterOnClickListener listener;
    private List<Country> countries;

    public CountryAdapter(AdapterOnClickListener listener) {
        this.listener = listener;
        countries = new ArrayList<>(0);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    public void update(List<Country> countries) {
        if (countries != null) {
            this.countries = countries;
            notifyDataSetChanged();
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Country country = countries.get(position);
        String countryName = country.getName();

        holder.countryName.setText(countryName);
        holder.countryName.setOnClickListener(v -> listener.onClick(country));
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
