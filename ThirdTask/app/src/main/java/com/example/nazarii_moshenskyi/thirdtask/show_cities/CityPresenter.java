package com.example.nazarii_moshenskyi.thirdtask.show_cities;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.thirdtask.R;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class CityPresenter implements ICityPresenter {
    private final Context context;
    private RecyclerView cityList;
    private CityAdapter adapter;

    public CityPresenter(Context context) {
        this.context = context;
    }

    public void setList(RecyclerView cityList) {
        this.cityList = cityList;
    }

    @Override
    public Observable<String> getOnItemClickListner() {
        return adapter.getOnClickListener();
    }

    @Override
    public void start() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        List<String> data = Arrays.asList(context.getResources().getStringArray(R.array.cities));

        adapter = new CityAdapter(context, data);

        cityList.setLayoutManager(layoutManager);
        cityList.setAdapter(adapter);
        cityList.setItemAnimator(new DefaultItemAnimator());
    }


}
