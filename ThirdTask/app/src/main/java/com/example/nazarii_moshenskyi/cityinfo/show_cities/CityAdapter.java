package com.example.nazarii_moshenskyi.cityinfo.show_cities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private List<Country> countries;
    private LayoutInflater inflater;
    private final PublishSubject<String> onClicksubject = PublishSubject.create();

    public CityAdapter(Context context, List<Country> countries) {
        this.countries = countries;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, int position) {
        final String countryName = countries.get(position).getName();
        holder.countryName.setText(countryName);
        holder.countryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicksubject.onNext(countryName);
            }
        });
    }

    public Observable<String> getOnClickListener() {
        return onClicksubject.hide();
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView countryName;

        public ViewHolder(View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.list_item);
        }
    }
}
