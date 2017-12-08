package com.example.nazarii_moshenskyi.thirdtask.show_cities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nazarii_moshenskyi.thirdtask.R;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private List<String> cities;
    private LayoutInflater inflater;

    public CityAdapter(Context context, List<String> cities) {
        this.cities = cities;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, int position) {
        String city = cities.get(position);
        holder.cityName.setText(city);
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView cityName;

        public ViewHolder(View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.list_item);
        }
    }
}
